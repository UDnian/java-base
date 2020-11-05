package designpattern.command;

/**
 * 开灯命令
 *
 * @author wangdongxing
 * @since 2018/11/20 5:21 PM
 */
public class LightOnCommand implements Command {

    private Light light;

    public LightOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.off();
    }
}
