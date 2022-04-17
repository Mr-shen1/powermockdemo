package com.skf.power.mockfinal.service;

import com.skf.power.common.User;
import com.skf.power.mockfinal.dao.UserDao;

/**
 * desc:
 *
 * @author: skf
 * @date: 2022/04/14
 */
public class UserService  {

    private UserDao userDao;

    public UserService(UserDao userDao) {
        this.userDao = userDao;
    }

    public int queryUserCount() {
        return userDao.getCount();
    }

    public void saveUser(User user) {
        userDao.insertUser(user);

    }
}
