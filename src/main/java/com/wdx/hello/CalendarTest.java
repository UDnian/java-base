package com.wdx.hello;

import java.util.Calendar;
import java.util.Date;

/**
 * @author wangdongxing
 * @since 2019-04-03 15:12
 */
public class CalendarTest {
    public static void main(String[] args) {
        Calendar instance = Calendar.getInstance();
        instance.set(2019, 3, 4, 0, 0, 0);
        Date date = instance.getTime();

        System.out.println(date);
        fn();
    }

    public static void fn() {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
