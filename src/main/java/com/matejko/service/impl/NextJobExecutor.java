package com.matejko.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.matejko.helper.PlanetVisitatorHelper;
import com.matejko.model.common.OperatingSystem;
import com.matejko.model.entity.Job;
import com.matejko.model.entity.JobHistory;
import com.matejko.model.standard.Building;
import com.matejko.model.standard.DecryptedUser;
import com.matejko.service.interfaces.OgameWebConnector;

/**
 * Created by Mikołaj Matejko on 16.08.2017 as part of ogame-expander
 */
public class NextJobExecutor extends ConnectionExecutor<OgameWebConnector, List<JobHistory>> {
    private final DecryptedUser user;
    private final List<Job> jobsByStrategy;
    private final ChromeOgameWebConnector ogameWebConnector;



    public NextJobExecutor(final DecryptedUser user, final List<Job> jobsByStrategy, final OperatingSystem system) {
        this.user = user;
        this.jobsByStrategy = jobsByStrategy;

        ogameWebConnector = new ChromeOgameWebConnector(user.getUniversum(), system);
    }

    @Override
    protected OgameWebConnector connector() {
        return ogameWebConnector;
    }

    @Override
    protected List<JobHistory> action() {
        ogameWebConnector.logIn(user);

        PlanetVisitatorHelper helper = new PlanetVisitatorHelper();

        return ogameWebConnector.collectProfileData()
                .getPlanets()
                .stream()
                .map(planet -> {
                    helper.visitNextPlanet(ogameWebConnector.collectProfileData().getPlanets());

                    return findNextJob(jobsByStrategy, ogameWebConnector.collectBuildings())
                            .filter(f -> ogameWebConnector.build(f.getBuildingEnum()))
                            .map(f -> {
                                JobHistory jobHistory = new JobHistory();
                                jobHistory.setCreationDate(new Date());
                                jobHistory.setBuildingEnum(f.getBuildingEnum());
                                jobHistory.setLevel(f.getLevel());
                                jobHistory.setPlanet(planet.getPosition());

                                return jobHistory;
                            });

                })
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }


    private Optional<Job> findNextJob(final List<Job> jobs, final List<Building> currentBuildings) {
        for (final Job job : jobs) {
            if (currentBuildings.stream()
                    .filter(f -> f.getBuildingEnum().equals(job.getBuildingEnum()))
                    .anyMatch(f -> f.getLevel() < job.getLevel()))
                return Optional.of(job);
        }

        return Optional.empty();
    }
}
