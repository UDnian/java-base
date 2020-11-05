package com.wdx.web.service;

import com.wdx.web.model.User;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author wangdongxing
 * @since 2020-01-04 10:32
 */
@Service
public class UserService {

    public User getUser(Long id) {
        return new User(id, "Mr.wang", 30, new Date());
    }

    public User getUser(Long id, String name) {
        return new User(id, name, 30, new Date());
    }

}
