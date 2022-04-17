package com.skf.power.mockstatic.service;

import com.skf.power.common.User;
import com.skf.power.mockstatic.dao.UserDao;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.powermock.api.mockito.PowerMockito.verifyStatic;
import static org.powermock.api.mockito.PowerMockito.when;

/**
 * desc:
 *
 * @author: skf
 * @date: 2022/04/17
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserDao.class)
@Slf4j
public class UserServiceTest {

    @Test
    public void testQueryUserCount() {

        PowerMockito.mockStatic(UserDao.class);
        when(UserDao.getCount()).thenReturn(10);
        UserService userService = new UserService();
        int result = userService.queryUserCount();
        assertEquals(10, result);

    }

    @Test
    public void testSaveUser() {

        PowerMockito.mockStatic(UserDao.class);
        User user = new User();

        PowerMockito.doNothing().when(UserDao.class);
        UserService userService = new UserService();
        userService.saveUser(user);

        verifyStatic();

    }


    @Test
    public void testQueryUserCountException() {


            PowerMockito.mockStatic(UserDao.class);
            when(UserDao.getCount()).thenThrow(new ArithmeticException("数学运算异常啦~~~"));
        try {
            UserService userService = new UserService();

            userService.queryUserCount();
        } catch (ArithmeticException e) {
            log.error("testQueryUserCountException() called with exception => {}",e.getMessage());

        }
    }

}