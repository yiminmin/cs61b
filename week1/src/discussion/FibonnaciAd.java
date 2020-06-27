package discussion;

public class FibonnaciAd {
    /**
     *
     * @param n is the fibonacci's index
     * @param k is the recording index
     * @param f0 fibonacci numbers which are always next to each other
     * @param f1 fibonacci numbers which are always next to each other
     * @return once k reaches index n, the iteration stops
     */
    public static int fib2(int n, int k, int f0, int f1) {
        if (n == k) {
            return f0;
        }
        return fib2(n, k + 1, f1, f1 + f0);
    }

    public static void main(String[] args) {
        System.out.println(fib2(6, 0, 0, 1));
    }
}
