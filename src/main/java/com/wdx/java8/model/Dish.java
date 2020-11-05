package com.wdx.java8.model;

/**
 * @author wangdongxing
 * @since 2019-02-19 09:45
 */
public class Dish {

    private String name;

    private Integer calories;

    private Integer type;

    private Boolean isVegetarian;

    public Dish(String name, Integer calories, Integer type) {
        this.name = name;
        this.calories = calories;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCalories() {
        return calories;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        type = type;
    }

    public Boolean getIsVegetarian() {
        return isVegetarian;
    }

    public void setIsVegetarian(Boolean vegetarian) {
        isVegetarian = vegetarian;
    }
}
