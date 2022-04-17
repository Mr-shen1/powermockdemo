package com.skf.power.local.service;

import com.skf.power.common.User;
import com.skf.power.local.dao.UserDao;
import lombok.extern.slf4j.Slf4j;

/**
 * desc:
 *
 * @author: skf
 * @date: 2022/04/14
 */
@Slf4j
public class UserService  {



    public int queryUserCount() {
        UserDao userDao = new UserDao();
        try {
            userDao.getCount();
        } catch (Exception e) {
            log.error("getCount() called with exception => {}","出现异常啦", e);
            System.out.println("yiih");

        }
        return 1;
    }

    public void saveUser(User user) {
        UserDao userDao = new UserDao();

        userDao.insertUser(user);

    }
}
