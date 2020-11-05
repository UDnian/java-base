package designpattern.observer.impl;

import designpattern.observer.DisplayElement;
import designpattern.observer.Observer;
import designpattern.observer.Subject;

/**
 * 气象展示面板
 *
 * @author wangdongxing
 * @since 2018/10/29 8:41 AM
 */
public class CurrentConditionsDisplay implements Observer, DisplayElement {
    private float temperature;

    private float humidity;

    private Subject weatherData;

    public CurrentConditionsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("CurrentConditionsDisplay: temperature-" + temperature + " humidity-" + humidity);
    }

    @Override
    public void update(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        display();
    }
}
