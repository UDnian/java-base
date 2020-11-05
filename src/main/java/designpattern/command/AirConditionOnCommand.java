package designpattern.command;

/**
 * 空调开户命令
 *
 * @author wangdongxing
 * @since 2018/11/20 6:14 PM
 */
public class AirConditionOnCommand implements Command {

    private AirCondition airCondition;

    public AirConditionOnCommand(AirCondition airCondition) {
        this.airCondition = airCondition;
    }

    @Override
    public void execute() {
        airCondition.on();
    }

    @Override
    public void undo() {
        airCondition.off();
    }
}
