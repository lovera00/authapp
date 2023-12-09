package com.authapp.Users.infrastructure.http;

import com.authapp.Users.domain.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "users")
public class UserController {
    @Autowired
    UserService usersInputPort;

    @PostMapping(value = "register", produces= MediaType.APPLICATION_JSON_VALUE)
    public void create(@RequestParam String username, @RequestParam String password,@RequestParam String fullname,@RequestParam String email ) {
        usersInputPort.registerUser(username,password,fullname,email);
    }
}
