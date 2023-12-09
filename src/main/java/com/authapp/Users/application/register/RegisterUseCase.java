package com.authapp.Users.application.register;

import com.authapp.Users.domain.Users;
import com.authapp.Users.domain.UserService;
import com.authapp.Shared.domain.PublishDomainEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class RegisterUseCase implements UserService {
    @Autowired
    PublishDomainEvent publishDomainEvent;
    @Override
    public void registerUser(String username, String password, String fullname, String email) {
        Users user = Users.builder()
                .id(UUID.randomUUID().toString())
                .username(username)
                .password(password)
                .fullname(fullname)
                .email(email)
                .build();
        publishDomainEvent.push(user);
    }
}
