package TestInit;

public class Sort {
    /** Sorts strings destructively. */
    public static void sort(String[] x) {
        sortHelper(x, 0);
    }
    private static void sortHelper(String[] x, int start) {
        // base case
        if (start == x.length) {
            return;
        }
        // Find the smallest item
        int smallestIndex = findSmallest(x, start);

        // Move it to the front
        swap(x, start, smallestIndex);

        // Selection sort the rest (using recusion ??)
        sortHelper(x, start + 1);
    }
    /** Swap item a with b.*/
    public static void swap(String[] x, int a, int b) {
        String temp = x[a];
        x[a] = x[b];
        x[b] = temp;
    }

    /** Return the index of smallest String in x, starting at start. */
    public static int findSmallest(String[] x, int start) {
        int smallestIndex = start;
        for (int i = start; i < x.length; i+= 1) {
            int cmp = x[i].compareTo(x[smallestIndex]);
            // from the internet, if x[i] < x[smallestIndex], cmp will be -1;
            if (cmp < 0) {
                smallestIndex = i;
            }
        }
        return smallestIndex;
    }
}
