package com.skf.power.local.service;

import com.skf.power.local.dao.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.powermock.api.mockito.PowerMockito.*;

/**
 * desc:
 *
 * @author: skf
 * @date: 2022/04/14
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
public class UserServiceTest {

    @Test
    public void queryUserCount() {

        try {
            UserService userService = new UserService();
            UserDao userDao = mock(UserDao.class);
            whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
            doReturn(10).when(userDao).getCount();

            int result = userService.queryUserCount();
            System.out.println(result);
            assertEquals(1, result);

        } catch (Throwable e) {
            fail("uibd");

        }
    }

    @Test
    public void saveUser() {


    }

    @Test
    public void testException() throws Exception {

        UserDao userDao = mock(UserDao.class);
        whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
        when(userDao.getCount()).thenThrow(ArithmeticException.class);

        UserService userService = new UserService();
        userService.queryUserCount();


    }
}