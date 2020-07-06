package TestInit;

import java.util.Arrays;

public class TestSort {
    /** Test the Sort.sort method. */
    @org.junit.Test
    public void testSort() {
        String[] input = {"i", "have", "an", "egg" };
        String[] expected = {"an", "egg", "have", "i"};
        Sort.sort(input);
//        org.junit.Assert.assertEquals(expected, input); assertEquals is deprecated
        org.junit.Assert.assertArrayEquals(expected, input);

//        //more specific version
//        for (int i = 0; i < input .length; i+=1) {
//            if (!input[i].equals(expected[i])) {
//                System.out.println("Mismatch in position " + i + ", expected: " + expected[i] + ", but got: " + input[i]);
//                return;
//            }
//        }

//        if (!Arrays.equals(input, expected)) { //basic version
//            System.out.println("Error! There seems to be a problem with Sort.sort.");
//        }
    }

    /** Test the Sort.swap method. */
    @org.junit.Test
    public void testSwap() {
        String[] input = {"i", "have", "an", "egg"};
        int a = 0;
        int b = 2;
        String[] expected = {"an", "have", "i", "egg"};

        Sort.swap(input, a, b);
        org.junit.Assert.assertArrayEquals(expected, input);

    }

    /** Test the Sort.findSmallest method. */
    @org.junit.Test
    public void testFindSmallest() {
        String[] input = {"i", "have", "an", "egg" };
        String[] input2 = {"there", "are", "many", "pigs"};

        int expected = 2;
        int expected2 = 2;

        int actual = Sort.findSmallest(input, 0);
        int actual2 = Sort.findSmallest(input2, 2);

        org.junit.Assert.assertEquals(expected, actual);
        org.junit.Assert.assertEquals(expected2, actual2);

    }

}
