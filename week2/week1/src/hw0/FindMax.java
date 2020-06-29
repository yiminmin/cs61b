package hw0;

import java.util.Arrays;

public class FindMax {
    public static int max(int[] m) {
        Arrays.sort(m);
        return m[m.length - 1];
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{9, 2, 15, 2, 22,10,6};
    }
}
