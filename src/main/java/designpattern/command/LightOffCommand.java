package designpattern.command;

/**
 * 关灯命令
 *
 * @author wangdongxing
 * @since 2018/11/20 6:09 PM
 */
public class LightOffCommand implements Command {

    public Light light;

    public LightOffCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}
