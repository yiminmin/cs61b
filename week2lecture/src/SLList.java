/**
 * An SLList is a list of integers, which hides the terrible truth
 * of the nakedness within.
 */
public class SLList {
    private IntNode first;

    private static class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }

    public SLList(int x) {
        first = new IntNode(x, null);
    }

    /** Adds x to the front of the lists. */
    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    /** Adds x to the last of the lists. Iteratively */
    public void addLast(int x) {
        IntNode p = first;
        /* Move p until it reaches the end of the list. */
        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
    }

    /** recursively */
    public void addLastRecursively(int x) {
        addLastReHelper(x, this.first);
    }
    public void addLastReHelper(int x, IntNode p) {
        if (p.next == null) {
            p.next = new IntNode(x, null);
        } else {
            addLastReHelper(x, p.next);
        }
    }


    /** size helper Returns the size of the list that starts at IntNode p. */
    private int sizeHelper(IntNode p) {
        if (p.next == null) {
            return 1;
        }

        return 1 + sizeHelper(p.next);
    }

    public int size() {
        return sizeHelper(first);
    }

    /** Returns the first item in the list. */
    public int getFirst() {
        return first.item;
    }

    /** Returns the last item in the list. */
    public int getLast() {
        if (first.next == null) {
            return first.item;
        }
        while (first.next != null) {
            first = first.next;
        }
        return first.item;
    }


    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        SLList L = new SLList(15);
        L.addFirst(10);
        L.addFirst(5);
        System.out.println(L.getFirst());
        L.addLast(20);
        L.addLastRecursively(25);
        System.out.println(L.getLast());
    }


}
