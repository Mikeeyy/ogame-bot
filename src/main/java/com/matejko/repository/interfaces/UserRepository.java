package com.matejko.repository.interfaces;

import com.matejko.model.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
