package com.matejko.service.interfaces;

import com.matejko.exceptions.ServiceException;
import com.matejko.model.request.AutoJobRequest;
import com.matejko.model.request.NextJobRequest;

import java.util.List;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
public interface JobService {
    /**
     * Getting all jobs for given strategy, checking which job should be executed as next one and executing it
     *
     * @param job from request
     * @throws ServiceException exception
     */
    void executeNextJob(NextJobRequest job) throws ServiceException;

    /**
     * Setting jobs connected with users that are going to be executed by a timer
     *
     * @param jobs from request
     * @throws ServiceException exception
     */
    void setAutoJobs(List<AutoJobRequest> jobs) throws ServiceException;
}
