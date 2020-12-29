package com.matejko.service.interfaces;

import com.matejko.model.request.UserRequest;

import java.util.List;

/**
 * Created by Mikołaj Matejko on 30.07.2017 as part of ogame-expander
 */
public interface UserService {
    void save(List<UserRequest> users);

    void remove(String name);
}
