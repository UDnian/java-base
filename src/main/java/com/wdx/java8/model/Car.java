package com.wdx.java8.model;

import java.util.Optional;

/**
 * @author wangdongxing
 * @since 2019-02-21 09:53
 */
public class Car {

    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }

    public void setInsurance(Optional<Insurance> insurance) {
        this.insurance = insurance;
    }
}
