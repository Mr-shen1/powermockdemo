package com.skf.power.mockstatic.service;

import com.skf.power.common.User;
import com.skf.power.mockstatic.dao.UserDao;
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
        return UserDao.getCount();
    }

    public void saveUser(User user) {
        UserDao.insertUser(user);
    }
}
