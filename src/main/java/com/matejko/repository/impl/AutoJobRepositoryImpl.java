package com.matejko.repository.impl;

import com.matejko.model.entity.AutoJob;
import com.matejko.repository.interfaces.AutoJobRepositoryExt;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

/**
 * Created by Mikołaj Matejko on 31.07.2017 as part of ogame-expander
 */
@Repository
@RequiredArgsConstructor
public class AutoJobRepositoryImpl implements AutoJobRepositoryExt {

    private final EntityManager em;

    @Override
    public Optional<AutoJob> findByUsernameAndStrategy(final String username, final String strategy) {
        return em.createQuery("select a from AutoJob a where a.user.username = :username and a.strategy = :strategy", AutoJob.class)
                .setParameter("username", username)
                .setParameter("strategy", strategy)
                .getResultList()
                .stream()
                .findFirst();
    }
    public List<AutoJob> findByUsername(final String username) {
        return em.createQuery("select a from AutoJob a where a.user.username = :username", AutoJob.class)
                .setParameter("username", username)
                .getResultList();
    }
}
