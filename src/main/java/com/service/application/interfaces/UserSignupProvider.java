package com.service.application.interfaces;

import com.service.application.entity.User;

public interface UserSignupProvider {
    boolean saveUser(User newUser);
}
