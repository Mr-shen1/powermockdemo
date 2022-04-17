package com.skf.power.verify;

import com.skf.power.common.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

/**
 * desc:
 *
 * @author: skf
 * @date: 2022/04/17
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({UserService.class, UserDao.class})
public class UserServiceTest {

    @Test
    public void saveOrUpdateWillInsert() throws Exception {

        User user = new User();
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);

        PowerMockito.when(userDao.getCount(user)).thenReturn(0);
        UserService userService = new UserService();
        userService.SaveOrUpdate(user);

        Mockito.verify(userDao).insertUser(user);
        Mockito.verify(userDao, Mockito.never()).updateUser(user);

    }

    @Test
    public void saveOrUpdateWillUpate() throws Exception {

        User user = new User();
        UserDao userDao = PowerMockito.mock(UserDao.class);
        PowerMockito.whenNew(UserDao.class).withAnyArguments().thenReturn(userDao);

        PowerMockito.when(userDao.getCount(user)).thenReturn(1);
        UserService userService = new UserService();
        userService.SaveOrUpdate(user);

        Mockito.verify(userDao, Mockito.never()).insertUser(user);
        Mockito.verify(userDao).updateUser(user);


    }
}