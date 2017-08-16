package com.matejko.service.interfaces;

import com.matejko.exceptions.ServiceException;
import com.matejko.model.common.TimerEnum;
import com.matejko.model.request.SettingsRequest;

/**
 * Created by Mikołaj Matejko on 30.07.2017 as part of ogame-expander
 */
public interface TimerService {
    void invokeTimer(TimerEnum timerEnum);

    void saveSettings(SettingsRequest settings) throws ServiceException;
}
