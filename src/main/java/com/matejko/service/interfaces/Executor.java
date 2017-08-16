package com.matejko.service.interfaces;

import com.matejko.exceptions.ServiceException;

/**
 * Created by Mikołaj Matejko on 16.08.2017 as part of ogame-expander
 */
public interface Executor<T> {
    T execute() throws ServiceException;
}
