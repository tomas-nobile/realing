package com.nobile.realing.service;

import com.nobile.realing.entity.User;

public interface UserService {
    User getUser(Long id);
    User getUser(String username)   ;
    User saveUser(User user);
}
