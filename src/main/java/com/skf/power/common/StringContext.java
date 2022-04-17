package com.skf.power.common;

public class StringContext {

    private static ThreadLocal<String> testThreadLocal = new ThreadLocal();


    public static String get() {
        return (String) testThreadLocal.get();
    }

    public static void set(String s) {
        testThreadLocal.set(s);
    }

    public static void destroy() {
        testThreadLocal.remove();
    }
}
