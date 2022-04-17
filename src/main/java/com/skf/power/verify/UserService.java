package com.skf.power.verify;

import com.skf.power.common.User;

/**
 * desc:
 *
 * @author: skf
 * @date: 2022/04/17
 */
public class UserService {



    public void SaveOrUpdate(User user) {

        UserDao userDao = new UserDao();

        if (userDao.getCount(user) > 0) {
            userDao.updateUser(user);
        } else {
            userDao.insertUser(user);
        }
    }
}
