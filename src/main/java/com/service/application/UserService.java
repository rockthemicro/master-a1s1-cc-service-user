package com.service.application;

import com.service.application.entity.User;
import com.service.application.interfaces.UserLoginProvider;
import com.service.application.interfaces.UserSignupProvider;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    private UserLoginProvider userLoginProvider;
    private UserSignupProvider userSignupProvider;

    public UserService(UserLoginProvider userLoginProvider, UserSignupProvider userSignupProvider) {
        this.userLoginProvider = userLoginProvider;
        this.userSignupProvider = userSignupProvider;
    }

    public String testMethod() {
        return "works";
    }

    public String login(String userName, String password) {
        Optional<User> user = userLoginProvider.getOptionalUser(userName);
        if (user.isPresent()) {

            if (user.get().getPassword().equals(password)) {
                return "OK";
            } else {
                return "FAIL";
            }
        } else {
            return "FAIL";
        }
    }

    public String signup(String userName, String password, String email) {
        Optional<User> user = userLoginProvider.getOptionalUser(userName);
        if (user.isPresent()) {
            /* daca exista, FAIL */
            return "FAIL";
        }

        User newUser = new User();
        newUser.setUserName(userName);
        newUser.setPassword(password);
        newUser.setEmail(email);

        if (userSignupProvider.saveUser(newUser)) {
            return "OK";
        } else {
            return "FAIL";
        }
    }
}
