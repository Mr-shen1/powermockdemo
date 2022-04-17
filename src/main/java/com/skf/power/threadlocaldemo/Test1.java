package com.skf.power.threadlocaldemo;

import com.skf.power.common.StringContext;

/**
 * desc:
 *
 * @author: skf
 * @date: 2022/04/14
 */
public class Test1 {



    public static void main(String[] args) {
        StringContext.set("haha");


        Test2 test2 = new Test2();

        test2.test2();



    }


}
