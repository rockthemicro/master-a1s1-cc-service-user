package com.service.infrastructure;

import com.service.application.entity.User;
import com.service.application.interfaces.UserLoginProvider;
import com.service.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserLoginDBProvider implements UserLoginProvider {
    @Autowired
    UserRepository ur;

    @Override
    public Optional<User> getOptionalUser(String userName) {
        return ur.findById(userName);
    }
}
