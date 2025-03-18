package hello.algo;

import java.util.Stack;

public class _4_1_array {

    public static void main(String[] args) {
        int[] num = new int[] {1,2,5,4,0};
        insert(3, 2, num);
    }

    static void insert(int element, int index, int[] num) {
        for(int i = num.length - 1; i >= index ; i--) {
            num[i] = num[i - 1];
        }
        num[index] = element;
        System.out.println(num);
    }
}
