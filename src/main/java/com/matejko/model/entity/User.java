package com.matejko.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
@Entity
public class User extends BaseEntity {
    private String username;
    private String password;
    private String universum;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<JobHistory> historicalJobs;

    public User() {
    }

    public User(final String username, final String password, final String universum) {
        this.username = username;
        this.password = password;
        this.universum = universum;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getUniversum() {
        return universum;
    }

    public void setUniversum(final String universum) {
        this.universum = universum;
    }

    public Set<JobHistory> getHistoricalJobs() {
        this.historicalJobs = new HashSet<>();
        return historicalJobs;
    }

    public void setHistoricalJobs(final Set<JobHistory> historicalJobs) {
        this.historicalJobs = historicalJobs;
    }
}
