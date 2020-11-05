package designpattern.state;

/**
 * 售罄状态
 *
 * @author wangdongxing
 * @since 2018/11/26 6:27 PM
 */
public class SoldOutState implements State {
    private GumballMachine gumballMachine;

    public SoldOutState(GumballMachine gumballMachine) {
        this.gumballMachine = gumballMachine;
    }

    @Override
    public void insertQuarter() {
        System.out.println("sorry，糖果已经售罄了");
    }

    @Override
    public void ejectQuarter() {
        System.out.println("你还没投钱，要怎么给你退钱呢？");
    }

    @Override
    public void turnCrank() {
        System.out.println("sorry，糖果已经售罄了");
    }

    @Override
    public void dispense() {
        System.out.println("sorry，糖果已经售罄了");
    }
}
