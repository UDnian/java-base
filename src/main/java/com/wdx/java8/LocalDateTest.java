package com.wdx.java8;

import org.junit.Test;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.Calendar;
import java.util.Date;

/**
 * LocalDate、LocalTime 日期
 *
 * @author wangdongxing
 * @since 2020-03-03 18:00
 */
public class LocalDateTest {
    
    @Test
    public void testLocalDate() {
        LocalDate now = LocalDate.now();
        System.out.println(now);
        System.out.println("年: " + now.getYear() + ", 月: " + now.getMonth() + " " + now.getMonthValue() + ", 日: " + now
                .getDayOfMonth());
        System.out.println(now.getMonth() + " 月共 " + now.lengthOfMonth() + " 天");
        
        LocalDate now1 = now.withDayOfMonth(1);
        System.out.println(now.getDayOfMonth() + " 号替换为 " + now1.getDayOfMonth() + "号");
        
        LocalDate with = now.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println("当前月的第一天: " + with);
        
        LocalDate now2 = now.minusDays(1);
        System.out.println("减1天为: " + now2);
        
        LocalDate now3 = now.plusDays(1);
        System.out.println("加1天为: " + now3);
        
        LocalDateTime nowTime = now.atTime(13, 10, 55);
        System.out.println("带上时分秒: " + nowTime);
        
        String format = now.format(DateTimeFormatter.ISO_LOCAL_DATE);
        System.out.println("date标准格式化日期格式为: " + format);
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String format1 = now.format(dateTimeFormatter);
        System.out.println("date自定义格式化日期格式为: " + format1);
        
        String format2 = nowTime.format(dateTimeFormatter);
        System.out.println("dateTime自定义格式化日期格式为: " + format2);
        
        LocalDateTime localDateTime = now.atStartOfDay();
        System.out.println(localDateTime);
        
        LocalDate localDate1 = LocalDate.of(2020, 2, 2);
        System.out.println("自定义日期: " + localDate1);
    }
    
    @Test
    public void testLocalTime() {
        LocalTime now = LocalTime.now();
        System.out.println(now);
        System.out.println(now.getHour());
        
        LocalDate nowDate = LocalDate.now();
        System.out.println(nowDate.plusDays(3));
        
    }
    
    @Test
    public void testLocalDateTime() {
        LocalDateTime now = LocalDateTime.now();
        System.out.println(now);
        LocalDate localDate = now.toLocalDate();
        System.out.println("只要日期: " + localDate);
        LocalTime localTime = now.toLocalTime();
        System.out.println("只要时间: " + localTime);
    }
    
    @Test
    public void testInstant() {
        // 此类的对象表示时间线上的一点。可以理解为人类的绝对时间。
        Instant now = Instant.now();
        System.out.println(now);
    }
    
    @Test
    public void testLocalDateToDate() {
        LocalDate now = LocalDate.now();
        Instant instant = now.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant();
        Date date = Date.from(instant);
        System.out.println(date);
    }
    
    @Test
    public void testDateToLocalDate() {
        Calendar calendar = Calendar.getInstance();
        Date date = calendar.getTime();
        Instant instant = date.toInstant();
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        LocalDate localDate = localDateTime.toLocalDate();
        System.out.println(localDate);
    }
    
    @Test
    public void testLocalDateToLocalDateTime() {
        LocalDate localDate = LocalDate.now();
        LocalDateTime localDateTime = localDate.atTime(12, 10, 59);
        System.out.println(localDateTime);
    }
    
    @Test
    public void testBetween() {
        // LocalDate localDate = LocalDate.now();
        LocalDate localDate = LocalDate.of(2020, 4, 20);
        LocalDate localDate1 = LocalDate.of(2020, 3, 26);
        System.out.println(localDate + " -> " + localDate1 + " 相差!： " + localDate.until(localDate1).getDays() + "天");
        System.out.println(localDate + " -> " + localDate1 + " 相差!： " + localDate.until(localDate1).getMonths() + "月");
        System.out.println(localDate + " -> " + localDate1 + " 相差!： " + localDate.until(localDate1).getYears() + "年");
        System.out.println();
        System.out.println(
                localDate + " -> " + localDate1 + " 相差@： " + localDate.until(localDate1, ChronoUnit.DAYS) + "天");
        System.out.println(
                localDate + " -> " + localDate1 + " 相差@： " + localDate.until(localDate1, ChronoUnit.WEEKS) + "周");
        System.out.println(
                localDate + " -> " + localDate1 + " 相差@： " + localDate.until(localDate1, ChronoUnit.MONTHS) + "月");
        System.out.println(
                localDate + " -> " + localDate1 + " 相差@： " + localDate.until(localDate1, ChronoUnit.YEARS) + "年");
    }
}
