package designpattern.state;

/**
 * 出售状态
 *
 * @author wangdongxing
 * @since 2018/11/26 6:15 PM
 */
public class SoldState implements State {

    private GumballMachine gumballMachine;

    public SoldState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("等等，我们已经给了你一个糖果，不要再投币！");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("对不起，你已经转动曲柄，抽奖中，不能退币！");
    }

    @Override
    public void turnCrank() {
        System.out.println("别转动曲柄啦，抽奖中。。。");
    }

    @Override
    public void dispense() {
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() > 0) {
            gumballMachine.setState(gumballMachine.getNoQuarterState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        }
    }
}
