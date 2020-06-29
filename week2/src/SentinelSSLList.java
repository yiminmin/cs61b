/**
 * An SLList is a list of integers, which hides the terrible truth
 * of the nakedness within.
 */
public class SentinelSSLList {

    private static class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n) {
            item = i;
            next = n;
        }
    }
    /** the first item (ift it exists) is at sentinel.next */
    private IntNode sentinel;
    private int size;

    /** Creates an empty SLList. */
    public SentinelSSLList() {
        sentinel = new IntNode(63, null);
        size = 0;
    }

    public SentinelSSLList(int x) {
        sentinel = new IntNode(63, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    /** Adds x to the front of the lists. */
    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
        size += 1;
    }

    /** Adds x to the last of the lists. Iteratively */
    public void addLast(int x) {
        size += 1;

        IntNode p = sentinel;

        /* Move p until it reaches the end of the list. */
        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
    }

    /** recursively */
    public void addLastRecursively(int x) {
        addLastReHelper(x, this.sentinel);
    }
    public void addLastReHelper(int x, IntNode p) {
        if (p.next == null) {
            p.next = new IntNode(x, null);
        } else {
            addLastReHelper(x, p.next);
        }
    }

//    /** size helper Returns the size of the list that starts at IntNode p. */
//    private int sizeHelper(IntNode p) {
//        if (p.next == null) {
//            return 1;
//        }
//
//        return 1 + sizeHelper(p.next);
//    }
//
//    public int size() {
//        return sizeHelper(first);
//    }
    /** returns the size of the list. */
    public int size() {
        return size;
    }

    /** Returns the first item in the list. */
    public int getFirst() {
        return sentinel.next.item;
    }

    /** Returns the last item in the list. */
    public int getLast() {
        if (sentinel.next.next == null) {
            return sentinel.next.item;
        }

        IntNode p = sentinel.next;

        while (p.next != null) {
            p = p.next;
        }
        return p.item;
    }

    public static void main(String[] args) {
        /* Creates a list of one integer, namely 10 */
        SentinelSSLList L = new SentinelSSLList(15);
        L.addFirst(10);
        L.addFirst(5);
        System.out.println(L.getFirst());
        L.addLast(20);
        L.addLastRecursively(25);
        System.out.println(L.getLast());
    }


}
