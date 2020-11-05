package com.wdx.liupingtang;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangdongxing
 * @since 2020/8/13 5:03 下午
 */
public class LiuPingTang {
    
    @Test
    public void test1() {
        List<String> list = new ArrayList<>();
        RestTemplate restTemplate = new RestTemplate();
        String urlPrefix = "https://playvideo.qcloud.com/getplayinfo/v4/1254153797/";
        for (int i = 0; i < 100; i++) {
            long init = 5285890802920000000L + i;
            String url = urlPrefix + init;
            String result = restTemplate.getForObject(url, String.class);
            JSONObject json = JSONObject.parseObject(result);
            int code = json.getIntValue("code");
            if (code == 0) {
                JSONObject videoInfo = json.getJSONObject("videoInfo");
                JSONObject basicInfo = videoInfo.getJSONObject("basicInfo");
                String name = basicInfo.getString("name");
                list.add(name);
            }
        }
        //        System.out.println(result);
        list.forEach(System.out::println);
    }
    
    //    @Test
    public static void main(String[] args) {
        
        //        List<String> urlList = Collections.synchronizedList(list);
        RestTemplate restTemplate = new RestTemplate();
        String urlPrefix = "https://playvideo.qcloud.com/getplayinfo/v4/1254153797/";
        new Thread(() -> {
            List<String> list = new ArrayList<>();
            for (int i = 5000; i > 0; i--) {
                long init = 5285890802920700000L + i;
                String url = urlPrefix + init;
                String result = restTemplate.getForObject(url, String.class);
                JSONObject json = JSONObject.parseObject(result);
                int code = json.getIntValue("code");
                if (code == 0) {
                    JSONObject videoInfo = json.getJSONObject("videoInfo");
                    JSONObject basicInfo = videoInfo.getJSONObject("basicInfo");
                    JSONObject sourceVideo = videoInfo.getJSONObject("sourceVideo");
                    String name = basicInfo.getString("name");
                    String videoUrl = sourceVideo.getString("url");
                    System.out.println(name);
                    System.out.println(videoUrl);
                }
                System.out.println(i);
            }
        }).start();
        new Thread(() -> {
            List<String> list = new ArrayList<>();
            for (int i = 10000; i > 5000; i--) {
                long init = 5285890802920700000L + i;
                String url = urlPrefix + init;
                String result = restTemplate.getForObject(url, String.class);
                JSONObject json = JSONObject.parseObject(result);
                int code = json.getIntValue("code");
                if (code == 0) {
                    JSONObject videoInfo = json.getJSONObject("videoInfo");
                    JSONObject basicInfo = videoInfo.getJSONObject("basicInfo");
                    JSONObject sourceVideo = videoInfo.getJSONObject("sourceVideo");
                    String name = basicInfo.getString("name");
                    String videoUrl = sourceVideo.getString("url");
                    System.out.println(name);
                    System.out.println(videoUrl);
                }
            }
            list.forEach(System.out::println);
        }).start();
        new Thread(() -> {
            List<String> list = new ArrayList<>();
            for (int i = 15000; i > 10000; i--) {
                long init = 5285890802920700000L + i;
                String url = urlPrefix + init;
                String result = restTemplate.getForObject(url, String.class);
                JSONObject json = JSONObject.parseObject(result);
                int code = json.getIntValue("code");
                if (code == 0) {
                    JSONObject videoInfo = json.getJSONObject("videoInfo");
                    JSONObject basicInfo = videoInfo.getJSONObject("basicInfo");
                    JSONObject sourceVideo = videoInfo.getJSONObject("sourceVideo");
                    String name = basicInfo.getString("name");
                    String videoUrl = sourceVideo.getString("url");
                    System.out.println(name);
                    System.out.println(videoUrl);
                }
            }
        }).start();
        new Thread(() -> {
            List<String> list = new ArrayList<>();
            for (int i = 20000; i > 15000; i--) {
                long init = 5285890802920700000L + i;
                String url = urlPrefix + init;
                String result = restTemplate.getForObject(url, String.class);
                JSONObject json = JSONObject.parseObject(result);
                int code = json.getIntValue("code");
                if (code == 0) {
                    JSONObject videoInfo = json.getJSONObject("videoInfo");
                    JSONObject basicInfo = videoInfo.getJSONObject("basicInfo");
                    JSONObject sourceVideo = videoInfo.getJSONObject("sourceVideo");
                    String name = basicInfo.getString("name");
                    String videoUrl = sourceVideo.getString("url");
                    System.out.println(name);
                    System.out.println(videoUrl);
                }
            }
        }).start();
        
        //        new Thread(() -> {
        //            List<String> list = new ArrayList<>();
        //            for (int i = 20000; i < 40000; i++) {
        //                long init = 5285890802920700000L + i;
        //                String url = urlPrefix + init;
        //                String result = restTemplate.getForObject(url, String.class);
        //                JSONObject json = JSONObject.parseObject(result);
        //                int code = json.getIntValue("code");
        //                if (code == 0) {
        //                    JSONObject videoInfo = json.getJSONObject("videoInfo");
        //                    JSONObject basicInfo = videoInfo.getJSONObject("basicInfo");
        //                    String name = basicInfo.getString("name");
        //                    list.add(name);
        //                }
        //            }
        //            list.forEach(System.out::println);
        //        }).start();
        //
        //        new Thread(() -> {
        //            List<String> list = new ArrayList<>();
        //            for (int i = 40000; i < 60000; i++) {
        //                long init = 5285890802920700000L + i;
        //                String url = urlPrefix + init;
        //                String result = restTemplate.getForObject(url, String.class);
        //                JSONObject json = JSONObject.parseObject(result);
        //                int code = json.getIntValue("code");
        //                if (code == 0) {
        //                    JSONObject videoInfo = json.getJSONObject("videoInfo");
        //                    JSONObject basicInfo = videoInfo.getJSONObject("basicInfo");
        //                    String name = basicInfo.getString("name");
        //                    list.add(name);
        //                }
        //            }
        //            list.forEach(System.out::println);
        //        }).start();
        //
        //        new Thread(() -> {
        //            List<String> list = new ArrayList<>();
        //            for (int i = 60000; i < 80000; i++) {
        //                long init = 5285890802920700000L + i;
        //                String url = urlPrefix + init;
        //                String result = restTemplate.getForObject(url, String.class);
        //                JSONObject json = JSONObject.parseObject(result);
        //                int code = json.getIntValue("code");
        //                if (code == 0) {
        //                    JSONObject videoInfo = json.getJSONObject("videoInfo");
        //                    JSONObject basicInfo = videoInfo.getJSONObject("basicInfo");
        //                    String name = basicInfo.getString("name");
        //                    list.add(name);
        //                }
        //            }
        //            list.forEach(System.out::println);
        //        }).start();
        //
        //        new Thread(() -> {
        //            List<String> list = new ArrayList<>();
        //            for (int i = 80000; i < 100000; i++) {
        //                long init = 5285890802920700000L + i;
        //                String url = urlPrefix + init;
        //                String result = restTemplate.getForObject(url, String.class);
        //                JSONObject json = JSONObject.parseObject(result);
        //                int code = json.getIntValue("code");
        //                if (code == 0) {
        //                    JSONObject videoInfo = json.getJSONObject("videoInfo");
        //                    JSONObject basicInfo = videoInfo.getJSONObject("basicInfo");
        //                    String name = basicInfo.getString("name");
        //                    list.add(name);
        //                }
        //            }
        //            list.forEach(System.out::println);
        //        }).start();
        
    }
    
    @Test
    public void test3() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.forEach(System.out::println);
    }
    
}
