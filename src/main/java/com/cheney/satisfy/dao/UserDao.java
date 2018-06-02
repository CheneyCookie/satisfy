package com.cheney.satisfy.dao;

import com.cheney.satisfy.model.User;

public interface UserDao extends BaseDao<User> {

    User getByUserNameOrEmail(String name);
}
