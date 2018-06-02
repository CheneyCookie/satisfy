package com.cheney.satisfy.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cheney.satisfy.model.Role;
import com.cheney.satisfy.model.User;
import com.cheney.satisfy.service.UserService;
import com.cheney.satisfy.util.MD5Util;
import com.github.pagehelper.PageInfo;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public User getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    @RequestMapping(value = "/session", method = RequestMethod.GET)
    public User getSessionUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            user = new User();
        }
        return user;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public PageInfo<User> getByPage(@RequestBody PageInfo<User> pageInfo) {
        return userService.getByPage(pageInfo);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public User login(@RequestBody User user, HttpSession session) {
        user = userService.login(user);
        session.setAttribute("user", user);

        return user;
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Boolean logout(HttpSession session) {
        session.removeAttribute("user");
        return true;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public Boolean register(@RequestBody User user) {
        User userDB = userService.getByUserNameOrEmail(user.getEmail());
        if (userDB == null) {
            user.setRole(new Role(2));
            user.setPassword(MD5Util.digest(user.getPassword()));
            user.setIsDeleted(false);
            user.setCreateTime(new Date());
            System.out.println(user);
            userService.addOne(user);
            return true;
        }
        return false;
    }

    @RequestMapping(value = "/emailOrName", method = RequestMethod.GET)
    public Boolean getByUsernameOrEmail(@RequestParam String emailOrName) {
        User userDB = userService.getByUserNameOrEmail(emailOrName);
        System.out.println(userDB);
        if (userDB == null) {
            return false;
        }
        return true;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public PageInfo<User> listUser(PageInfo<User> pageInfo) {
        return userService.getByPage(pageInfo);
    }
}
