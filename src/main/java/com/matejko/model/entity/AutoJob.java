package com.matejko.model.entity;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 * Created by Mikołaj Matejko on 31.07.2017 as part of ogame-expander
 */
@Entity
public class AutoJob extends BaseEntity {
    @OneToOne
    private User user;
    private String strategy;
    private Boolean active;
    private Long timesInvoked;

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(final String strategy) {
        this.strategy = strategy;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }

    public Long getTimesInvoked() {
        return timesInvoked;
    }

    public void setTimesInvoked(final Long timesInvoked) {
        this.timesInvoked = timesInvoked;
    }
}
