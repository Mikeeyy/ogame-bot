package com.matejko.repository.interfaces;

import com.matejko.model.entity.Parameter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Mikołaj Matejko on 13.08.2017 as part of ogame-expander
 */
@Repository
public interface ParameterRepository extends CrudRepository<Parameter, Long> {
}
