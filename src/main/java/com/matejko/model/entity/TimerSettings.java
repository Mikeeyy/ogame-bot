package com.matejko.model.entity;

import com.matejko.model.common.TimerEnum;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Mikołaj Matejko on 30.07.2017 as part of ogame-expander
 */
@Entity
public class TimerSettings extends BaseEntity {
    @Column(nullable = false)
    private Long interval;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastInvocation;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private TimerEnum timer;

    @Column(nullable = false)
    private Boolean active;

    public Long getInterval() {
        return interval;
    }

    public void setInterval(final Long interval) {
        this.interval = interval;
    }

    public Date getLastInvocation() {
        return lastInvocation;
    }

    public void setLastInvocation(final Date lastInvocation) {
        this.lastInvocation = lastInvocation;
    }

    public TimerEnum getTimer() {
        return timer;
    }

    public void setTimer(final TimerEnum timer) {
        this.timer = timer;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }
}
