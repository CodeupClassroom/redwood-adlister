/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */

import java.util.ArrayList;
import java.util.List;

public class UsersArrayList implements Users {
    @Override
    public List<User> all() {
        User user = new User();
        user.setId(1);
        user.setName("Fer");
        user.setEmail("fer@codeup.com");
        User zach = new User();
        zach.setId(2);
        zach.setName("Zach");
        zach.setEmail("zach@codeup.com");

        ArrayList<User> users = new ArrayList<>();
        users.add(user);
        users.add(zach);

        return users;
    }
}
