package com.changan.study;
/*
 * @Author Administrator-shixw.
 * @Date 2018/8/14 0014.
 *
 */

import java.util.Calendar;

public class PrintTomorrowSameTime {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1);
        System.out.println(calendar.getTime());
    }
}
