public class IntList {
    public int first;
    public IntList rest;

    public IntList(int f, IntList r) {
        first = f;
        rest = r;
    }
    /** get(int i) that returns the ith item in the list */
    public int getIterative(int i) {
        IntList result = this;
        if (i >= this.size()) {
            return -1;
        }
        if (i == 0) {
            return first;
        }
        for (int k = i; k > 0; k--) {
            result = result.rest;
        }
        return result.first;
    }

    /** get (int i) recursion */
    public int get(int i) {
        if (i == 0) {
            return first;
        }
        return rest.get(i - 1);
    }

    /**
     * Return the size of the list using .. recursion!
     * @return
     */
    public int size() {
        //base case
        if (rest == null) {
            return 1;
        }
        return 1 + this.rest.size();
    }

    /**
     * Return the size of the list using no recursion !
     * @return
     */
    public int iterativeSize() {
        IntList p = this;
        int totalSize = 0;
        while (p != null) {
            totalSize += 1;
            p = p.rest;
        }
        return totalSize;

    }

    /** static methods take in an IntList L and return an IntList with its integer values all squared */
    /* square does this non-mutatively with recursion by creating new IntLists*/
    public static IntList square(IntList L) {
        if (L == null) {
            return L;
        } else {
            IntList rest = square(L.rest);
            IntList M = new IntList(L.first * L.first, rest);
            return M;
        }
    }

    /** suqareMutative use a recursive approach to change the instance variable of the input IntList L.*/
    public static IntList squareMutative(IntList L) {
        IntList B = L;
        while (B != null) {
            B.first *= B.first;
            B = B.rest;
        }
        return L;
    }


    public static void main(String[] args) {
        IntList L = new IntList(15, null);
        L = new IntList(10, L);
        L = new IntList(5, L);
//        L.first = 5;
//        L.rest = null;
//
//        L.rest = new IntList();
//        L.rest.first = 10;
//
//        L.rest.rest = new IntList();
//        L.rest.rest.first = 15;
        System.out.println(L.size());
        System.out.println(L.iterativeSize());
        square(L);
        System.out.println(square(L).rest.first);


    }
}
