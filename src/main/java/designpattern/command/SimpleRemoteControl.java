package designpattern.command;

/**
 * 简单的遥控器
 *
 * @author wangdongxing
 * @since 2018/11/20 5:27 PM
 */
public class SimpleRemoteControl {

    private Command slot;

    public SimpleRemoteControl() {
    }

    public void setSlot(Command slot) {
        this.slot = slot;
    }

    public void buttonWasPressed() {
        slot.execute();
    }
}
