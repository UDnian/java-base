package designpattern.iteratorcomposite.composite.menu;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author wangdongxing
 * @since 2019-01-14 11:37
 */
public class Menu extends MenuComponent {
    private List<MenuComponent> menuComponentList = new ArrayList<>();

    private String name;

    private String description;

    public Menu(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public void add(MenuComponent menuComponent) {
        menuComponentList.add(menuComponent);
    }

    @Override
    public MenuComponent getChild(int i) {
        return menuComponentList.get(i);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void print() {
        System.out.println("Menu{" + "'name='" + name + '\'' + ", description='" + description + '\'' + '}');
        Iterator<MenuComponent> iterator = menuComponentList.iterator();
        while (iterator.hasNext()) {
            MenuComponent menuItem = iterator.next();
            menuItem.print();
        }
    }
}
