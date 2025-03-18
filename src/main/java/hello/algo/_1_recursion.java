package hello.algo;

import java.util.Stack;

public class _1_recursion {

    public static void main(String[] args) {
        System.out.println(forLoopRecur(0));
    }

    static int forLoopRecur(int n) {

        Stack<Integer> integerStack = new Stack<>();

        // push to stack
        for (int i = 0; i <= n; i++) {
            integerStack.push(i);
        }

        int sum = 0;
        // sum from stack
        while (!integerStack.isEmpty()) {
            sum += integerStack.pop();
        }
        return sum;
    }

    static int forLoopRecur2(int n) {
        // Use an explicit stack to simulate the system call stack
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        // Recursive: recursive call
        for (int i = n; i > 0; i--) {
            // Simulate "recursive" by "pushing onto the stack"
            stack.push(i);
        }
        // Return: return result
        while (!stack.isEmpty()) {
            // Simulate "return" by "popping from the stack"
            res += stack.pop();
        }
        // res = 1+2+3+...+n
        return res;
    }
}
