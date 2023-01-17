package cs.matemaster.api;

import java.util.Arrays;

/**
 * @author matemaster
 */
public class ArraysCase {


    public static void main(String[] args) {
        binarySearch();
    }

    static void binarySearch() {
        int[] arr = {1, 0, 2, 3, 4, 5, 8, 6, 9, 7, 10};
        Arrays.sort(arr);
        int index = Arrays.binarySearch(arr, 9);
        System.out.println(index);
    }
}
