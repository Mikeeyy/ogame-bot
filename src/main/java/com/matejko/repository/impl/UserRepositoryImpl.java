package com.matejko.repository.impl;

import com.matejko.exceptions.RepositoryException;
import com.matejko.model.entity.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
public class UserRepositoryImpl {

    public Optional<User> getUserByUsername(final String username) throws RepositoryException {
        try (Stream<String> stream = Files.lines(Paths.get("src\\main\\resources\\users.txt"))) {
            return stream
                    .map(this::parseJobLine)
                    .filter(user -> Objects.equals(user.getUsername(), username))
                    .findFirst();
        } catch (IOException e) {
            throw new RepositoryException(e);
        }
    }

    private User parseJobLine(final String line) {
        String[] strings = line.split(",");

        return new User(strings[0], strings[1], strings[2]);
    }
}
