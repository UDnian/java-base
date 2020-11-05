package designpattern.iteratorcomposite.iterator.iterator;

import designpattern.iteratorcomposite.iterator.MenuItem;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * 早餐迭代器
 *
 * @author wangdongxing
 * @since 2019-01-11 17:54
 */
public class BreakfastIterator implements Iterator {
    private List<MenuItem> menuItemList;

    private Iterator<MenuItem> iterator;

    public BreakfastIterator(List<MenuItem> menuItemList) {
        this.menuItemList = menuItemList;
        this.iterator = menuItemList.iterator();
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
        return iterator.hasNext();
    }

    /**
     * Returns the next element in the iteration.
     *
     * @return the next element in the iteration
     * @throws NoSuchElementException if the iteration has no more elements
     */
    @Override
    public Object next() throws NoSuchElementException {
        return iterator.next();
    }
}
