package MorePracticeWithArrays;

import java.util.Arrays;

public class AList<Item> {

    /**
     * Consider a method that inserts an int item into an int[] arr at the given position.
     * The method should return the resulting array. For example, if x = [5, 9, 14, 15],
     * item = 6, and position = 2, then the method should return [5, 9, 6, 14, 15].
     * If position is past the end of the array, insert item at the end of the array.
     * Is it possible to write a version of this method that returns void and changes arr in
     * place (i.e., destructively)? Hint: These arrays are filled meaning an array containing
     * n elements will have length
     */
    public static int[] insert(int[] arr, int item, int position) {
        int[] res = new int[arr.length + 1];
        System.arraycopy(arr, 0, res, 0, position);
        res[position] = item;
        System.arraycopy(arr,position, res, position + 1, arr.length - position);
        return res;
    }

    /**
     * Consider a method that destructively reverses the items in arr. For example calling
     * reverse on an array [1, 2, 3] should change the array to be [3, 2, 1]. Write
     * the reverse method:
     */
    public static void reverse(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
    }

    /**non-destructive method */
    public static void reverseNonDestructive(int[] arr) {
        int size = arr.length;
        int[] res = new int[size];
        for (int i = 0; i < size; i++) {
            res[i] = arr[i];
        }
        for (int i = arr.length - 1, j = 0; i >= 0 && j < size; i--, j++) {
            arr[i] = res[j];
        }
    }

    /**
     * Extra: Write a non-destructive method replicate(int[] arr) that replaces the
     * number at index i with arr[i] copies of itself. For example, replicate([3, 2,
     * 1]) would return [3, 3, 3, 2, 2, 1]. For this question assume that all elements
     * of the array are positive.
     */
    public static int[] replicate(int[] arr) {
        int size = 0;
        for (int item : arr) {
            size = size + item;
        }
        int[] result = new int[size];

        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                result[index] = arr[i];
                index++;
            }
        }

        return result;
    }

}















