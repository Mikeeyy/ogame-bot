package com.matejko.repository.impl;

import com.matejko.exceptions.RepositoryException;
import com.matejko.model.common.BuildingEnum;
import com.matejko.model.entity.Job;
import com.matejko.repository.interfaces.JobRepository;

import javax.inject.Named;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
@Named("fileJobRepository")
public class JobRepositoryImpl implements JobRepository {
    @Override
    public List<Job> getJobsByStrategy(final String strategy) throws RepositoryException {
        try (Stream<String> stream = Files.lines(Paths.get(String.format("src\\main\\resources\\strategies\\%s.strategy", strategy)))) {
            return stream
                    .map(this::parseJobLine)
                    .sorted(Comparator.comparing(Job::getOrderId))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RepositoryException(e);
        }
    }

    private Job parseJobLine(final String line) {
        String[] strings = line.split(" ");
        return new Job(Long.valueOf(strings[0]), BuildingEnum.valueOf(strings[1]), Long.valueOf(strings[2]));
    }
}