package designpattern.command;

/**
 * 远程遥控器
 *
 * @author wangdongxing
 * @since 2018/11/20 5:58 PM
 */
public class RemoteControl {

    /**
     * 2个开启开关
     */
    Command[] onCommands;

    /**
     * 2个关闭开关
     */
    Command[] offCommands;

    /**
     * 最近一次执行过的命令
     */
    Command undoCommand;

    public RemoteControl() {
        onCommands = new Command[2];
        offCommands = new Command[2];

        Command command = new NoCommand();
        for (int i = 0; i < 2; i++) {
            onCommands[i] = command;
            offCommands[i] = command;
        }
    }

    public void setCommand(int slot, Command onCommand, Command offCommand) {
        if (slot > 2) {
            System.err.println("没有更多按钮了");
        }
        onCommands[slot - 1] = onCommand;
        offCommands[slot - 1] = offCommand;
    }

    public void onButtonWasPressed(int slot) {
        onCommands[slot - 1].execute();
        undoCommand = onCommands[slot - 1];
    }

    public void offButtonWasPressed(int slot) {
        offCommands[slot - 1].execute();
        undoCommand = offCommands[slot - 1];
    }

    public void undoButtonWasPressed() {
        undoCommand.undo();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("----------远程遥控器开关部署情况-----------\n");
        for (int i = 0; i < onCommands.length; i++) {
            sb.append("[slot" + i + "] " + onCommands[i].getClass().getName() + "   " + offCommands[i].getClass()
                    .getName() + "\n");
        }
        return sb.toString();
    }
}
