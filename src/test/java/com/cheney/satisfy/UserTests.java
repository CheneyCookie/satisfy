package com.cheney.satisfy;

import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cheney.satisfy.controller.UserController;
import com.cheney.satisfy.dao.UserDao;
import com.cheney.satisfy.model.Role;
import com.cheney.satisfy.model.User;
import com.cheney.satisfy.service.UserService;
import com.cheney.satisfy.util.MD5Util;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pagehelper.PageInfo;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan("com.cheney.satisfy.dao")
public class UserTests {

    @Autowired
    UserDao userDao;

    @Autowired
    UserController userController;

    @Autowired
    UserService userService;

    @Test
    public void getUserById() {
        User user = userService.getById(1);
        System.out.println(user);
    }

    @Test
    public void getUserByPage() throws JsonProcessingException {
        PageInfo<User> pageInfo = new PageInfo<User>();
        pageInfo.setPageNum(1);
        pageInfo.setPageSize(2);
        pageInfo = userService.getByPage(pageInfo);
        ObjectMapper objectMapper = new ObjectMapper();
        String writeValueAsString = objectMapper.writeValueAsString(pageInfo);
        System.out.println(writeValueAsString);
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setUsername("cheney");
        user.setName("chen");
        user.setPassword(MD5Util.digest("abc123_"));
        user.setCreateTime(new Date());
        Role role = new Role();
        role.setId(1);
        user.setRole(role);
        user.setIsDeleted(false);
        Boolean flag = userService.addOne(user);
        System.out.println(flag);
    }

    @Test
    public void updateUser() {
        User user = new User();
        user.setId(11);
        user.setUsername("ggg");
        user.setName("gggg");
        user.setPassword("abc123_");
        Role role = new Role();
        role.setId(1);
        user.setRole(role);
        user.setIsDeleted(false);
        Boolean flag = userService.updateOne(user);
        System.out.println(flag);
    }

    @Test
    public void deleteUser() {
        int id = 1;
        Boolean flag = userService.deleteById(id);
        System.out.println(flag);
    }

    @Test
    public void testMD5() {
        String password1 = "abc123_";
        String password2 = "121716";

        password1 = MD5Util.digest(password1);
        password2 = MD5Util.digest(password2);
        System.out.println(password1);
        System.out.println(password2);
    }

}
