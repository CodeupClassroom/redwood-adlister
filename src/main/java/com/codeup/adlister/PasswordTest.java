/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.adlister;

import com.codeup.adlister.dao.DaoFactory;
import com.codeup.adlister.models.User;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordTest {
    public static void main(String[] args) {
        int numberOfRounds = 20;
        String plainTextPassword = "hello";
        // RegisterServlet
        //String plainTextPassword = request.getParameter("password");
        String hash = BCrypt.hashpw(plainTextPassword, BCrypt.gensalt(numberOfRounds));
/*
        User user = new User(
            request.getParameter("username"),
            request.getParameter("email"),
            hash
        );

        DaoFactory.getUsersDao().insert(user);
*/
        // We save the hash in the database
        // $2a$12$W2tC18TuL4AadrukpyV/GumwFsvqOHqljzGDEzQiVDqVFUwMRlH8i
        // $2a$12$oBrxbIs1.jzKjSWpj6QqAOzC8pnDO.eioMUTbYGrPzl1w3I6LRN9S

        // LoginServet

        // User user = DaoFactory.getUsersDao().findByUsername(username);

        System.out.println(BCrypt.checkpw(
            "hello",
                // request.getParameter("password")
            "$2a$12$oBrxbIs1.jzKjSWpj6QqAOzC8pnDO.eioMUTbYGrPzl1w3I6LRN9S"
                // user.getPassword()
        ));

        System.out.println(hash);
    }
}
