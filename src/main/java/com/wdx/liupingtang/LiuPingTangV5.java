package com.wdx.liupingtang;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wangdongxing
 * @since 2020/8/13 5:03 下午
 */
public class LiuPingTangV5 {
    
    public static void main(String[] args) {
        //        long init = 5285890802920700000L;
        //        long init = 5285890802920000000L;
        //        go(init, 0, 1000000);
        
        String urlPrefix = "https://playvideo.qcloud.com/getplayinfo/v4/1254153797/";
        long init = 5285890803047000000L;
        go(urlPrefix, init, 0, 1000000);
    }
    
    public static void go(String urlPrefix, long init, int startParam, int endParam) {
        
        int threadNum = 20;
        int each = (endParam - startParam) / threadNum;
        for (int t = 0; t < threadNum; t++) {
            int t1 = t;
            long start = init + t * each;
            long end = init + (t + 1) * each;
            new Thread(() -> {
                RestTemplate restTemplate = new RestTemplate();
                List<String> list = new ArrayList<>();
                for (long i = start; i < end; i++) {
                    /* 业务实现 开始 */
                    String result = restTemplate.getForObject(urlPrefix + i, String.class);
                    JSONObject json = JSONObject.parseObject(result);
                    int code = json.getIntValue("code");
                    if (code == 0) {
                        JSONObject videoInfo = json.getJSONObject("videoInfo");
                        JSONObject basicInfo = videoInfo.getJSONObject("basicInfo");
                        JSONObject sourceVideo = videoInfo.getJSONObject("sourceVideo");
                        String name = basicInfo.getString("name");
                        String videoUrl = sourceVideo.getString("url");
                        String info = i + "@@" + name + "@@" + videoUrl;
                        list.add(info);
                    }
                    /* 业务实现 结束 */
                    if (t1 == 0) {
                        if (i % (each / 10) == 0) {
                            System.out.println(i - init);
                        }
                        //                        else {
                        //                            System.out.print((i - init) + " ");
                        //                        }
                    }
                }
                System.out.println();
                list.forEach(System.out::println);
            }, "go thread " + t).start();
        }
    }
    
}
