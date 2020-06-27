package hw0;

public class FindMaxII {
    //use lop
    public static int forMax(int[] m) {
        if (m == null || m.length == 0) {
            return 0;
        }
        int max = m[0];
        for (int i = 1; i < m.length; i++) {
            max = max > m[i] ? max : m[i];
        }
        return max;

    }

    public static void main(String[] args) {
        int[] numbers = {9, 2, 15, 2, 22, 10, 6};
        forMax(numbers);
        System.out.println(forMax(numbers));
    }
}
