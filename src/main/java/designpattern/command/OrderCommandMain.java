package designpattern.command;

/**
 * 命令模式
 * 定义：将请求封装成对象，这可以让你使用不同的请求、队列，或者日志请求来参数化其他对象。命令模式也是可以支持撤销操作。
 * <p>
 * 要点
 * 1、命令模式将发出请求的对象和执行请求的对象解耦
 * 2、在被解耦的两者之间是通过命令对象进行沟通的。命令对象封装了接收者和一个或一组动作
 * 3、调用者通过调用命令对象的execute()发出请求，这会使得接收者的动作被调用
 * 4、调用者可以接受命令当做参数，甚至在运行时动态的进行
 * 5、命令可以支持撤销，做法是实现一个undo()方法来回到execute()被执行前的状态
 * 6、宏命令是命令的一种简单的延伸，允许调用多个命令。宏方法也可以支持撤销
 * 7、实际操作时，很常见使用“聪明”命令对象，也就是直接实现了请求，而不是将工作委托给接收者
 * 8、命令也可以用来实现日志和事务系统
 *
 * @author wangdongxing
 * @since 2018/11/20 5:24 PM
 */
public class OrderCommandMain {

    public static void main(String[] args) {
        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        Light light = new Light();
        Command command = new LightOnCommand(light);
        simpleRemoteControl.setSlot(command);
        simpleRemoteControl.buttonWasPressed();

        RemoteControl remoteControl = new RemoteControl();
        AirCondition airCondition = new AirCondition();
        remoteControl.setCommand(1, new LightOnCommand(light), new LightOffCommand(light));
        remoteControl.setCommand(2, new AirConditionOnCommand(airCondition), new AirConditionOffCommand(airCondition));

        System.out.println(remoteControl);
        remoteControl.onButtonWasPressed(1);
        remoteControl.offButtonWasPressed(1);
        remoteControl.onButtonWasPressed(2);
        // 撤销上次操作
        remoteControl.undoButtonWasPressed();
        remoteControl.offButtonWasPressed(2);

    }

}
