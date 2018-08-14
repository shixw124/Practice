package com.changan.study;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/13 0013.
 *
 */


import java.util.Map;

/**
 * return all Environment Variables in the system
 */
public class EnvironmentVariables {
    public static void main(String[] args) {
        for (Map.Entry entry : System.getenv().entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
