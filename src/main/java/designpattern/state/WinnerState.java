package designpattern.state;

/**
 * @author wangdongxing
 * @since 2018/11/27 9:06 AM
 */
public class WinnerState implements State {

    private GumballMachine gumballMachine;

    public WinnerState(GumballMachine gumballMachine) {
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
        System.out.println("你是大赢家，将得到两个糖果 ******");
        gumballMachine.releaseBall();
        if (gumballMachine.getCount() == 0) {
            gumballMachine.setState(gumballMachine.getSoldOutState());
        } else {
            gumballMachine.releaseBall();
            if (gumballMachine.getCount() > 0) {
                gumballMachine.setState(gumballMachine.getNoQuarterState());
            } else {
                System.out.println("糖果已没有了");
                gumballMachine.setState(gumballMachine.getSoldOutState());
            }
        }
    }
}
