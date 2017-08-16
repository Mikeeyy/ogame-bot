package com.matejko.service.timers;

import com.matejko.exceptions.ServiceException;
import com.matejko.model.common.TimerEnum;

/**
 * Created by Mikołaj Matejko on 31.07.2017 as part of ogame-expander
 */
public interface TimerExecutor {
    TimerEnum enumValue();

    void execute() throws ServiceException;
}
