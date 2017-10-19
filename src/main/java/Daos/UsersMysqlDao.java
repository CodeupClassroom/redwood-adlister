package Daos;

import com.mysql.cj.jdbc.Driver;
import interfaces.Users;
import models.User;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsersMysqlDao implements Users {

    Connection connection = null;

    public UsersMysqlDao(){

        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    Config.getUrl(),
                    Config.getUsername(),
                    Config.getPassword()
            );
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> all() {
        return all(0L);
    }

    @Override
    public List<User> all(Long id) {
        String query = "SELECT * FROM users";

        if(id > 0){
            query += " WHERE id = " + id;
        }

        List<User> users = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while(rs.next()){
                users.add(
                        new User(rs.getLong("id"), rs.getString("username"), rs.getString("email"), rs.getString("password"))
                );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return users;
    }

    @Override
    public Long insert(User user) {
        Long id = 0L;
        String query = "INSERT INTO users (username, email, password) values('"+ user.getUsername() + "', '" + user.getEmail() + "', '" + user.getPassword() + "')";
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            // In order to get the users id you can do the following:
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()){
                id = rs.getLong(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return id;
    }
}
