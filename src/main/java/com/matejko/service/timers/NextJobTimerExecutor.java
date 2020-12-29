package com.matejko.service.timers;

import com.matejko.exceptions.ServiceException;
import com.matejko.model.common.TimerEnum;
import com.matejko.model.entity.AutoJob;
import com.matejko.model.request.NextJobRequest;
import com.matejko.model.request.UserRequest;
import com.matejko.repository.interfaces.AutoJobRepository;
import com.matejko.service.interfaces.JobService;

import javax.inject.Inject;
import javax.inject.Named;

import lombok.RequiredArgsConstructor;

/**
 * Created by Mikołaj Matejko on 31.07.2017 as part of ogame-expander
 */
@Named
@RequiredArgsConstructor
public class NextJobTimerExecutor implements TimerExecutor {

    private final AutoJobRepository autoJobRepository;
    private final JobService jobService;

    @Override
    public TimerEnum enumValue() {
        return TimerEnum.NEXT_JOB;
    }

    @Override
    public void execute() throws ServiceException {
        for (final AutoJob job : autoJobRepository.findByActiveTrue()) {
            final UserRequest user = new UserRequest();
            user.setUsername(job.getUser().getUsername());

            final NextJobRequest request = new NextJobRequest();
            request.setStrategy(job.getStrategy());
            request.setUser(user);

            jobService.executeNextJob(request);

            incrementInvocations(job);
        }
    }

    private void incrementInvocations(final AutoJob job) {
        Long timesInvoked = job.getTimesInvoked();

        if (timesInvoked == null)
            timesInvoked = 0L;

        timesInvoked++;

        job.setTimesInvoked(timesInvoked);
        autoJobRepository.save(job);
    }
}
