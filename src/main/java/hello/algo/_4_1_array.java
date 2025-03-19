package hello.algo;

import utils.Utils;

public class _4_1_array {

    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, 2, 5, 4};
        extend(nums, 3);
    }

    //nums = {1, 2, 5, 4, 0}, add element 3 at index 2
    static void insert(int[] nums, int element, int index) {
        for(int i = nums.length - 1; i > index ; i--) {
            nums[i] = nums[i - 1];
        }
        nums[index] = element;
        Utils.printArray(nums);
    }

    //nums = {1, 3, 2, 5, 4}, remove element with index 2
    static void delete(int[] nums, int index) {
        for(int i = index; i < nums.length - 1; i++) {
            nums[i] = nums[i + 1];
        }
        Utils.printArray(nums);
    }

    /* Extend array length */
    //nums = {1, 3, 2, 5, 4}, extend 3 more space
    static void extend(int[] nums, int enlarge) {
        int[] res = new int[nums.length + enlarge];

        // copy element
        for(int i = 0; i < nums.length; i++) {
            res[i] = nums[i];
        }

        Utils.printArray(res);
    }
}
