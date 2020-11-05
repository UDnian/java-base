package designpattern.command;

/**
 * 空调关闭命令
 *
 * @author wangdongxing
 * @since 2018/11/20 6:18 PM
 */
public class AirConditionOffCommand implements Command {

    private AirCondition airCondition;

    public AirConditionOffCommand(AirCondition airCondition) {
        this.airCondition = airCondition;
    }

    @Override
    public void execute() {
        airCondition.off();
    }

    @Override
    public void undo() {
        airCondition.on();
    }
}
