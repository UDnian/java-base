package designpattern.observer.impl;

import designpattern.observer.Observer;
import designpattern.observer.Subject;

import java.util.ArrayList;
import java.util.List;

/**
 * 追踪来自气象站的数据，并更新布告板
 *
 * @author wangdongxing
 * @since 2018/10/25 6:50 PM
 */
public class WeatherData implements Subject {
    private float temperature;

    private float humidity;

    private float pressure;

    private List<Observer> observerList;

    public WeatherData() {
        observerList = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        if (observerList.indexOf(observer) >= 0) {
            observerList.remove(observer);
        }
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observerList) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void measurementsChanged() {
        notifyObservers();
    }

    public void setMeasurements(float temperature, float humidity, float pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }
}
