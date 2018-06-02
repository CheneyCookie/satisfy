package com.cheney.satisfy.service.impl;

import org.springframework.stereotype.Service;

import com.cheney.satisfy.exception.ParameterException;
import com.cheney.satisfy.exception.ServiceException;
import com.cheney.satisfy.model.User;
import com.cheney.satisfy.service.UserService;
import com.cheney.satisfy.util.MD5Util;
import com.cheney.satisfy.util.StringUtil;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {

    @Override
    public User login(User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        if (StringUtil.isNullOrBlank(username)) {
            throw new ParameterException("用户名不能为空");
        }
        if (StringUtil.isNullOrBlank(password)) {
            throw new ParameterException("密码不能为空");
        }

        User userDB = userDao.getByUserNameOrEmail(username);
        System.out.println(userDB);
        if (userDB == null) {
            throw new ServiceException("用户" + "'" + username + "'" + "不存在");
        }
        if (!userDB.getPassword().equals(MD5Util.digest(password))) {
            throw new ServiceException("用户" + "'" + username + "'" + "密码不正确");
        }

        return userDB;
    }

    public User getByUserNameOrEmail(String name) {
        return userDao.getByUserNameOrEmail(name);
    }
}
