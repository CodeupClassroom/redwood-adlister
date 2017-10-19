package Daos;

import com.mysql.jdbc.Driver;
import interfaces.Users;
import objs.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class UsersMysqlDao implements Users {

    public UsersMysqlDao(){

        try {
            DriverManager.registerDriver(new Driver());
            Connection connection = DriverManager.getConnection(
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
        return null;
    }
}
