package designpattern.iteratorcomposite.composite;

import designpattern.iteratorcomposite.composite.menu.Menu;
import designpattern.iteratorcomposite.composite.menu.MenuComponent;
import designpattern.iteratorcomposite.composite.menu.MenuItem;

/**
 * 组合模式
 * 定义：允许你将对象组合成树形结构来表现“整体/部分”层次结构。
 * 组合能让客户以一致的方式处理个别对象以及对象组合。
 * 要点：
 * 1、组合模式提供一个结构，可同时包容个别对象和组合对象
 * 2、组合模式允许客户对个别对象以及组合对象一视同仁
 * 3、组合结构内的任意对象称为组件，组件可以是组合，也可以是叶节点
 * 4、在实现组合模式时，有许多设计上的的折衷。你要根据需要平衡透明性和安全性
 *
 * @author wangdongxing
 * @since 2019-01-14 11:04
 */
public class CompositePatternMain {

    public static void main(String[] args) {
        MenuComponent allMenus = new Menu("所有菜单", "all");

        MenuComponent breakfast = new Menu("早餐", "breakfast");
        MenuItem slop = new MenuItem("粥", "小米粥", true, 0.5);
        MenuItem egg = new MenuItem("鸡蛋", "鸡蛋", false, 0.8);
        MenuItem bread = new MenuItem("馒头", "", true, 0.4);
        breakfast.add(slop);
        breakfast.add(egg);
        breakfast.add(bread);
        allMenus.add(breakfast);

        MenuComponent dinner = new Menu("午餐", "launch");
        MenuItem noodle = new MenuItem("面条", "烩面", true, 1.2);
        MenuItem dumplings = new MenuItem("饺子", "猪肉大葱", false, 3.2);
        dinner.add(noodle);
        dinner.add(dumplings);

        MenuComponent dinnerChild = new Menu("小午餐", "launch-child");
        MenuItem noodleChild = new MenuItem("小面条", "小烩面", true, 1.2);
        dinnerChild.add(noodleChild);
        dinner.add(dinnerChild);
        allMenus.add(dinner);

        MenuComponent supper = new Menu("晚餐", "supper");
        MenuItem huoGuo = new MenuItem("火锅", "火锅", false, 23.2);
        supper.add(huoGuo);
        supper.add(dinner);
        allMenus.add(supper);

        allMenus.print();
    }

}
