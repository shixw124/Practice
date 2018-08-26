package com.changan.study;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/16 0016.
 *
 */

class animals {
    private int age;
    String color;
}

class dog extends animals {
    dog(int age, String color) {
        this.color = color;
        // this.age = age; the private argument cannot be accessed in subclass
    }
}
public class PrivateTest {
}
