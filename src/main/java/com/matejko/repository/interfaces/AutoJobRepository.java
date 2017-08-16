package com.matejko.repository.interfaces;

import com.matejko.model.entity.AutoJob;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Mikołaj Matejko on 31.07.2017 as part of ogame-expander
 */
public interface AutoJobRepository extends CrudRepository<AutoJob, Long>, AutoJobRepositoryExt {
    Iterable<AutoJob> findByActiveTrue();
}
