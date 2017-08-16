package com.matejko.controller;

import com.matejko.exceptions.ServiceException;
import com.matejko.model.request.AutoJobRequest;
import com.matejko.model.request.NextJobRequest;
import com.matejko.model.request.SettingsRequest;
import com.matejko.model.request.UserRequest;
import com.matejko.service.interfaces.JobService;
import com.matejko.service.interfaces.TimerService;
import com.matejko.service.interfaces.UserService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
@RestController
@RequestMapping("/job")
public class RequestController {

    private final JobService jobService;
    private final TimerService timerService;
    private final UserService userService;

    @Inject
    public RequestController(final JobService jobService,
                             final TimerService timerService,
                             final UserService userService) {
        this.jobService = jobService;
        this.timerService = timerService;
        this.userService = userService;
    }

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

    @RequestMapping(value = "/auto", method = RequestMethod.POST, consumes = "application/json")
    public void setAutoJobs(@RequestBody final List<AutoJobRequest> jobs) throws ServiceException {
        jobService.setAutoJobs(jobs);
    }
}
