package designpattern.state;

/**
 * 机内没有25分钱状态
 *
 * @author wangdongxing
 * @since 2018/11/26 6:29 PM
 */
public class NoQuarterState implements State {
    private GumballMachine gumballMachine;

    public NoQuarterState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("你投入了25分钱");
        gumballMachine.setState(gumballMachine.getHasQuarterState());
    }

    @Override
    public void ejectQuarter() {
        System.out.println("你还没投钱，要怎么给你退钱呢？");
    }

    @Override
    public void turnCrank() {
        System.out.println("你还没投钱呢，别转曲柄了！");
    }

    @Override
    public void dispense() {
        System.out.println("得先投钱！");
    }
}
