package designpattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 访问者模式：
 * 定义：将作用于某种数据结构中的各元素的操作分离出来封装成独立的类，使其在不改变数据结构的前提下可以添加作用于这些元素的新的操作，
 * 为数据结构中的每个元素提供多种访问方式。它将对数据的操作与数据结构进行分离，是行为类模式中最复杂的一种模式。
 * <p>
 * 模式的结构：
 * 抽象访问者（Visitor）角色：定义一个访问具体元素的接口，为每个具体元素类对应一个访问操作 visit() ，该操作中的参数类型标识了被访问的具体元素。
 * 具体访问者（ConcreteVisitor）角色：实现抽象访问者角色中声明的各个访问操作，确定访问者访问一个元素时该做什么。
 * 抽象元素（Element）角色：声明一个包含接受操作 accept() 的接口，被接受的访问者对象作为 accept() 方法的参数。
 * 具体元素（ConcreteElement）角色：实现抽象元素角色提供的 accept() 操作，其方法体通常都是 visitor.visit(this) ，另外具体元素中可能还包含本身业务逻辑的相关操作。
 * 对象结构（Object Structure）角色：是一个包含元素角色的容器，提供让访问者对象遍历容器中的所有元素的方法，通常由 List、Set、Map 等聚合类实现。
 *
 * @author wangdongxing
 * @since 2020/10/13 11:43 上午
 */
public class VisitorMain {
    public static void main(String[] args) {
        List<Bill> billList = new ArrayList<>();
        billList.add(new ConsumeBill(7.5, "早餐消费"));
        billList.add(new ConsumeBill(23, "中餐消费"));
        billList.add(new ConsumeBill(11, "晚餐消费"));
        billList.add(new IncomeBill(30.2, "卖废品收入"));
        billList.add(new IncomeBill(40, "卖菜收入"));
        BossBillVisitor bossBillVisitor = new BossBillVisitor();
        AccountantBillVisitor accountantBillVisitor = new AccountantBillVisitor();
        for (Bill bill : billList) {
            bill.accept(bossBillVisitor);
            bill.accept(accountantBillVisitor);
        }
        bossBillVisitor.report();
        accountantBillVisitor.report();
    }
}

/**
 * 账单
 */
abstract class Bill {
    double amount = 0;
    
    String itemName = "";
    
    abstract void accept(BillVisitor billVisitor);
    
    public double getAmount() {
        return amount;
    }
    
    public String getItemName() {
        return itemName;
    }
    
}

/**
 * 消费的账单
 */
class ConsumeBill extends Bill {
    ConsumeBill(double amount, String itemName) {
        this.amount = amount;
        this.itemName = itemName;
    }
    
    @Override
    public void accept(BillVisitor billVisitor) {
        billVisitor.visit(this);
    }
    
}

/**
 * 收入的账单
 */
class IncomeBill extends Bill {
    IncomeBill(double amount, String itemName) {
        this.amount = amount;
        this.itemName = itemName;
    }
    
    @Override
    public void accept(BillVisitor billVisitor) {
        billVisitor.visit(this);
    }
}

/**
 * 账单访问者
 */
abstract class BillVisitor {
    abstract void visit(ConsumeBill bill);
    
    abstract void visit(IncomeBill bill);
}

/**
 * 老板角色访问者
 */
class BossBillVisitor extends BillVisitor {
    double totalConsumeAmount = 0;
    
    double totalIncomeAmount = 0;
    
    double totalProfileAmount = 0;
    
    @Override
    public void visit(ConsumeBill bill) {
        totalConsumeAmount += bill.getAmount();
        totalProfileAmount -= bill.getAmount();
    }
    
    @Override
    public void visit(IncomeBill bill) {
        totalIncomeAmount += bill.getAmount();
        totalProfileAmount += bill.getAmount();
    }
    
    public void report() {
        System.out.println("老板查看账单报告结果：\n\t总消费: " + totalConsumeAmount + "\n\t总收入: " + totalIncomeAmount + "\n\t净利润: "
                + totalProfileAmount);
    }
}

/**
 * 会计角色访问者
 */
class AccountantBillVisitor extends BillVisitor {
    String consumeDetail = "";
    
    String incomeDetail = "";
    
    @Override
    public void visit(ConsumeBill bill) {
        consumeDetail += bill.getItemName() + " 消费金额：" + bill.getAmount() + "； ";
    }
    
    @Override
    public void visit(IncomeBill bill) {
        incomeDetail += bill.getItemName() + " 收入金额：" + bill.getAmount() + "； ";
    }
    
    public void report() {
        System.out.println("会计查看账单报告结果：\n\t全部消费明细：\n\t\t" + consumeDetail + "\n\t全部收入明细：\n\t\t" + incomeDetail);
    }
}
