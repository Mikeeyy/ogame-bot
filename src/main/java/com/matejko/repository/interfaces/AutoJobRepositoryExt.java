package com.matejko.repository.interfaces;

import com.matejko.model.entity.AutoJob;

import java.util.Optional;

/**
 * Created by Mikołaj Matejko on 31.07.2017 as part of ogame-expander
 */
public interface AutoJobRepositoryExt {
    Optional<AutoJob> findByUsernameAndStrategy(String username, String strategy);
}
