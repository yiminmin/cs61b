import java.util.Arrays;

/**
 * Invariants:
 *  addLast: the next item we want to add, will go into position size
 *  getLast: The item we want to return is in position size - 1;
 *  size: the number of items in the list should be size.
 */

public class AList<Item> {
    Item[] items;
    int size;

    /** Creates an empty list. */
    public AList() {
        items = (Item[])new Object[100];
        size = 0;
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        Item[] a = (Item[])new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }

    /** Inserts x into the back of the list.
     * addLast: the next item we want to add will go to into position size
     * */
    public void addLast(Item x) {
        if (size == items.length) {
            resize(size * 2);
        }
        items[size] = x;
        size = size + 1;
    }

    /** Returns the item from the back of the list. */
    public Item getLast() {
        return items[size - 1];
    }

    /** Gets the ith item in the list (0 is the front). */
    public Item get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Delete item form back of the list and
     * returns deleted item
     */
    public Item removeLast() {
        Item x = getLast();
        //items[size - 1] = 0;
        // setting deleted item to zero is not necessary to preserve invariants, and thus not necessary for correctness
        size = size - 1;
        return x;
    }

}
