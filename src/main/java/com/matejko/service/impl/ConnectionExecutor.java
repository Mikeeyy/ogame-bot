package com.matejko.service.impl;

import com.matejko.exceptions.ServiceException;
import com.matejko.service.interfaces.Executor;
import com.matejko.service.interfaces.WebConnector;

/**
 * Created by Mikołaj Matejko on 16.08.2017 as part of ogame-expander
 */
public abstract class ConnectionExecutor<T extends WebConnector, U> implements Executor<U> {
    @Override
    public U execute() throws ServiceException {
        try (T connector = connector()) {
            return action();
        } catch (Exception e) {
            throw new ServiceException(e);
        }
    }

    protected abstract T connector();

    protected abstract U action();
}
