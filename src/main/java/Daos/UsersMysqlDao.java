package Daos;

import com.mysql.cj.jdbc.Driver;
import interfaces.Users;
import models.User;
import java.sql.*;
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
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                System.out.println(rs.getString(4));
                System.out.println(rs.getString("username"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
