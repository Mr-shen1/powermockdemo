package com.skf.power.helloworld.service;

import com.skf.power.common.User;
import com.skf.power.helloworld.dao.UserDao;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;

/**
 * desc:
 *
 * @author: skf
 * @date: 2022/04/14
 */
public class UserServiceTest {

    private UserService userService;

    @Before
    public void setUp() {
        userService = new UserService(new UserDao());

    }

    @Mock
    private UserDao userDao;


    @Test
    public void testQueryUserCountWithPowerMock() {
        UserDao uDao = PowerMockito.mock(UserDao.class);
        //PowerMockito.doReturn(10).when(uDao).getCount();
        PowerMockito.when(uDao.getCount()).thenReturn(10);
        UserService userService = new UserService(uDao);

        int result = userService.queryUserCount();
        Assert.assertEquals(10, result);

    }

    @Test
    public void testSaveUserWithMockito() {
        UserDao uDao = PowerMockito.mock(UserDao.class);
        User user = new User();
        PowerMockito.doNothing().when(uDao).insertUser(user);
        UserService userService = new UserService(uDao);

        userService.saveUser(user);

        Mockito.verify(uDao).insertUser(user);

    }


    @Test
    public void testQueryUserCountWithMockito() {

        MockitoAnnotations.initMocks(this);
        UserService userService = new UserService(userDao);
        Mockito.when(userDao.getCount()).thenReturn(10);

        int result = userService.queryUserCount();
        Assert.assertEquals(10, result);
    }


    @Test
    public void testQueryUserCountWithJunit() {

        try {
            int count = userService.queryUserCount();
            Assert.fail("不能运行...");
        } catch (Exception e) {
            Assert.assertTrue(e instanceof UnsupportedOperationException);
        }

    }

    @Test
    public void testSaveUserWithJunit() {

        try {
            userService.saveUser(new User());
            Assert.fail("不能插入");
        } catch (Exception e) {
            Assert.assertTrue(e instanceof UnsupportedOperationException);
        }

    }
}