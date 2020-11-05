package designpattern.mediator;

/**
 * 中介者模式
 * 定义：定义一个中介对象来封装一系列对象之间的交互，使原有对象之间的耦合松散，且可以独立地改变它们之间的交互。中介者模式又叫调停模式，它是迪米特法则的典型应用。
 * <p>
 * 模式的结构：
 * 抽象中介者（Mediator）角色：它是中介者的接口，提供了同事对象注册与转发同事对象信息的抽象方法。
 * 具体中介者（ConcreteMediator）角色：实现中介者接口，定义多个同事或一个 List 来管理多个同事对象，协调各个同事角色之间的交互关系，因此它依赖于同事角色。
 * 抽象同事类（Colleague）角色：定义同事类的接口，保存中介者对象，提供同事对象交互的抽象方法，实现所有相互影响的同事类的公共功能。
 * 具体同事类（Concrete Colleague）角色：是抽象同事类的实现者，当需要与其他同事对象交互时，由中介者对象负责后续的交互。
 *
 * @author wangdongxing
 * @since 2020/10/12 7:57 下午
 */
public class MediatorMain {
    public static void main(String[] args) {
        MsgMediator msgMediator = new MsgMediator();
        ColleagueA colleagueA = new ColleagueA("张三", msgMediator);
        ColleagueB colleagueB = new ColleagueB("李四", msgMediator);
        msgMediator.setColleagueA(colleagueA);
        msgMediator.setColleagueB(colleagueB);
        colleagueA.contact("hi, 在么？", msgMediator);
        colleagueB.contact("在呀，啥事？", msgMediator);
    }
}

abstract class Colleague {
    String name;
    
    Mediator mediator;
    
    abstract void contact(String msg, Mediator mediator);
}

abstract class Mediator {
    abstract void contact(String msg, Colleague colleague);
}

class ColleagueA extends Colleague {
    ColleagueA(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
    
    public void getMsg(String msg) {
        System.out.println(name + "获取信息 " + msg);
    }
    
    @Override
    void contact(String msg, Mediator mediator) {
        mediator.contact(msg, this);
    }
}

class ColleagueB extends Colleague {
    ColleagueB(String name, Mediator mediator) {
        this.name = name;
        this.mediator = mediator;
    }
    
    public void getMsg(String msg) {
        System.out.println(name + "获取信息 " + msg);
    }
    
    @Override
    void contact(String msg, Mediator mediator) {
        mediator.contact(msg, this);
    }
}

class MsgMediator extends Mediator {
    
    private ColleagueA colleagueA;
    
    private ColleagueB colleagueB;
    
    @Override
    void contact(String msg, Colleague colleague) {
        if (colleague == colleagueA) {
            colleagueB.getMsg(msg);
        } else if (colleague == colleagueB) {
            colleagueA.getMsg(msg);
        }
    }
    
    public void setColleagueA(ColleagueA colleagueA) {
        this.colleagueA = colleagueA;
    }
    
    public void setColleagueB(ColleagueB colleagueB) {
        this.colleagueB = colleagueB;
    }
}
