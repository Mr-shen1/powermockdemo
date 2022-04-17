package com.skf.power.mockfinal.service;

import com.skf.power.mockfinal.dao.UserDao;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.mockito.Mockito.when;

/**
 * desc:
 *
 * @author: skf
 * @date: 2022/04/17
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class, UserDao.class})
public class UserServiceTest {


    @Mock
    private UserDao userDao;

    @Test
    public void queryUserCountWithMockito() {
        MockitoAnnotations.initMocks(this);

        UserService userService = new UserService(userDao);
        when(userDao.getCount()).thenReturn(10);

        int result = userService.queryUserCount();
        Assert.assertEquals(10, result);

    }

    @Test
    public void queryUserCountWithPowermock() {
        UserDao uDao = PowerMockito.mock(UserDao.class);
        PowerMockito.when(uDao.getCount()).thenReturn(10);

        UserService userService = new UserService(uDao);
        int result = userService.queryUserCount();
        Assert.assertEquals(10, result);

    }

}