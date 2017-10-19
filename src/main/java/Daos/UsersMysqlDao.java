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

    @Override
    public List<User> all() {
        String query = "SELECT * FROM users";
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
}
