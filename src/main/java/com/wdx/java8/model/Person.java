package com.wdx.java8.model;

import java.io.Serializable;
import java.util.Optional;

/**
 * @author wangdongxing
 * @since 2019-02-21 09:53
 */
public class Person implements Serializable {

    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }

    public void setCar(Optional<Car> car) {
        this.car = car;
    }
}
