package com.skf.power.spy;

import org.junit.Test;
import org.junit.runner.RunWith;
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
@PrepareForTest(UserService.class)
public class UserServiceTest {

    //@Spy
    //private UserService userService = new UserService();


    @Test
    public void testFoo() {
        //UserService userService = PowerMockito.mock(UserService.class);
        //userService.foo();
        UserService userServiceSpy = PowerMockito.spy(new UserService());
        System.out.println(userServiceSpy);
        String arg = "hello";
        PowerMockito.doNothing().when(userServiceSpy).foo(arg);
        userServiceSpy.foo("world");
    }
}