package com.service.infrastructure;

import com.service.application.entity.User;
import com.service.application.interfaces.UserSignupProvider;
import com.service.infrastructure.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSignupDBProvider implements UserSignupProvider {
    @Autowired
    UserRepository ur;

    @Override
    public boolean saveUser(User newUser) {
        newUser = ur.save(newUser);

        if (newUser != null) {
            return true;
        } else {
            return false;
        }
    }
}
