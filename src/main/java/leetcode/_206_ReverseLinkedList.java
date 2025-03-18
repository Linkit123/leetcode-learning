package leetcode;

public class _206_ReverseLinkedList {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        System.out.println("Original List:");
        printList(head);

        head = reverseRecursive(head);

        System.out.println("Reversed List:");
        printList(head);
    }

    static void reverseIterative(Node head) {
        // modify the "next" pointer of each node to point to its previous node instead of the next one
        Node curr = head;
        Node prev = null;
        Node next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
    }

    public static Node reverseRecursive(Node head) {
        // Base case: if the list is empty or has only one node
        if (head == null || head.next == null) {
            return head;
        }

        // Reverse the rest of the list
        Node newHead = reverseRecursive(head.next);

        // Reverse the pointer of the current node
        head.next.next = head;
        head.next = null;

        return newHead; // Return the new head of the reversed list
    }

    // Helper method to print the linked list
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
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