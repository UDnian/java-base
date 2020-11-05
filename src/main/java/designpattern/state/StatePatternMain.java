package designpattern.state;

/**
 * 状态模式
 * 定义：允许对象在内部状态改变时改变它的行为，对象看起来好像修改了它的类。
 * <p>
 * 要点：
 * 1、状态模式允许一个对象基于内部状态而拥有不同的行为
 * 2、和程序状态机（PSM）不同，状态模式用类代表状态
 * 3、Context会将行为委托给当前状态对象
 * 4、通过将每个状态封装进一个类，我们把以后需要做的任何改变局部化了
 * 5、状态模式和策略模式有相同的类图，但是它们的意图不同
 * 6、策略模式通常会用行为或算法来配置Context类
 * 7、状态模式允许Context随着状态的改变而改变行为
 * 8、状态转换可以由State类或Context类控制
 * 9、使用状态模式通常会导致设计中类的数目大量增加
 * 10、状态类可以被多个Context实例共享
 *
 * @author wangdongxing
 * @since 2018/11/27 8:21 AM
 */
public class StatePatternMain {

    public static void main(String[] args) {
        GumballMachine gumballMachine = new GumballMachine(10);
        for (int i = 0; i < 10; i++) {
            if (gumballMachine.getCount() == 0) {
                System.out.println("糖果已经售罄。欢迎下次再来！");
                break;
            }
            gumballMachine.insertQuarter();
            gumballMachine.turnCrank();
            System.out.println();
        }
    }

}
