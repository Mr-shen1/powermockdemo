package com.skf.power.spy;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

/**
 * desc:
 *
 * @author: skf
 * @date: 2022/04/17
 */
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