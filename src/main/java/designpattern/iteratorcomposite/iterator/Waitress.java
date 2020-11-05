package designpattern.iteratorcomposite.iterator;

import designpattern.iteratorcomposite.iterator.menu.BreakfastMenu;
import designpattern.iteratorcomposite.iterator.menu.DinnerMenu;

import java.util.Iterator;

/**
 * 女招待员
 *
 * @author wangdongxing
 * @since 2019-01-11 17:58
 */
public class Waitress {
    private BreakfastMenu breakfastMenu;

    private DinnerMenu dinnerMenu;

    public Waitress(BreakfastMenu breakfastMenu, DinnerMenu dinnerMenu) {
        this.breakfastMenu = breakfastMenu;
        this.dinnerMenu = dinnerMenu;
    }

    public void printMenu() {
        Iterator<MenuItem> breakfastMenuIterator = breakfastMenu.createIterator();
        Iterator<MenuItem> dinnerMenuIterator = dinnerMenu.createIterator();
        printMenu(breakfastMenuIterator);
        printMenu(dinnerMenuIterator);
    }

    private void printMenu(Iterator<MenuItem> iterator) {
        while (iterator.hasNext()) {
            MenuItem menuItem = iterator.next();
            System.out.println(menuItem);
        }
    }

}
