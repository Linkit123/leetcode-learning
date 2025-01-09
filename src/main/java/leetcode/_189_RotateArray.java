package leetcode;

import utils.Utils;

public class _189_RotateArray {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        
        // start here
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        int k = 2;
        runSolution(k, array);

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("run time: " + totalTime);
    }

    //rotate array with remainder solution
    static void runSolution1(int k, int[] arr) {

        int n = arr.length;

        //handle case k >= array length
        k = k % n;
        
        int[] temp = new int[n];

        // rotate all numbers the remainder times.
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = arr[i];
        }
        Utils.printArray(temp);

    }

    //rotate array with reverse solution
    static void runSolution(int k, int[] nums) {
        int size = nums.length;
        k = k % size;

        //1. reverse entire "array"
        reverseArray(nums, 0, size - 1);
        Utils.printArray(nums);
        System.out.println("-----------------");

        //2. reverse before "k"
        reverseArray(nums, 0, k - 1);
        Utils.printArray(nums);
        System.out.println("-----------------");

        //3. reverse after "k"
        reverseArray(nums, k, size - 1);
        Utils.printArray(nums);
        System.out.println("-----------------");

    }

    private static void reverseArray(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            
            start++;
            end--;   
        }
    }
}
