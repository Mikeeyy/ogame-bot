package com.matejko.service.impl;

import com.matejko.model.entity.User;
import com.matejko.model.request.UserRequest;
import com.matejko.repository.interfaces.UserRepository;
import com.matejko.service.interfaces.EncryptionService;
import com.matejko.service.interfaces.UserService;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import lombok.RequiredArgsConstructor;

/**
 * Created by Mikołaj Matejko on 30.07.2017 as part of ogame-expander
 */
@Named
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final EncryptionService encryptionService;

    @Override
    public void save(final List<UserRequest> users) {
        users.forEach(user -> {
            User userToSave = userRepository.findByUsername(user.getUsername())
                    .map(dbUser -> {
                        Optional.ofNullable(user.getUsername())
                                .ifPresent(dbUser::setUsername);
                        Optional.ofNullable(user.getPassword())
                                .map(encryptionService::encrypt)
                                .ifPresent(dbUser::setPassword);
                        Optional.ofNullable(user.getUniversum())
                                .ifPresent(dbUser::setUniversum);
                        dbUser.setModificationDate(new Date());

                        return dbUser;
                    })
                    .orElse(createNewUser(user));

            userRepository.save(userToSave);
        });
    }

    private User createNewUser(final UserRequest userRequest) {
        User user = new User();
        user.setUsername(userRequest.getUsername());
        user.setPassword(encryptionService.encrypt(userRequest.getPassword()));
        user.setUniversum(userRequest.getUniversum());
        user.setCreationDate(new Date());
        return user;
    }

    @Override
    public void remove(final String name) {
        userRepository.findByUsername(name)
                .ifPresent(userRepository::delete);
    }
}
