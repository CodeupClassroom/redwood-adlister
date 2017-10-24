/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package com.codeup.adlister.dao;

public class DaoFactory {
    private static Ads adsDao;
    private static Users usersDao;
    private static Config config = new Config();

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }

    // Factory method for Users
    public static Users getUsersDao() {
        // We're making sure we only have one Users dao
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }
}
