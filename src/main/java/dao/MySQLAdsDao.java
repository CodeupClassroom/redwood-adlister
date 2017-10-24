/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package dao;

import com.mysql.cj.jdbc.Driver;
import interfaces.Ads;
import models.Ad;
import models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config) {
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

    @Override
    public List<Ad> all() {
        String query = "SELECT * FROM ads";
        List<Ad> ads = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            while (rs.next()) {
                ads.add(new Ad(
                    rs.getLong("id"),
                    1,
                    rs.getString("title"),
                    rs.getString("description")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ads;
    }

    @Override
    public Long insert(Ad ad) {
        Long id = 0L;
        String query = String.format(
            "INSERT INTO ads (user_id, title, description) values(1, '%s', '%s')",
            ad.getTitle(),
            ad.getDescription()
        );
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
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
