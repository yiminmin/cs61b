import java.util.Deque;

public class ArrayDeque<T> {
    private T[] items;
    private int nextFirst;
    private int nextLast;
    private int size;

    /**
     * Create are empty ArrayDeque
     */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        nextFirst = 0;
        nextLast = 1;
        size = 0;
    }
    /***
     * Returns true if the deque is full,
     */
    private boolean isFull() {
        return size == items.length;
    }

    /**
     * whether we should downsize the deque
     *  For arrays of length 16 or more, your usage factor should always be at least 25%.
     */
    private boolean isSparse() {
        return items.length >= 16 && size < (items.length / 4);
    }

    /**  Returns the new index when adding
     * one to a circular array.
     *  @param index : the index one is being added to.
     * */
    private int plusOne(int index) {
        return (index + 1) % items.length;
    }

    /** Returns the new index when subtracting
     * one from a circular array.
     * @param index The index one is being subtracted from. */
    private int minusOne(int index) {
        return (index - 1 + items.length) % items.length;
    }


    /** Returns true if deque is empty, false otherwise*/
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    /** Returns the number of items in the deque. */
    public int size() {
        return size;
    }

    /** Gets the item at the given index, where 0 is the front, 1 is the next item,
     * and so forth. If no such item exists, returns null. Must not alter the deque!*/
    public T get(int index) {
        if (index >= size || index < 0) {
            return null;
        }
        int start = plusOne(nextFirst);
        int requiredIndex = (start + index) % items.length;
        return items[requiredIndex];
    }

    /** Resizes the underlying array to the target capacity. */
    private void resize(int capacity) {
        T[] newDeque = (T[]) new Object[capacity];
        int oldIndex = plusOne(nextFirst);
        for (int newIndex = 0; newIndex < size; newIndex++) {
            newDeque[newIndex] = items[oldIndex];
            oldIndex = plusOne(oldIndex);
        }
    }

    /** Resize */
    private void upSize() {
        resize(size * 2);
    }

    /** DownSize */
    private void downSize() {
        resize(items.length / 2);
    }

    /** Adds an item of type T to the front of the deque*/
    public void addFirst(T item) {
        if (isFull()) {
            upSize();
        }
        items[nextFirst] = item;
        nextFirst = minusOne(nextFirst);
        size += 1;
    }

    /** Adds an item of type T to the back of the deque. */
    public void addLast(T item) {
        if (isFull()) {
            upSize();
        }
        items[nextLast] = item;
        nextLast = plusOne(nextLast);
        size = size + 1;
    }
    /**
     * Removes and returns the item at the front of the deque.
     * If no such item exists, returns null.
     */
    public T removeFirst() {
        nextFirst = plusOne(nextFirst);
        T toRemove = items[nextFirst];
        items[nextFirst] = null;
        if (!isEmpty()) {
            size -= 1;
        }
        if (isSparse()) {
            downSize();
        }
       return toRemove;
    }

    /** Removes and returns the item at the back of the deque.
     * If no such item exists, returns null. */
    public T removeLast() {
        nextLast = minusOne(nextLast);
        T toRemove = items[nextLast];
        items[nextLast] = null;
        if (!isEmpty()) {
            size -= 1;
        }
        if (isSparse()) {
            downSize();
        }
        return toRemove;
    }

    /** Prints the items in the deque from first to last, separated by a space.
     * Once all the items have been printed, print out a new line. */
    public void printDeque() {
        for (int i = plusOne(nextFirst); i != nextLast; i = plusOne(i)) {
            System.out.print(items[i] + " ");
        }
        System.out.println();
    }
    /**
     * Create a deep copy of other.
     */

    public ArrayDeque(ArrayDeque other) {
        items = (T[]) new Object[other.size];
        nextFirst = other.nextFirst;
        nextLast = other.nextLast;
        size = other.size;
        System.arraycopy(other.items, 0, items, 0, other.size);
    }

}

























