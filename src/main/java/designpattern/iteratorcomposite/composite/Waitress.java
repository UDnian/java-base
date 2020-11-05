package designpattern.iteratorcomposite.composite;

import designpattern.iteratorcomposite.composite.menu.MenuComponent;

/**
 * @author wangdongxing
 * @since 2019-01-14 11:50
 */
public class Waitress {

    private MenuComponent allMenus;

    public Waitress(MenuComponent allMenus) {
        this.allMenus = allMenus;
    }

    public void printMenu() {
        allMenus.print();
    }
}
