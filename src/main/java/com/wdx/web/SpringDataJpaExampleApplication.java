package com.wdx.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author wangdongxing
 * @since 2019-12-31 15:51
 */
@SpringBootApplication(scanBasePackages = "com.wdx.web")
public class SpringDataJpaExampleApplication {
    public static void main(final String[] args) {
        SpringApplication.run(SpringDataJpaExampleApplication.class, args);
    }
}
