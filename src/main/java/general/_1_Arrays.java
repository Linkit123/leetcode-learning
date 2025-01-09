package general;

public class _1_Arrays {

    public static void main(String[] args) {
        System.out.println("");
        int[] arr = {1,2,3,4,5,6,7};
        int argument = 3;
        rotateArrayWithStep(argument, arr);
    }

    //Find the Sum of Array Elements
    private static void sumArray(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        System.out.println(sum);
    }

    //Count Occurrences of an Element
    private static void countAppearElement(int element, int[] arr) {
        int count = 0;
        for (int j : arr) {
            if (j == element) {
                count++;
            }
        }
        System.out.println(count);
    }

    //Rotate an Array
    private static void rotateArrayWithStep(int k, int[] arr) {

        int n = arr.length;

        //handle case k >= array length
        k = k % n;
        
        int[] temp = new int[n];

        // rotate all numbers the remainder times.
        for (int i = 0; i < n; i++) {
            temp[(i + k) % n] = arr[i];
        }
        printArray(temp);

    }

    private static void reverseArray(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            
        }
    }

    private static void printArray(int[] arr) {
        System.out.println("array: ");
        for (int j : arr) {
            System.out.println(j);
        }
    }
}
