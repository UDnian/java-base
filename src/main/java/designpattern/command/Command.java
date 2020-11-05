package designpattern.command;

/**
 * 命令接口
 *
 * @author wangdongxing
 * @since 2018/11/20 5:20 PM
 */
public interface Command {

    public void execute();

    public void undo();

}
