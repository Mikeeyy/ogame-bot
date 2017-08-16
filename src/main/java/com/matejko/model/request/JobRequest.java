package com.matejko.model.request;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
public abstract class JobRequest {
    private UserRequest user;
    private String strategy;

    public UserRequest getUser() {
        return user;
    }

    public void setUser(final UserRequest userRequest) {
        this.user = userRequest;
    }

    public String getStrategy() {
        return strategy;
    }

    public void setStrategy(final String strategy) {
        this.strategy = strategy;
    }
}
