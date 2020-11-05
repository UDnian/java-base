package com.wdx.web.interceptor.impl;

import com.wdx.web.model.User;
import com.wdx.web.service.UserService;
import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;

/**
 * @author wangdongxing
 * @since 2020-01-04 10:29
 */
public class UserFormatter implements Formatter<User> {

    private UserService userService;

    public UserFormatter(UserService userService) {
        this.userService = userService;
    }

    /**
     * Parse a text String to produce a T.
     *
     * @param text the text string
     * @param locale the current user locale
     * @return an instance of T
     * @throws ParseException           when a parse exception occurs in a java.text parsing library
     * @throws IllegalArgumentException when a parse exception occurs
     */
    @Override
    public User parse(String text, Locale locale) throws ParseException {
        // PropertyEditor
        return userService.getUser(Long.parseLong(text));
    }

    /**
     * Print the object of type T for display.
     *
     * @param object the instance to print
     * @param locale the current user locale
     * @return the printed text string
     */
    @Override
    public String print(User object, Locale locale) {
        return object.getId().toString();
    }
}
