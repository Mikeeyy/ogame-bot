package com.matejko.repository.interfaces;

import com.matejko.exceptions.RepositoryException;
import com.matejko.model.entity.Job;

import java.util.List;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
public interface JobRepository {
    List<Job> getJobsByStrategy(final String strategy) throws RepositoryException;
}
