package com.matejko.repository.interfaces;

import com.matejko.model.common.TimerEnum;
import com.matejko.model.entity.TimerSettings;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by Mikołaj Matejko on 30.07.2017 as part of ogame-expander
 */
@Repository
public interface TimerSettingsRepository extends CrudRepository<TimerSettings, Long> {
    Optional<TimerSettings> findByTimer(TimerEnum timer);
}
