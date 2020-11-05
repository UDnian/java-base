package com.wdx.java8;

import com.wdx.java8.model.Apple;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wangdongxing
 * @since 2019-02-25 10:33
 */
public class LambdaStreamOptionalTest {

    public static void main(String[] args) {
        List<Apple> appleList = Arrays.asList(new Apple("a", 100), new Apple("a", 200), new Apple("b", 100));
        Stream<Apple> stream = appleList.stream();
        // Map<String, Integer> map = appleList.stream().collect(Collectors.toMap(Apple::getColor, Apple::getWeight));
        Map<String, List<Apple>> map1 = appleList.stream().collect(Collectors.groupingBy(Apple::getColor));
        System.out.println(map1);
    }

}
