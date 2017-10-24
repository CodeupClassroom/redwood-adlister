package com.codeup.adlister.dao;/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */

import com.codeup.adlister.models.User;

import java.util.ArrayList;
import java.util.List;

public class UsersArrayList {

    public List<User> all() {
        User user = new User();
        user.setId(1);
        user.setUsername("Fer");
        user.setEmail("fer@codeup.com");
        User zach = new User();
        zach.setId(2);
        zach.setUsername("Zach");
        zach.setEmail("zach@codeup.com");

        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        users.add(zach);

        return users;
    }


    public Long insert(User user) {
        return null;
    }
}
