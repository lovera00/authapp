package com.authapp.Users.domain;

public interface UserService {
    public void registerUser(String username, String password, String fullname, String email);
}
