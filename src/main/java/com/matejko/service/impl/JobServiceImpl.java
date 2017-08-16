package com.matejko.service.impl;

import com.matejko.exceptions.RepositoryException;
import com.matejko.exceptions.ServiceException;
import com.matejko.model.entity.AutoJob;
import com.matejko.model.entity.Job;
import com.matejko.model.entity.JobHistory;
import com.matejko.model.entity.User;
import com.matejko.model.request.AutoJobRequest;
import com.matejko.model.request.NextJobRequest;
import com.matejko.model.standard.DecryptedUser;
import com.matejko.repository.interfaces.AutoJobRepository;
import com.matejko.repository.interfaces.JobHistoryRepository;
import com.matejko.repository.interfaces.JobRepository;
import com.matejko.repository.interfaces.UserRepository;
import com.matejko.service.interfaces.EncryptionService;
import com.matejko.service.interfaces.Executor;
import com.matejko.service.interfaces.JobService;
import org.springframework.scheduling.annotation.Async;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.List;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
@Named
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;
    private final UserRepository userRepository;
    private final AutoJobRepository autoJobRepository;
    private final JobHistoryRepository jobHistoryRepository;
    private final EncryptionService encryptionService;

    @Inject
    public JobServiceImpl(final JobRepository jobRepository,
                          final UserRepository userRepository,
                          final AutoJobRepository autoJobRepository,
                          final JobHistoryRepository jobHistoryRepository,
                          final EncryptionService encryptionService) {
        this.jobRepository = jobRepository;
        this.userRepository = userRepository;
        this.autoJobRepository = autoJobRepository;
        this.jobHistoryRepository = jobHistoryRepository;
        this.encryptionService = encryptionService;
    }

    @Async
    @Override
    public void executeNextJob(final NextJobRequest job) throws ServiceException {
        try {
            List<Job> jobsByStrategy = jobRepository.getJobsByStrategy(job.getStrategy());
            User user = userRepository.findByUsername(job.getUser().getUsername())
                    .orElseThrow(() -> new ServiceException(String.format("Could not find user [%s] in database", job.getUser().getUsername())));
            DecryptedUser decryptedUser = new DecryptedUser(user.getUsername(),
                    encryptionService.decrypt(user.getPassword()), user.getUniversum());

            Executor<List<JobHistory>> executor = new NextJobExecutor(decryptedUser, jobsByStrategy);
            executor.execute().forEach(f -> {
                f.setUser(user);

                jobHistoryRepository.save(f);
            });
        } catch (RepositoryException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void setAutoJobs(final List<AutoJobRequest> jobs) throws ServiceException {
        for (final AutoJobRequest job : jobs) {
            AutoJob autoJob = autoJobRepository.findByUsernameAndStrategy(job.getUser().getUsername(), job.getStrategy())
                    .map(dbJob -> {
                        dbJob.setActive(job.getActive());
                        dbJob.setModificationDate(new Date());
                        return dbJob;
                    })
                    .orElse(createNewAutoJob(job));
            autoJobRepository.save(autoJob);
        }
    }

    private AutoJob createNewAutoJob(final AutoJobRequest job) throws ServiceException {
        AutoJob newJob = new AutoJob();
        newJob.setCreationDate(new Date());
        newJob.setStrategy(job.getStrategy());
        newJob.setActive(job.getActive());
        newJob.setUser(userRepository
                .findByUsername(job.getUser().getUsername())
                .orElseThrow(() -> new ServiceException(String.format("User [%s] has not been found", job.getUser().getUsername()))));
        return newJob;
    }
}
