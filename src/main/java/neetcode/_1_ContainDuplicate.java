package neetcode;

import java.util.HashMap;

public class _1_ContainDuplicate {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        // start here
        int[] array = {1, 2, 3, 4, 5};
        System.out.println(runSolution(array));
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println("run time: " + totalTime);
    }

    public static boolean runSolution_1(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    // faster
    public static boolean runSolution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                return true;
            }
            map.put(nums[i], 1);
        }
        return false;
    }

}
