package leetcode;

public class _206_Reverse_Linked_List {
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();

        // start here
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        runSolution(node);

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("run time: " + totalTime);
    }

    static void runSolution(Node head) {
        Node curr = head;
        Node prev = null;
        while(curr != null) {
            // TODO: implement solution
        }
        
        System.out.println("debug");
    }

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

    }

}