/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;

import java.util.List;

public interface Users {
    List<User> all(Long id);
    List<User> all();
    Long insert(User user);
}
