package designpattern.interpreter;

import java.util.HashSet;
import java.util.Set;

/**
 * 解释器模式
 * 定义：给分析对象定义一个语言，并定义该语言的文法表示，再设计一个解析器来解释语言中的句子。也就是说，用编译语言的方式来分析应用中的实例。
 * 这种模式实现了文法表达式处理的接口，该接口解释一个特定的上下文。
 * <p>
 * 模式的结构：
 * 抽象表达式（Abstract Expression）角色：定义解释器的接口，约定解释器的解释操作，主要包含解释方法 interpret()。
 * 终结符表达式（Terminal Expression）角色：是抽象表达式的子类，用来实现文法中与终结符相关的操作，文法中的每一个终结符都有一个具体终结表达式与之相对应。
 * 非终结符表达式（Nonterminal Expression）角色：也是抽象表达式的子类，用来实现文法中与非终结符相关的操作，文法中的每条规则都对应于一个非终结符表达式。
 * 环境（Context）角色：通常包含各个解释器需要的数据或是公共的功能，一般用来传递被所有解释器共享的数据，后面的解释器可以从这里获取这些值。
 * 客户端（Client）：主要任务是将需要分析的句子或表达式转换成使用解释器对象描述的抽象语法树，然后调用解释器的解释方法，当然也可以通过环境角色间接访问解释器的解释方法。
 * <p>
 * 公交车读卡器可以判断乘客的身份，如果是“韶关”或者“广州”的“老人” “妇女”“儿童”就可以免费乘车，其他人员乘车一次扣1元。
 *
 * <expression> ::= <city>的<person>
 * <city> ::= 韶关|广州
 * <person> ::= 老人|妇女|儿童
 *
 * @author wangdongxing
 * @since 2020/10/13 3:55 下午
 */
public class InterpreterMain {
    public static void main(String[] args) {
        Context bus = new Context();
        bus.freeRide("韶关的老人");
        bus.freeRide("韶关的年轻人");
        bus.freeRide("广州的妇女");
        bus.freeRide("广州的儿童");
        bus.freeRide("山东的儿童");
    }
}

/**
 * 抽象表达式类
 */
interface Expression {
    boolean interpreter(String s);
}

/**
 * 终结符表达式类
 */
class TerminalExpression implements Expression {
    Set<String> set;
    
    TerminalExpression(String ss) {
        String[] split = ss.split(",");
        set = new HashSet<>(split.length);
        for (String s : split) {
            set.add(s);
        }
    }
    
    @Override
    public boolean interpreter(String s) {
        return set.contains(s);
    }
}

/**
 * 非终结符(与)表达式类
 */
class AndExpression implements Expression {
    Expression cityExpression;
    
    Expression personExpression;
    
    AndExpression(Expression cityExpression, Expression personExpression) {
        this.cityExpression = cityExpression;
        this.personExpression = personExpression;
    }
    
    @Override
    public boolean interpreter(String s) {
        String[] cityPersonArray = s.split("的");
        String city = cityPersonArray[0];
        String person = cityPersonArray[1];
        return cityExpression.interpreter(city) && personExpression.interpreter(person);
    }
}

/**
 * 环境类
 */
class Context {
    String citys = "韶关,广州";
    
    String person = "老人,妇女,儿童";
    
    Expression cityPersonExpression;
    
    Context() {
        Expression cityExpression = new TerminalExpression(citys);
        Expression personExpression = new TerminalExpression(person);
        cityPersonExpression = new AndExpression(cityExpression, personExpression);
    }
    
    public void freeRide(String s) {
        boolean isFree = cityPersonExpression.interpreter(s);
        if (isFree) {
            System.out.println(s + "，可以免费乘车！");
        } else {
            System.out.println(s + "，您不是免费人员，本次乘车扣除1元！");
        }
    }
}





