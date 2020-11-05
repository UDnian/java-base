package designpattern.state;

import java.util.Random;

/**
 * 糖果机内已有25分钱状态
 *
 * @author wangdongxing
 * @since 2018/11/26 6:28 PM
 */
public class HasQuarterState implements State {
    Random random = new Random(System.currentTimeMillis());

    private GumballMachine gumballMachine;

    public HasQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("已经投过钱了，请转动曲柄抽奖！");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("要退钱了");
        gumballMachine.setState(gumballMachine.getNoQuarterState());
    }

    @Override
    public void turnCrank() {
        System.out.println("要抽奖了");
        //        gumballMachine.setState(gumballMachine.getSoldState());
        int i = random.nextInt(5);
        if (i == 0 && gumballMachine.getCount() > 1) {
            gumballMachine.setState(gumballMachine.getWinnerState());
        } else {
            gumballMachine.setState(gumballMachine.getSoldState());
        }
    }

    @Override
    public void dispense() {
        System.out.println("请先转动曲柄，才能得到糖果");
    }
}
