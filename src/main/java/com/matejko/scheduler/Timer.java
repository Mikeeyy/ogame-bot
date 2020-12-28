package com.matejko.scheduler;

import javax.inject.Inject;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.matejko.model.common.TimerEnum;
import com.matejko.service.interfaces.TimerService;

/**
 * Created by Mikołaj Matejko on 30.07.2017 as part of ogame-expander
 */
@Component
public class Timer {

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
