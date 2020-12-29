package com.matejko.service.timers;

import com.matejko.model.common.TimerEnum;
import org.hibernate.service.spi.ServiceException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;
import java.util.Objects;

import lombok.RequiredArgsConstructor;

/**
 * Created by Mikołaj Matejko on 31.07.2017 as part of ogame-expander
 */
@Named
@RequiredArgsConstructor
public class TimerFactory {

    private final List<TimerExecutor> executors;

    public TimerExecutor getTimerExecutor(TimerEnum timer) {
        return executors.stream()
                .filter(executor -> Objects.equals(executor.enumValue(), timer))
                .findFirst()
                .orElseThrow(() -> new ServiceException(String.format("Could not find executor for " +
                        "timer type [%s]", timer.toString())));
    }
}
