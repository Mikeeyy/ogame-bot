package com.matejko.model.standard;

/**
 * Created by Mikołaj Matejko on 01.08.2017 as part of ogame-expander
 */
public class DecryptedUser {
    private String username;
    private String password;
    private String universum;

    public DecryptedUser(final String username, final String password, final String universum) {
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
}
