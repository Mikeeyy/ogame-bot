package com.matejko.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.matejko.model.common.TimerEnum;

/**
 * Created by Mikołaj Matejko on 30.07.2017 as part of ogame-expander
 */
@Entity
public class TimerSettings extends BaseEntity {
    @Column(nullable = false)
    private Long timerInterval;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastInvocation;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private TimerEnum timer;

    @Column(nullable = false)
    private Boolean active;

    public Long getTimerInterval() {
        return timerInterval;
    }

    public void setTimerInterval(final Long timerInterval) {
        this.timerInterval = timerInterval;
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
