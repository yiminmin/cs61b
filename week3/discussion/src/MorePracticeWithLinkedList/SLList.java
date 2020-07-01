package MorePracticeWithLinkedList;

public class SLList {
    private  class IntNode {
        public int item;
        public IntNode next;
        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }

    private IntNode first;

    public SLList(int x) {
        first = new IntNode(x, null);
    }


    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    /** returns the size of SLList */
    public int size() {
        return sizeHelper(this.first);
    }

    /** sizeHelper*/
    private int sizeHelper(IntNode p) {
        if (p.next == null) {
            return 1;
        }
        return 1 + sizeHelper(p.next);
    }

    /** Adds x to the last of the lists. */
    public void addLast(int x) {
        IntNode p = first;
        /** Move p until reaches the end of the list . */
        while (p.next != null) {
            p = p.next;
        }

        p.next = new IntNode(x, null);
    }

    /** returns the Lth in the list*/
    public IntNode findLth (int position) {
        IntNode dummy = new IntNode(0, null);
        dummy.next = this.first;
        IntNode p = dummy;
        int l = position;

        while (l > 0 && p.next != null) {
            p = p.next;
            l--;
        }
        return p.next;
    }

    /**
     * Implement SLList.insert which takes in an integer x and an integer position.
     * It inserts x at the given position. If position is after the end of the list,
     * insert the new node at the end.
     */
    public void insert(int item, int position) {
        //find whether position is after the end of the list
        int size = size();

        if (position == 0) {
            addFirst(item);
        } else if (position < size) {
            IntNode post = findLth(position - 1);
            IntNode next = findLth(position);
            IntNode cur = new IntNode(item, null);
            post.next = cur;
            cur.next = next;
        } else {
            addLast(item);
        }

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

    /**
     *  Add another method to the SLList class that reverses the elements. Do this using
     * the existing IntNode objects (you should not use new).
     */
    public void reverse() {
        IntNode pre = null;
        IntNode cur = first;
        while (cur != null) {
            IntNode node = cur.next;
            cur.next = pre;
            pre = cur;
            cur = node;
        }
        first = pre;

    }

    /* reverse recursively */
    public void reverseRecursively() {
        first = reverseRecursivelyHelper(first);
    }
    public IntNode reverseRecursivelyHelper(IntNode x) {
        IntNode cur = x;
        // base case
        if (cur == null || cur.next == null) {
            return cur;
        }
        //subproblem
        IntNode newHead = reverseRecursivelyHelper(cur.next);
        // recursive rule
        cur.next.next = cur;
        cur.next = null;
        return newHead;
    }

    /** Returns the Lth item in the list. */
    public int getLth(int position) {
        int size = size();
        if (position > size) {
            position = size;
        }
        IntNode dummy = new IntNode(0, null);
        dummy.next = first;
        IntNode cur = dummy;
        while (position > 0 && cur.next != null) {
            cur = cur.next;
            position--;
        }
        return cur.item;

    }


    public static void main(String[] args) {
        SLList L = new SLList(15);
        L.insert(10, 0);
        L.insert(20, 1);
        L.addLast(35);
        L.insert(25,3);
//        System.out.println(L.getLast());
//        System.out.println(L.getFirst());
        int size = L.size();
        System.out.println(size);

        L.reverseRecursively();
        for (int i = 1; i <= size; i++) {
            System.out.println(i + " + " + L.getLth(i));
        }

    }
}

























