package com.skf.power.matcher;

/**
 * desc:
 *
 * @author: skf
 * @date: 2022/04/17
 */
public class UserService {


    public String find(String name) {
        UserDao userDao = new UserDao();
        return userDao.queryByName(name);
    }
}
