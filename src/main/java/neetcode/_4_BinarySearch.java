package neetcode;

import java.util.Arrays;

public class _4_BinarySearch {

    public static void main(String[] args) {

        ex4();

    }

    static void ex1() {
        int[] arr = {-1, 0, 2, 4, 6, 8};
        int target = 2;
        System.out.println(search(arr, target));
    }

    static int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {

            int mid = (l + r) / 2;
            if (target <= nums[mid]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }

        return nums[l] == target ? l : -1;
    }

    static void ex2() {
        int target = 3;
        int[][] arr1 = {{1}, {3}};
        System.out.println(searchMatrix(arr1, target));
    }

    static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0;
        int right = m * n - 1;

        int rowNum = 0;
        int colNum = 0;
        while (left < right) {
            int mid = (left + right) / 2;
            rowNum = mid / n;
            colNum = mid % n;

            if (target <= matrix[rowNum][colNum]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        rowNum = left / n;
        colNum = left % n;
        return matrix[rowNum][colNum] == target;
    }

    static void ex3() {
        int target = 8;
        int[] arr1 = {3, 6, 7, 11};
        System.out.println(minEatingSpeed(arr1, target));
    }

    static int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = Arrays.stream(piles).max().getAsInt();

        while (left < right) {
            int mid = (left + right) / 2;
            if (count(mid, piles) <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    static int count(int k, int[] piles) {
        int sum = 0;
        for (int i = 0; i <= piles.length - 1; i++) {
            sum += (int) Math.ceil((double) piles[i] / k);
        }
        return sum;
    }

    static void ex4() {
        int[] arr = {3,4,5,6,1,2};
        System.out.println(findMin(arr));
    }

    static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while(left < right) {
            int mid = (left + right)/2;
            if(nums[mid] >= nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }
}
