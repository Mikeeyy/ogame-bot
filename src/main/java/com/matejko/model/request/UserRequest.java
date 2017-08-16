package com.matejko.model.request;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
public class UserRequest {
    private String username;
    private String password;
    private String universum;

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
}
