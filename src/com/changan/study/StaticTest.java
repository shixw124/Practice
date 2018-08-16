package com.changan.study;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/15 0015.
 *
 */
class A{
    // the static domain will be loaded when this class first appears
    static{
        System.out.print("first ");
    }
    public A(){
        System.out.print("second ");
    }
}

class B extends A{
    static{
        System.out.print("A ");
    }

    //that calls the subclass' constructor has to call the parent class' constructor
    public B(){
        System.out.print("B ");
    }
}
public class StaticTest {
    public static void main(String[] ars){
        A ab = new B();
        System.out.println();
        ab = new B();
    }
}
