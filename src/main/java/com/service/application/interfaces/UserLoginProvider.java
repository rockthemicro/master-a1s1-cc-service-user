package com.service.application.interfaces;

import com.service.application.entity.User;

import java.util.Optional;

public interface UserLoginProvider {
    Optional<User> getOptionalUser(String userName);
}
