package com.matejko.service.impl;

import java.util.Date;
import java.util.List;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Async;

import com.matejko.exceptions.RepositoryException;
import com.matejko.exceptions.ServiceException;
import com.matejko.model.common.OperatingSystem;
import com.matejko.model.entity.AutoJob;
import com.matejko.model.request.AutoJobRequest;
import com.matejko.model.request.NextJobRequest;
import com.matejko.model.standard.DecryptedUser;
import com.matejko.repository.interfaces.AutoJobRepository;
import com.matejko.repository.interfaces.JobHistoryRepository;
import com.matejko.repository.interfaces.JobRepository;
import com.matejko.repository.interfaces.UserRepository;
import com.matejko.service.interfaces.EncryptionService;
import com.matejko.service.interfaces.JobService;

import lombok.val;

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
	private final OperatingSystem system;

	public JobServiceImpl(final JobRepository jobRepository, final UserRepository userRepository, final AutoJobRepository autoJobRepository,
			final JobHistoryRepository jobHistoryRepository, final EncryptionService encryptionService,
			@Value("${system.operating}") final OperatingSystem system) {
		this.jobRepository = jobRepository;
		this.userRepository = userRepository;
		this.autoJobRepository = autoJobRepository;
		this.jobHistoryRepository = jobHistoryRepository;
		this.encryptionService = encryptionService;
		this.system = system;
	}

	@Async
	@Override
	public void executeNextJob(final NextJobRequest job) throws ServiceException {
		try {
			val jobsByStrategy = jobRepository.getJobsByStrategy(job.getStrategy());

			val user = userRepository.findByUsername(job.getUser().getUsername())
					.orElseThrow(() -> new ServiceException(String.format("Could not find user [%s] in database", job.getUser().getUsername())));

			val decryptedUser = new DecryptedUser(user.getUsername(), encryptionService.decrypt(user.getPassword()), user.getUniversum());

			val executor = new NextJobExecutor(decryptedUser, jobsByStrategy, system);
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
		for (val job : jobs) {
			val autoJob = autoJobRepository.findByUsernameAndStrategy(job.getUser().getUsername(), job.getStrategy()).map(dbJob -> {
				dbJob.setActive(job.getActive());
				dbJob.setModificationDate(new Date());
				return dbJob;
			}).orElse(createNewAutoJob(job));
			autoJobRepository.save(autoJob);
		}
	}

	private AutoJob createNewAutoJob(final AutoJobRequest job) throws ServiceException {
		val newJob = new AutoJob();
		newJob.setCreationDate(new Date());
		newJob.setStrategy(job.getStrategy());
		newJob.setActive(job.getActive());
		newJob.setUser(userRepository.findByUsername(job.getUser().getUsername())
				.orElseThrow(() -> new ServiceException(String.format("User [%s] has not been found", job.getUser().getUsername()))));
		return newJob;
	}

	@Override
	public void removeByUsername(final String name) {
		autoJobRepository.findByUsername(name).forEach(autoJobRepository::delete);
	}
}
