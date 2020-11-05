package designpattern.state;

/**
 * 糖果机
 *
 * @author wangdongxing
 * @since 2018/11/26 5:11 PM
 */
public class GumballMachine {

    /**
     * 售罄状态为0
     */
    State soldOutState;

    /**
     * 机内没有25分钱状态为1
     */
    State noQuarterState;

    /**
     * 糖果机内已有25分钱状态为1
     */
    State hasQuarterState;

    /**
     * 已售出
     */
    State soldState;

    /**
     * 赢家状态
     */
    State winnerState;

    State state = soldOutState;

    int count = 0;

    public GumballMachine(int numberGumballs) {
        soldOutState = new SoldOutState(this);
        noQuarterState = new NoQuarterState(this);
        hasQuarterState = new HasQuarterState(this);
        soldState = new SoldState(this);
        winnerState = new WinnerState(this);
        this.count = numberGumballs;
        if (count > 0) {
            state = noQuarterState;
        }
    }

    /**
     * 投入25分钱
     *
     * @param
     * @return void
     * @author wangdongxing
     * @since 2018/11/27 07:54
     */
    public void insertQuarter() {
        state.insertQuarter();
    }

    /**
     * 吐出25分钱
     *
     * @param
     * @return void
     * @author wangdongxing
     * @since 2018/11/27 07:54
     */
    public void ejectQuarter() {
        state.ejectQuarter();
    }

    /**
     * 转动曲柄
     *
     * @param
     * @return void
     * @author wangdongxing
     * @since 2018/11/27 07:55
     */
    public void turnCrank() {
        state.turnCrank();
        System.out.println(state.getClass().getName());
        // 发放糖果
        state.dispense();
    }

    public void setState(State state) {
        this.state = state;
    }

    /**
     * 糖果滚出
     *
     * @param
     * @return void
     * @author wangdongxing
     * @since 2018/11/27 07:56
     */
    void releaseBall() {
        System.out.println("一个糖果正在滚出。。。");
        if (count > 0) {
            count--;
        }
    }

    public State getSoldOutState() {
        return soldOutState;
    }

    public State getNoQuarterState() {
        return noQuarterState;
    }

    public State getHasQuarterState() {
        return hasQuarterState;
    }

    public State getSoldState() {
        return soldState;
    }

    public State getState() {
        return state;
    }

    public int getCount() {
        return count;
    }

    public State getWinnerState() {
        return winnerState;
    }

}
