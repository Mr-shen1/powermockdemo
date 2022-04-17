package com.skf.power.spy;

/**
 * desc:
 *
 * @author: skf
 * @date: 2022/04/17
 */
public class UserService {



    public void foo(String arg) {
        log();
    }
    private void log() {
        System.out.println("I am console log.");
    }
}
