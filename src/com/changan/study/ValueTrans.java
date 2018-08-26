package com.changan.study;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/15 0015.
 *
 */

class Two {
    Byte x;
}

public class ValueTrans {
    public static void main(String[] args) {
        ValueTrans p = new ValueTrans();
        p.start();
    }

    void start() {
        Two t = new Two();
        System.out.print(t.x + " ");
        Two t2 = fix(t);
        System.out.print(t.x + " " + t2.x);
    }

    //the method shows all argument are value-passing
    Two fix(Two tt) {
        tt.x = 42;
        return tt;
    }
}
