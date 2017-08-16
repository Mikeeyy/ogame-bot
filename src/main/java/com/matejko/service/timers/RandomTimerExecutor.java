package com.matejko.service.timers;

import com.matejko.exceptions.ServiceException;
import com.matejko.model.common.TimerEnum;

import javax.inject.Named;

/**
 * Created by Mikołaj Matejko on 31.07.2017 as part of ogame-expander
 */
@Named
public class RandomTimerExecutor implements TimerExecutor {
    @Override
    public TimerEnum enumValue() {
        return TimerEnum.RANDOM;
    }

    @Override
    public void execute() throws ServiceException {

    }
}
