package designpattern.iteratorcomposite.iterator.iterator;

import designpattern.iteratorcomposite.iterator.MenuItem;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 午餐迭代器
 *
 * @author wangdongxing
 * @since 2019-01-11 17:46
 */
public class DinnerIterator implements Iterator {

    private MenuItem[] menuItems;

    private int position = 0;

    public DinnerIterator(MenuItem[] menuItems) {
        this.menuItems = menuItems;
    }

    /**
     * Returns {@code true} if the iteration has more elements.
     * (In other words, returns {@code true} if {@link #next} would
     * return an element rather than throwing an exception.)
     *
     * @return {@code true} if the iteration has more elements
     */
    @Override
    public boolean hasNext() {
        int length = menuItems.length;
        if (position >= length || menuItems[position] == null) {
            return false;
        } else {
            return true;
        }
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Object next() throws NoSuchElementException {
        MenuItem menuItem = menuItems[position];
        position++;
        return menuItem;
    }
}
