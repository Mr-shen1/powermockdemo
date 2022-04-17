package com.skf.power.matcher;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatcher;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.junit.Assert.fail;

/**
 * desc:
 *
 * @author: skf
 * @date: 2022/04/17
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest(UserService.class)
@Slf4j
public class UserServiceTest {

    @Test
    public void testFind() throws Exception {

        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
        UserService userService = new UserService();

        PowerMockito.when(userDao.queryByName("wanggu")).thenReturn("shenkefeng");
        Assert.assertEquals("shenkefeng", userService.find("wanggu"));


        PowerMockito.when(userDao.queryByName("afeng")).thenReturn("shenkefeng");
        Assert.assertEquals("shenkefeng", userService.find("afeng"));


    }

    @Test
    public void testFindWithMatcher() throws Exception {

        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);
        UserService userService = new UserService();

        PowerMockito.when(userDao.queryByName(Mockito.argThat(new MyArgumentMatcher()))).thenReturn("shenkefeng");

        Assert.assertEquals("shenkefeng", userService.find("wanggu"));
        Assert.assertEquals("shenkefeng", userService.find("afeng"));
        Assert.assertEquals("shenkefeng", userService.find("wanfeng"));
        Assert.assertEquals("shenkefeng", userService.find("fengzi"));
        //Assert.assertEquals("shenkefeng", userService.find("tom"));


    }

    @Test
    public void testFindWithAnswer() throws Exception {

        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withNoArguments().thenReturn(userDao);

        PowerMockito.when(userDao.queryByName(Mockito.anyString())).thenAnswer((invocation) -> {
            String arg = (String) invocation.getArguments()[0];
            switch (arg) {
                case "Alex":
                    return "I am Alex.";
                case "Jacky":
                    return "I am Jacky.";
                default:
                    throw new RuntimeException("not support.");
            }
        });

        UserService userService = new UserService();

        Assert.assertEquals("I am Alex.", userService.find("Alex"));
        Assert.assertEquals("I am Jacky.", userService.find("Jacky"));

        try {
            userService.find("Tom");
            fail("never process to here");
        } catch (Exception e) {
            Assert.assertTrue(e instanceof RuntimeException);
            log.error("testFindWithAnswer() called with exception => {}",e.getMessage());

        }

    }

    static class MyArgumentMatcher extends ArgumentMatcher<String> {

        @Override
        public boolean matches(Object o) {
            String arg = null;
            if (o instanceof String) {
                arg = (String) o;
            }
            switch (arg) {
                case "wanggu":
                case "afeng":
                case "wanfeng":
                case "fengzi":
                    return true;
                default:
                    return false;
            }
        }
    }
}