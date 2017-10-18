/*
 * This source file is subject to the license that is bundled with this package in the file LICENSE.
 */

public class DaoFactory {
    private static Users usersDao;

    // factory method
    public static Users getUsersDao() {
        if (usersDao == null) {
            return new UsersArrayList();
        }
        return  usersDao;
    }
}
