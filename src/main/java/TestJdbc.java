/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */

import com.mysql.cj.jdbc.Driver;
import com.codeup.adlister.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestJdbc {
    public static void main(String[] args) throws SQLException {
        // DAO's constructor
        DriverManager.registerDriver(new Driver());
        // mysql -u adlister_user -p
        // adlister_pwd
        // use adlister_db;
        Connection connection = DriverManager.getConnection(
            "jdbc:mysql://localhost/adlister_db",
            "adlister_user",
            "adlister_pwd"
        );

        // 1 query per DAO method

        // Users.all() : List<User>
        // ViewAllUsersServlet.doGet()

        // selects (with and without a where)
        // save your select in a String
        String sql = "SELECT * FROM users";
        // create a Statement from your current DB connection
        Statement statement = connection.createStatement();
        // Execute query
        ResultSet resultSet = statement.executeQuery(sql);
        // Iterator
        List<User> users = new ArrayList<>();
        while (resultSet.next()) { // moving to the next available row
            // Transform the result set into a List of models (User)
            users.add(new User(
                resultSet.getLong("id"),
                resultSet.getString("username"),
                resultSet.getString("email"),
                resultSet.getString("password")
            ));
        }

        // Users.findByI(long id): User
        // ViewUserProfile.doGet()

        // select that returns a single result
        sql = "SELECT * FROM users WHERE id = " + 13;
        statement = connection.createStatement();
        resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            User user = new User(
                resultSet.getLong("id"),
                resultSet.getString("username"),
                resultSet.getString("email"),
                resultSet.getString("password")
            );
        } else {
            throw new RuntimeException("User with ID 13 cannot be found");
        }

        // Users.insert(user)
        // Users.add(user)

        // Users.update(user) // UPDATE ...

        // Users.delete(user)
        // Users.remove(user)

        // SignupUserServlet.doGet()  // /show the registration form
        // SignupUserServlet.doPost() // Save to the database

        // inserts
        String username = "fer";
        String email = "fer@codeup.com";
        String password = "1234";
        sql = String.format(
            "INSERT INTO users (username, email, password) VALUES ('%s', '%s', '%s')",
            username,
            email,
            password
        );
        /*sql = "INSERT INTO users (username, email, password) VALUES ('"
            + username + "', '" + email + "', '" + password + "')";*/
        statement = connection.createStatement();
        // select last_insert_id()
        statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next()) {
            System.out.println("The new user ID is " + resultSet.getLong(1));
        }
    }
}
