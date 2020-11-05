package designpattern.state;

/**
 * 状态接口
 * 1、糖果机的每个动作都有一个对应的方法
 * 2、然后为机器中的每个状态实现状态类。这些类将负责在对应的状态下进行机器的行为
 * 3、最后，我们要摆脱旧的条件代码，取而代之的方式是，将动作委托到状态类
 *
 * @author wangdongxing
 * @since 2018/11/26 4:45 PM
 */
public interface State {

    /**
     * 投入25分钱
     */
    void insertQuarter();

    /**
     * 吐出25分钱
     */
    void ejectQuarter();

    /**
     * 转动曲柄
     */
    void turnCrank();

    /**
     * 发放糖果
     */
    void dispense();

}
