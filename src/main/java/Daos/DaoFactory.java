package Daos;/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */

import interfaces.Ads;
import interfaces.Users;

public class DaoFactory {
    private static Users usersDao;
    private static Ads adsDao;

    // factory method
    public static Users getUsersDao() {
        if (usersDao == null) {
            usersDao = new EmptyUsers();
        }
        return  usersDao;
    }

    public static Ads getAdsDao(){
        if(adsDao == null){
            adsDao = new ListAdsDao();
        }
        return adsDao;
    }

}
