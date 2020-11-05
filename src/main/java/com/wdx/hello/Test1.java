package com.wdx.hello;

import org.junit.Test;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.UUID;

/**
 * @author wangdongxing
 * @since 2019-06-17 10:11
 */
public class Test1 {
    
    @Test
    public void getDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(2019, 10, 14, 12, 30, 0);
        Date date = calendar.getTime();
        long timeInMillis = calendar.getTimeInMillis();
        
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(formatter.format(date));
        System.out.println(timeInMillis);
    }
    
    @Test
    public void testList() {
        int i = 1;
        int j = 2;
        int k = 3;
        ArrayList<Integer> list = new ArrayList<>(2);
        list.add(i);
        list.add(j);
        list.add(k);
        list.trimToSize();
        list.forEach(System.out::println);
    }
    
    @Test
    public void testLinkedList() {
        int i = 1;
        int j = 2;
        int k = 3;
        LinkedList<Integer> list = new LinkedList<>();
        list.add(i);
        list.add(j);
        list.add(k);
        System.out.println(list.hashCode());
        list.forEach(System.out::println);
    }
    
    @Test
    public void testCalendar() {
        Date date = new Date(1574870400000L);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println(format.format(date));
        
        System.out.println("fwefwefew".substring(0, 4));
    }
    
    @Test
    public void testBigDecimal() {
        BigDecimal d1 = BigDecimal.valueOf(10.3);
        BigDecimal d2 = BigDecimal.valueOf(3);
        BigDecimal divide = d1.divide(d2, 1, BigDecimal.ROUND_HALF_UP);
        System.out.println(divide.doubleValue());
        d1 = BigDecimal.valueOf(10);
        d2 = BigDecimal.valueOf(2);
        divide = d1.divide(d2, 1, BigDecimal.ROUND_HALF_UP);
        System.out.println(divide.doubleValue());
        System.out.println(divide.stripTrailingZeros());
        System.out.println(divide.toPlainString());
        System.out.println(divide.toString());
        Double d3 = 0.0;
        System.out.println(d3.toString());
        System.out.println(d3 == 0);
        double d4 = 6.0;
        System.out.println(String.valueOf(d4));
    }
    
    @Test
    public void testBigDecimal2() {
        BigDecimal a = new BigDecimal(1.01);
        BigDecimal b = new BigDecimal(1.02);
        BigDecimal c = new BigDecimal("1.01");
        BigDecimal d = new BigDecimal("1.02");
        System.out.println(a.add(b));
        System.out.println(c.add(d));
    }
    
    @Test
    public void testUuid() {
        String replace = UUID.randomUUID().toString().replace("-", "");
        System.out.println(replace);
        int i = replace.hashCode();
        System.out.println(i);
    }
}
