package com.skf.power.threadlocaldemo;

import com.skf.power.common.StringContext;

/**
 * desc:
 *
 * @author: skf
 * @date: 2022/04/14
 */
public class Test2 {



    public void test2() {
        String s = StringContext.get();
        StringContext.destroy();
        System.out.println(s);
    }
}
