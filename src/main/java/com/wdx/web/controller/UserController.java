package com.wdx.web.controller;

import com.wdx.web.interceptor.impl.UserId;
import com.wdx.web.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

/**
 * @author wangdongxing
 * @since 2020-01-04 10:57
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @RequestMapping("/info/{userId}")
    @ResponseBody
    public String getUserInfo(@PathVariable("userId") User user) {
        return user.toString();
    }

    @RequestMapping("/info2/{userId}")
    @ResponseBody
    public String getUserInfo(@PathVariable("userId") Long userId) {
        return userId.toString();
    }

    @RequestMapping("/date/{date}")
    @ResponseBody
    public String getUserInfo(@PathVariable("date") String date) {
        return date;
    }

    @RequestMapping("/dateFormat")
    @ResponseBody
    public String getUserInfo(Date date) {
        return date.toString();
    }

    @RequestMapping("/argumentResolver")
    @ResponseBody
    public String getUserId(@UserId Long userId, User user) {
        return "解析到参数里面的userId: " + userId + "\n解析到参数里面的实体user: " + user;
    }

    @RequestMapping("/responseExceptionHandler")
    @ResponseBody
    public String getUserId(@RequestParam int i) {
        int j = 10000 / i;
        return Integer.toString(j);
    }

}
