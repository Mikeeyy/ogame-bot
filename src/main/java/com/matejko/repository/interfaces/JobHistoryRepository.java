package com.matejko.repository.interfaces;

import com.matejko.model.entity.JobHistory;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Mikołaj Matejko on 01.08.2017 as part of ogame-expander
 */
public interface JobHistoryRepository extends CrudRepository<JobHistory, Long> {
}
