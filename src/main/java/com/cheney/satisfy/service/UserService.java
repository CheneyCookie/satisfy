package com.cheney.satisfy.service;

import com.cheney.satisfy.model.User;


public interface UserService extends BaseService<User> {

    User login(User user);

    User getByUserNameOrEmail(String name);
}
