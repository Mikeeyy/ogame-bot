package com.matejko.controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.matejko.exceptions.ServiceException;
import com.matejko.model.request.AutoJobRequest;
import com.matejko.model.request.NextJobRequest;
import com.matejko.model.request.SettingsRequest;
import com.matejko.model.request.UserRequest;
import com.matejko.service.interfaces.JobService;
import com.matejko.service.interfaces.TimerService;
import com.matejko.service.interfaces.UserService;

import lombok.RequiredArgsConstructor;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
@RestController
@RequestMapping("/job")
@RequiredArgsConstructor
public class RequestController {

    private final JobService jobService;
    private final TimerService timerService;
    private final UserService userService;

    @RequestMapping(value = "/next", method = RequestMethod.POST, consumes = "application/json")
    public void executeNextJob(@RequestBody final List<NextJobRequest> jobs) throws ServiceException {
        for (final NextJobRequest job : jobs)
            jobService.executeNextJob(job);
    }

    @RequestMapping(value = "/settings", method = RequestMethod.POST, consumes = "application/json")
    public void setTimerSettings(@RequestBody final SettingsRequest settings) throws ServiceException {
        timerService.saveSettings(settings);
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST, consumes = "application/json")
    public void setUsers(@RequestBody final List<UserRequest> users) throws ServiceException {
        userService.save(users);
    }

    @RequestMapping(value = "/users/remove/{name}", method = RequestMethod.POST, consumes = "application/json")
    public void removeUsers(@PathVariable final String name) throws ServiceException {
        jobService.removeByUsername(name);
        userService.remove(name);
    }

    @RequestMapping(value = "/auto", method = RequestMethod.POST, consumes = "application/json")
    public void setAutoJobs(@RequestBody final List<AutoJobRequest> jobs) throws ServiceException {
        jobService.setAutoJobs(jobs);
    }
}
