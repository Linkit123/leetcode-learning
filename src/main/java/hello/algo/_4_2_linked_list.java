package hello.algo;

import java.util.List;

public class _4_2_linked_list {

    public static void main(String[] args) {
        find();
    }

    static void insert() {
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        n0.next = n1;
        n1.next = n2;

        ListNode n3 = new ListNode(5);
        insert(n0, n3);
    }

    static void delete() {
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        n0.next = n1;
        n1.next = n2;

        delete(n0);
    }

    static void find() {
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        n0.next = n1;
        n1.next = n2;

        int tartget = 2;
        var targetIndex = find(n0, tartget);
        if (targetIndex == -1) {
            System.out.println("not found target: " + tartget);
        } else {
            System.out.println("found target: " + tartget + " at index: " + targetIndex);
        }
    }

    /* Insert node P after node n0 in the linked list */
    static void insert(ListNode n0, ListNode P) {
        ListNode next = n0.next;
        P.next = next;
        n0.next = P;
    }

    /* Remove the first node after node n0 in the linked list */
    static void delete(ListNode n0) {
        if (n0.next == null) {
            return;
        }

        ListNode P = n0.next;
        n0.next = P.next;
    }
    
    /* Access the node at `index` in the linked list */
    static ListNode access(ListNode head, int index) {
        if (head.next == null) {
            return null;
        }
        for(int i = 0; i < index; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        return head;
    }

    /* Search for the first node with value target in the linked list */

    static int find(ListNode head, int target) {
        int index = 0;
        while(head != null) {
            if (head.val == target) {
                return index;
            }
            index ++;
            head = head.next;
        }
        return -1;
    }

    static ListNode init() {
        /* Initialize linked list: 1 -> 3 -> 2 -> 5 -> 4 */
        // Initialize each node
        ListNode n0 = new ListNode(1);
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(5);
        ListNode n4 = new ListNode(4);
        // Build references between nodes
        n0.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        return n0;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
