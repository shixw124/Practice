package com.changan.study;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/13 0013.
 *
 */

import java.util.PriorityQueue;

public class Test {
    private double d1 = 1.0;
    private static int x = 4;


   /* // inner class can't have static declaration
    class InnerOne{
        public static double methoda() {return d1;}
    }
*/
    /*
    non-static field variables can't be referenced at static field
    static class InnerOne{
        protected double methoda() {return d1;}
    }*/
    static class Student {
        Student() {}
    }

    public static void main(String[] args) {
        System.out.println("test the github!");
        // System.out.println("value is: " + ((x > 4) ? 99.9 : 9));

        /*int k = 0;
        k = k++;
        System.out.println(k);
        int y = k;
        System.out.println(y);*/

        Student student1 = new Student();
        Student student2 = new Student();
        System.out.println(student1 == student2);
        System.out.println(student1.equals(student2));

        String s = new String("s");
        String s1 = new String("s");
        System.out.println(s == s1);
        System.out.println(s.equals(s1));
        System.out.println(Math.round(12.1));
        System.out.println(Math.ceil(12.1));
        System.out.println(Math.floor(12.1));




    }


}
