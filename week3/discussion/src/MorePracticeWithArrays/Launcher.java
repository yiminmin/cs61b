package MorePracticeWithArrays;

import java.util.Arrays;

public class Launcher {
    public static void main(String[] args) {
        AList arr = new AList();
        int[] arr1 = {5, 9, 14,15};
        System.out.println(Arrays.toString(arr.insert(arr1, 6, 2)));
        arr.reverse(arr1);
        System.out.println(Arrays.toString(arr1));
    }
}
