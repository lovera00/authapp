package com.authapp.Shared.domain;

import com.authapp.Users.domain.Users;

public interface PublishDomainEvent {
    public Users push(Users user );
}
