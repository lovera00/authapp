package com.authapp.Users.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Users {
private String id;
private String username;
private String password;
private String fullname;
private String email;
}
