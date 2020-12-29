package com.matejko.repository.interfaces;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.matejko.model.entity.User;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByUsername(String username);
}
