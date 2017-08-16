package com.matejko.model.request;

/**
 * Created by Mikołaj Matejko on 31.07.2017 as part of ogame-expander
 */
public class AutoJobRequest extends JobRequest {
    private Boolean active;

    public Boolean getActive() {
        return active;
    }

    public void setActive(final Boolean active) {
        this.active = active;
    }
}
