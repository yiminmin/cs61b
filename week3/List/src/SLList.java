public class SLList<LochNess> {
    private int size;
    private StuffNode sentinel;

    private class StuffNode {
        public LochNess item;
        public StuffNode next;
        public StuffNode(LochNess i, StuffNode n) {
            item = i;
            next = n;
        }
    }
    public SLList() {
        sentinel = new StuffNode(null, null);
        size = 0;
    }

    public SLList(LochNess x) {
        sentinel = new StuffNode(null, null);
        sentinel.next = new StuffNode(x, null);
        size = 1;
    }

    /** Adds x to the front of the lists. */
    public void addFirst(LochNess x) {
        sentinel.next = new StuffNode(x, sentinel.next);
        size += 1;
    }

    /** Adds x to the last of the lists. Iteratively */
    public void addLast(LochNess x) {
        size += 1;

        StuffNode p = sentinel;
        /* Move p until it reaches the end of the list. */
        while (p.next != null) {
            p = p.next;
        }

        p.next = new StuffNode(x, null);
    }

    /** recursively */
    public void addLastRecursively(LochNess x) {
        addLastReHelper(x, this.sentinel);
    }
    public void addLastReHelper(LochNess x, StuffNode p) {
        if (p.next == null) {
            p.next = new StuffNode(x, null);
        } else {
            addLastReHelper(x, p.next);
        }
    }


    /** size helper Returns the size of the list that starts at StuffNode p. */
    public int size() {
        return size;
    }
//    private int sizeHelper(StuffNode p) {
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

    /** Returns the first item in the list. */
    public LochNess getFirst() {
        return sentinel.next.item;
    }

    /** Returns the last item in the list. */
    public LochNess getLast() {
        if (sentinel.next.next == null) {
            return sentinel.next.item;
        }
        StuffNode p = sentinel.next;
        while (p.next != null) {
            p = p.next;
        }
        return p.item;
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
