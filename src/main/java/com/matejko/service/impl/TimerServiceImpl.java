package com.matejko.service.impl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;

import com.matejko.exceptions.ServiceException;
import com.matejko.model.common.TimerEnum;
import com.matejko.model.entity.TimerSettings;
import com.matejko.model.request.SettingsRequest;
import com.matejko.repository.interfaces.TimerSettingsRepository;
import com.matejko.scheduler.Timer;
import com.matejko.service.interfaces.JobService;
import com.matejko.service.interfaces.TimerService;
import com.matejko.service.timers.TimerFactory;

/**
 * Created by Mikołaj Matejko on 30.07.2017 as part of ogame-expander
 */
@Named
public class TimerServiceImpl implements TimerService {
    private static final Logger logger = LoggerFactory.getLogger(Timer.class);

    private final JobService jobService;
    private final TimerSettingsRepository timerSettingsRepository;
    private final TimerFactory timerFactory;

    @Inject
    public TimerServiceImpl(final JobService jobService,
                            final TimerSettingsRepository timerSettingsRepository,
                            final TimerFactory timerFactory) {
        this.jobService = jobService;
        this.timerSettingsRepository = timerSettingsRepository;
        this.timerFactory = timerFactory;
    }

    @Async
    @Override
    public void invokeTimer(final TimerEnum timerEnum) {
        Optional<TimerSettings> settingsOptional = timerSettingsRepository.findByTimer(timerEnum);

        settingsOptional
                .filter(TimerSettings::getActive)
                .ifPresent(settings -> {
                    Date nextInvocation = nextInvocationDate(settings.getLastInvocation(),
                            settings.getTimerInterval());
                    if (nextInvocation.after(new Date())) {
                        logger.debug(String.format("Timer [%s] won't be invoked now, next invocation in [%s]",
                                settings.getTimer().toString(), calculateNextInvocationInMinutes(nextInvocation)));
                        return;
                    }

                    try {
                        timerFactory.getTimerExecutor(settings.getTimer()).execute();
                        updateTimerDate(settings);
                    } catch (ServiceException e) {
                        logger.error("invokeTimer", e);
                    }
                });
    }

    private void updateTimerDate(final TimerSettings settings) {
        settings.setModificationDate(new Date());
        settings.setLastInvocation(new Date());
        timerSettingsRepository.save(settings);
    }

    @Override
    public void saveSettings(final SettingsRequest settingsReq) throws ServiceException {
        TimerSettings timerSettings = timerSettingsRepository.findByTimer(settingsReq.getTimer())
                .map(settings -> {
                    Optional.ofNullable(settingsReq.getInterval())
                            .ifPresent(settings::setTimerInterval);

                    Optional.ofNullable(settingsReq.getActive())
                            .ifPresent(settings::setActive);

                    settings.setModificationDate(new Date());
                    return settings;
                })
                .orElse(createNewTimerSettings(settingsReq));

        timerSettingsRepository.save(timerSettings);
    }

    private TimerSettings createNewTimerSettings(final SettingsRequest settingsReq) {
        TimerSettings timerSettings = new TimerSettings();
        timerSettings.setTimer(settingsReq.getTimer());
        timerSettings.setTimerInterval(settingsReq.getInterval());
        timerSettings.setActive(settingsReq.getActive());
        timerSettings.setCreationDate(new Date());
        return timerSettings;
    }

    private Date nextInvocationDate(final Date lastInvocation, final Long interval) {
        Date firstPossibleDate;
        try {
            DateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
            firstPossibleDate = simpleDateFormat.parse("01-01-1970");
        } catch (ParseException e) {
            firstPossibleDate = new Date();
        }

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(lastInvocation == null ? firstPossibleDate : lastInvocation);
        calendar.setTimeInMillis(calendar.getTimeInMillis() + interval);
        return calendar.getTime();
    }


    private String calculateNextInvocationInMinutes(final Date nextInvocation) {
        Calendar now = Calendar.getInstance();
        now.setTime(new Date());

        Calendar nextInvocationCalendar = Calendar.getInstance();
        nextInvocationCalendar.setTime(nextInvocation);
        long timeLeft = nextInvocationCalendar.getTimeInMillis() - now.getTimeInMillis();

        return String.format("%d minutes, %d seconds",
                TimeUnit.MILLISECONDS.toMinutes(timeLeft),
                TimeUnit.MILLISECONDS.toSeconds(timeLeft) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(timeLeft))
        );
    }
}
