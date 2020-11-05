package designpattern.observer;

import designpattern.observer.impl.CurrentConditionsDisplay;
import designpattern.observer.impl.WeatherData;

/**
 * 观察者模式
 * 定义：在对象之间定义一对多的依赖，这样一来，当一个对象改变状态，依赖它的对象都会收到通知，并自动更新
 * 要点：
 * 1、观察者模式定义了对象之间一对多的关系
 * 2、主题（也就是可观察者）用一个共同的接口来更新观察者
 * 3、观察者和可观察者之间用松耦合方式结合，可观察者不知道观察者的细节，只知道观察者实现了观察者接口
 * 4、使用此模式时，你可从被观察者处推（push）或拉（pull）数据（然而，推的方式被认为更“正确”）
 * 5、有多个观察者时，不可以依赖特定的通知次序。
 * 6、Java有多种观察者模式的实现，包括了能用的java.util.Observable
 * 7、要注意java.util.Observable实现上所带来的一些问题
 * 8、如果有必要的话，可以实现自己的Observable，这并不难，不要害怕
 * 9、Swing大量使用观察者模式，许多GUI框架也是如此
 * 10、此模式也被应用在许多地方，例如：JavaBean、RMI
 *
 * @author wangdongxing
 * @since 2018/10/25 6:48 PM
 */
public class ObserverPatternMain {

    public static void main(String[] args) {
        WeatherData weatherData = new WeatherData();
        CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(weatherData);
        weatherData.setMeasurements(23L, 12L, 1300L);

        // 移去观察者，主题元素数据改变时就不会通知到观察者了
        weatherData.removeObserver(currentConditionsDisplay);
        weatherData.setMeasurements(23L, 22L, 2300L);
    }

}
