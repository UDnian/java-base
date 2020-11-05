package designpattern.iteratorcomposite.iterator.menu;

import designpattern.iteratorcomposite.iterator.MenuItem;
import designpattern.iteratorcomposite.iterator.iterator.DinnerIterator;

import java.util.Iterator;

/**
 * @author wangdongxing
 * @since 2019-01-11 16:41
 */
public class DinnerMenu {
    private MenuItem[] menuItems;

    public DinnerMenu() {
        MenuItem noodle = new MenuItem("面条", "烩面", true, 1.2);
        MenuItem dumplings = new MenuItem("饺子", "猪肉大葱", false, 3.2);
        menuItems = new MenuItem[] { noodle, dumplings };
    }

    public MenuItem[] getMenuItems() {
        return menuItems;
    }

    public Iterator<MenuItem> createIterator() {
        return new DinnerIterator(menuItems);
    }
}
