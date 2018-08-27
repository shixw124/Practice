package com.changan.studyList;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/27 0027.
 *
 */

import java.util.ArrayList;

public class Yuesefu {

    public int yueSeFu(int count, int step) {
        ArrayList<Integer> killList = new ArrayList();
        if (count <= 0 || step <= 0) {
            System.out.println("the arguments are not suitable");
            return -1;
        }
        if (count == 1) {
            return 0;
        }

        // initialize the killList
        for (int i = 0; i < count; i++) {
            killList.add(i + 1);
        }

        int index = 0;

        while (killList.size() > 1) {

            index = index + step;
            // the pointer to show aim value
            index = index % killList.size() - 1;

            // is the rail ?
            if (index < 0) {
                System.out.print(killList.get(killList.size() - 1) + " ");
                killList.remove(killList.size() - 1);
                index = 0;
            } else {
                System.out.print(killList.get(index) + " ");
                killList.remove(index);
            }

        }

        return killList.get(0);
    }

    public static void main(String[] args) {
        Yuesefu yuesefu = new Yuesefu();
        int res = yuesefu.yueSeFu(41, 3);
        System.out.println();
        System.out.println("the result is " + res );
    }
}
