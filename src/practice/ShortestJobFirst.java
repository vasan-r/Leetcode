package practice;

import java.util.Arrays;

public class ShortestJobFirst {
    public static void main(String[] args) {
        int[] arr = {4,3,7,1,2};
        shortest(arr);
    }

    private static void shortest(int[] arr) {
        Arrays.sort(arr);
        int wt = 0;
        int tt = 0;
        for (int i = 0; i < arr.length-1; i++) {
            wt += arr[i];
            tt += wt;
        }
        System.out.println(tt/5);
    }
}
