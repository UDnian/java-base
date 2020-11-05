package designpattern.iteratorcomposite.iterator;

import designpattern.iteratorcomposite.iterator.menu.BreakfastMenu;
import designpattern.iteratorcomposite.iterator.menu.DinnerMenu;

/**
 * 迭代器模式
 * 定义：提供一种方法顺序访问一个聚合对象中的各个元素，而又不暴露其内部的表示。
 * 原则：一个类应该只有一个引起变化的原因
 * 要点：
 * 1、迭代器允许访问聚合的元素，而不需要暴露它的内部结构
 * 2、迭代器将遍历聚合的工作封装进一个对象中
 * 3、当使用迭代器的时候，我们依赖聚合提供遍历
 * 4、迭代器提供了一个通用的接口，让我们遍历聚合的项，当我们编码使用聚合的项时，就可以使用多态机制
 *
 * @author wangdongxing
 * @since 2019-01-11 18:07
 */
public class IteratorPatternMain {

    public static void main(String[] args) {
        new Waitress(new BreakfastMenu(), new DinnerMenu()).printMenu();
    }

}
