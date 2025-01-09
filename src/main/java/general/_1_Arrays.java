package general;

public class _1_Arrays {

    public static void main(String[] args) {
        System.out.println("");
        int[] arr = {1,2,3,4,5,6,7};
        int argument = 3;
        countAppearElement(argument, arr);
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

}
