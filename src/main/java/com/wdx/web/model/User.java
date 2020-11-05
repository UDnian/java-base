package com.wdx.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户
 *
 * @author wangdongxing
 * @since 2020-01-04 10:13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {

    private Long id;

    private String name;

    private Integer age;

    private Date birthday;
}
