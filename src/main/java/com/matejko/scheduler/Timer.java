package com.matejko.scheduler;

import com.matejko.model.common.TimerEnum;
import com.matejko.service.interfaces.TimerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.inject.Inject;

/**
 * Created by Mikołaj Matejko on 30.07.2017 as part of ogame-expander
 */
@Component
public class Timer {

    private static final Logger logger = LoggerFactory.getLogger(Timer.class);

    private final TimerService timerService;

    @Inject
    public Timer(final TimerService timerService) {
        this.timerService = timerService;
    }

    @Scheduled(fixedDelay = 10000)
    public void invokeJob() {
        for (final TimerEnum timerEnum : TimerEnum.values())
            timerService.invokeTimer(timerEnum);
    }
}
