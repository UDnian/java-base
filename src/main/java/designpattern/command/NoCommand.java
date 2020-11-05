package designpattern.command;

/**
 * 没任何命令操作
 *
 * @author wangdongxing
 * @since 2018/11/20 6:00 PM
 */
public class NoCommand implements Command {
    @Override
    public void execute() {

    }

    @Override
    public void undo() {

    }
}
