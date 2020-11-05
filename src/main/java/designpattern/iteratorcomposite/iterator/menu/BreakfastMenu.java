package designpattern.iteratorcomposite.iterator.menu;

import designpattern.iteratorcomposite.iterator.MenuItem;
import designpattern.iteratorcomposite.iterator.iterator.BreakfastIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author wangdongxing
 * @since 2019-01-11 17:24
 */
public class BreakfastMenu {

    private List<MenuItem> menuItemList;

    public BreakfastMenu() {
        menuItemList = new ArrayList<>();
        MenuItem slop = new MenuItem("粥", "小米粥", true, 0.5);
        MenuItem egg = new MenuItem("鸡蛋", "鸡蛋", false, 0.8);
        MenuItem bread = new MenuItem("馒头", "", true, 0.4);
        menuItemList.add(slop);
        menuItemList.add(egg);
        menuItemList.add(bread);
    }

    public List<MenuItem> getMenuItemList() {
        return menuItemList;
    }

    public Iterator<MenuItem> createIterator() {
        return new BreakfastIterator(menuItemList);
    }

}
