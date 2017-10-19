package interfaces;/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */

import models.User;

import java.util.List;

public interface Users {
    List<User> all();
    Long insert(User user);
}
