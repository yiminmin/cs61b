package hw0;

import java.util.Arrays;

public class WindowPosSum {
    public int[] windowPosSum(int[] arr, int n) {
        int[] res = new int[arr.length];
        Arrays.fill(res, 0);
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                for (int j = i; j <= i + n && j < arr.length; j++) {
                    res[i] += arr[j];
                }
            } else {
                res[i] = arr[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, -3, 4, 5, 4};
        WindowPosSum sol = new WindowPosSum();
        System.out.println(Arrays.toString(sol.windowPosSum(arr, 3)));
    }
}
