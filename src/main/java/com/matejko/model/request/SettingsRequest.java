package com.matejko.model.request;

import com.matejko.model.common.TimerEnum;

/**
 * Created by Mikołaj Matejko on 30.07.2017 as part of ogame-expander
 */
public class SettingsRequest {
    private TimerEnum timer;
    private Long interval;
    private Boolean active;

    public TimerEnum getTimer() {
        return timer;
    }

    public void setTimer(final TimerEnum timer) {
        this.timer = timer;
    }

    public Long getInterval() {
        return interval;
    }

    public void setInterval(final Long interval) {
        this.interval = interval;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }
}
