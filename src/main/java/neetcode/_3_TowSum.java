package neetcode;

import java.util.Arrays;

public class _3_TowSum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 2, 3, 3};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(arr, target)));
    }

    //Time complexity: O(N^2);
    //Space Complexity: O(1);
    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if ((nums[i] + nums[j]) == target) {
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
        }
        return arr;
    }
}
