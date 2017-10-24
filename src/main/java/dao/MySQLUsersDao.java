package dao;

import com.mysql.cj.jdbc.Driver;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLUsersDao implements Users {
    private Connection connection = null;

    public MySQLUsersDao(Config config) {
        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> all() {
        return all(0L);
    }

    /* This method does 2 things, don't do this in a real application */
    @Override
    public List<User> all(Long id) {
        String query = "SELECT * FROM users";

        if (id > 0) {
            query += " WHERE id = " + id;
        }

        List<User> users = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                users.add(new User(
                    rs.getLong("id"),
                    rs.getString("username"),
                    rs.getString("email"),
                    rs.getString("password")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return users;
    }

    @Override
    public Long insert(User user) {
        Long id = 0L;
        String query = String.format(
            "INSERT INTO users (username, email, password) values('%s', '%s', '%s')",
            user.getUsername(),
            user.getEmail(),
            user.getPassword()
        );
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            // In order to get the users id you can do the following:
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getLong(1);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }
}
