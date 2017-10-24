/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */
package dao;

public class DaoFactory {
    private static Config config = new Config();
    private static Users usersDao;
    private static Ads adsDao;

    // factory method
    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new MySQLUsersDao(config);
        }
        return usersDao;
    }

    public static Ads getAdsDao() {
        if (adsDao == null) {
            adsDao = new MySQLAdsDao(config);
        }
        return adsDao;
    }
}
