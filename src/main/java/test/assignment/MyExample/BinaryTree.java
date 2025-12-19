package test.assignment.MyExample;

import java.util.Arrays;
import java.util.List;

import org.springframework.util.ObjectUtils;

public class BinaryTree {
    public static void main(String[] args) {
        ex19();
    }

    // ex1: manual create binary tree
    public static void ex1() {
        var binaryTreeBuilder = new BinaryTreeBuilder();
        var root = binaryTreeBuilder.build();

        // Verify
        System.err.println("Root: " + root.getValue());
        System.err.println("Left of root: " + root.getLeft().getValue());
        System.err.println("Right of root: " + root.getRight().getValue());
    }

    // ex2: isLeaf method
    public static void ex2() {
        BinaryTreeNode leaf = new BinaryTreeNode(5);
        leaf.setLeft(new BinaryTreeNode(3));
        System.out.println(leaf.isLeaf());
    }

    // ex3: hasOneChild method
    public static void ex3() {
        BinaryTreeNode leaf = new BinaryTreeNode(5);
        leaf.setLeft(new BinaryTreeNode(3));
        leaf.setRight(new BinaryTreeNode(3));
        System.out.println(leaf.hasOneChild());
    }

    // ex4: print in-order tree
    public static void ex4() {
        var binaryTreeBuilder = new BinaryTreeBuilder();
        var root = binaryTreeBuilder.build();

        printInOrder(root);
    }

    static void printInOrder(BinaryTreeNode node) {
        if (node == null)
            return;

        // handle left
        printInOrder(node.getLeft());
        System.out.println("current node: " + node.getValue());
        // handle right
        printInOrder(node.getRight());
    }

    // ex5: print pre-order tree
    public static void ex5() {
        var binaryTreeBuilder = new BinaryTreeBuilder();
        var root = binaryTreeBuilder.build();

        printPreOrder(root);
    }

    static void printPreOrder(BinaryTreeNode node) {
        if (node == null)
            return;

        System.out.println("current node: " + node.getValue());
        printPreOrder(node.getLeft());
        printPreOrder(node.getRight());
    }

    // ex6: print post-order tree
    public static void ex6() {
        var binaryTreeBuilder = new BinaryTreeBuilder();
        var root = binaryTreeBuilder.build();

        printPostOrder(root);
    }

    static void printPostOrder(BinaryTreeNode node) {
        if (node == null)
            return;

        printPostOrder(node.getLeft());
        printPostOrder(node.getRight());
        System.out.println("current node: " + node.getValue());
    }

    // ex7: count all nodes
    public static void ex7() {
        var binaryTreeBuilder = new BinaryTreeBuilder();
        var root = binaryTreeBuilder.build();
        System.err.println("total nodes: " + countNode(root));
    }

    static int countNode(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }
        return countNode(node.getLeft()) + countNode(node.getRight()) + 1;
    }

    // ex8: calculate height of tree
    public static void ex8() {
        var binaryTreeBuilder = new BinaryTreeBuilder();
        var root = binaryTreeBuilder.build();
        System.err.println("height of tree: " + heightOfTree(root));
    }

    static int heightOfTree(BinaryTreeNode node) {
        // define height as number of edges in longest path; leaf -> 0; empty -> -1
        if (node == null) {
            return -1;
        }

        int left = heightOfTree(node.getLeft());
        int right = heightOfTree(node.getRight());

        return Math.max(left, right) + 1;
    }

    // ex9: count leaf nodes
    public static void ex9() {
        var binaryTreeBuilder = new BinaryTreeBuilder();
        var root = binaryTreeBuilder.build();
        System.err.println("leaf nodes number: " + countLeafNodes(root));
    }

    static int countLeafNodes(BinaryTreeNode node) {

        if (node == null) {
            return 0;
        }

        if (node.getLeft() == null && node.getRight() == null) {
            return 1;
        }

        int left = countLeafNodes(node.getLeft());
        int right = countLeafNodes(node.getRight());
        return left + right;
    }

    // ex10: sum value of all nodes
    public static void ex10() {
        var binaryTreeBuilder = new BinaryTreeBuilder();
        var root = binaryTreeBuilder.build();
        System.err.println("sum of all nodes: " + sumAllNodes(root));
    }

    static int sumAllNodes(BinaryTreeNode node) {
        if (node == null) {
            return 0;
        }

        return sumAllNodes(node.getLeft()) + sumAllNodes(node.getRight()) + node.getValue();
    }

    // ex11: search operations
    public static void ex11() {
        var binaryTreeBuilder = new BinaryTreeBuilder();
        var root = binaryTreeBuilder.build();

        int target = 10;
        System.err.println("search for value " + target + ": " + searchOperators(root, target));
    }

    static String searchOperators(BinaryTreeNode node, int target) {
        // node == null
        if (node == null) {
            return "not found";
        }

        // node.value == value
        if (target == node.getValue()) {
            return "found";
        }

        // value < node -> search left
        if (target < node.getValue()) {
            return searchOperators(node.getLeft(), target);
        } else {
            // value > node -> search right
            return searchOperators(node.getRight(), target);
        }

    }

    // ex12: search operations with loop
    public static void ex12() {
        var binaryTreeBuilder = new BinaryTreeBuilder();
        var root = binaryTreeBuilder.build();

        int target = 8;
        System.err.println("search for value " + target + ": " + searchOperatorsWithLoop(root, target));
    }

    public static String searchOperatorsWithLoop(BinaryTreeNode node, int target) {
        while (node != null) {
            if (target == node.getValue()) {
                return "found";
            }

            if (target < node.getValue()) {
                node = node.getLeft();
            } else {
                node = node.getRight();
            }
        }
        return "not found";
    }

    // ex13: find min
    public static void ex13() {
        var binaryTreeBuilder = new BinaryTreeBuilder();
        var root = binaryTreeBuilder.build();

        System.err.println("Min node is: " + findMinNode(root));
    }

    static int findMinNode(BinaryTreeNode node) {
        if (node == null) {
            throw new IllegalArgumentException("Tree is empty");
        }

        BinaryTreeNode current = node;
        while (current.getLeft() != null) {
            current = current.getLeft();
        }
        return current.getValue();
    }

    // ex14: find max
    public static void ex14() {
        var binaryTreeBuilder = new BinaryTreeBuilder();
        var root = binaryTreeBuilder.build();

        System.err.println("Max node is: " + findMaxNode(root));
    }

    static int findMaxNode(BinaryTreeNode node) {
        if (node == null) {
            throw new IllegalArgumentException("Tree is empty");
        }

        BinaryTreeNode current = node;
        while (current.getRight() != null) {
            current = current.getRight();
        }
        return current.getValue();
    }

    // ex15: insert node
    public static void ex15() {
        var binaryTreeBuilder = new BinaryTreeBuilder();
        var root = binaryTreeBuilder.build();

        int newValue = 6;
        root = insertNode(root, newValue);
        printInOrder(root);
    }

    static BinaryTreeNode insertNode(BinaryTreeNode node, int value) {
        if (node == null) {
            return new BinaryTreeNode(value);
        }

        if (value == node.getValue()) {
            return node;
        }

        if (value < node.getValue()) {
            // insert left
            var leftNode = insertNode(node.getLeft(), value);
            node.setLeft(leftNode);
        } else {
            // insert right
            var rightNode = insertNode(node.getRight(), value);
            node.setRight(rightNode);
        }
        return node;
    }

    // ex16: insert node with loop
    public static void ex16() {
        var binaryTreeBuilder = new BinaryTreeBuilder();
        var root = binaryTreeBuilder.build();

        int newValue = 6;
        root = insertNodeWithLoop(root, newValue);
        printInOrder(root);
    }

    static BinaryTreeNode insertNodeWithLoop(BinaryTreeNode node, int value) {

        // handle root node is null
        if (node == null) {
            return new BinaryTreeNode(value);
        }

        // traverse to find parent node
        BinaryTreeNode parentNode = null;
        BinaryTreeNode current = node;
        while(current != null) {
            parentNode = current;

            if (value < current.getValue()) {
                // go left
                current = current.getLeft();
            } else if (value > current.getValue()) {
                // go right
                current = current.getRight();
            } else {
                // duplicate value - do nothing
                return node;
            }
        }

        // insert
        var newNode = new BinaryTreeNode(value);
        if (value < parentNode.getValue()) {
            parentNode.setLeft(newNode);
        } else {
            parentNode.setRight(newNode);
        }
        return node;
    }

    // ex17: build tree from list
    public static void ex17() {
        var list = Arrays.asList(1, 10, 2, 4, 3, 24, 6, 13, 6, 8, 9);

        var binaryTreeBuilder = new BinaryTreeBuilder();
        var root = binaryTreeBuilder.build(list);
        printInOrder(root);
    }

    // ex18: validate BST
    public static void ex18() {
        var binaryTreeBuilder = new BinaryTreeBuilder();
        var root = binaryTreeBuilder.build();

        System.out.println("this tree is BST?: " + isValidBTS(root, Integer.MIN_VALUE, Integer.MAX_VALUE));
    }

    static boolean isValidBTS(BinaryTreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }

        if(node.getValue() <= min || node.getValue() >= max) {
            return false;
        }

        return isValidBTS(node.getLeft(), min, node.getValue())
            && isValidBTS(node.getRight(), node.getValue(), max);
    }

    // ex19: find Kth smallest
    public static void ex19() {
        var binaryTreeBuilder = new BinaryTreeBuilder();
        var root = binaryTreeBuilder.build();
        int k = 4;
        FindKthSmallest.findKthSmallest(root, k);
        System.out.println(k + "th smallest is: " + FindKthSmallest.nodeValue);
    }

    static class FindKthSmallest {

        static int count = 0;
        static int nodeValue = 0;
        static void findKthSmallest(BinaryTreeNode node, int k) {
            if (node == null) {
                return;
            }

            findKthSmallest(node.getLeft(), k);
            count++;
            if (count == k) {
                nodeValue = node.getValue();
                return;
            }
            findKthSmallest(node.getRight(), k);
        }

    }

}

class BinaryTreeBuilder {

    public BinaryTreeNode build(List<Integer> list) {
        if (ObjectUtils.isEmpty(list)) {
            return null;
        }

        BinaryTreeNode root = null;
        for (Integer i : list) {
            root = BinaryTree.insertNode(root, i);
        }
        return root;
    }

    /**
     * Build Binary Search Tree:
     *         7
     *        /  \
     *       4     9
     *      / \   / \
     *     2  5  8  10
     *    /
     *   1
     */
    public BinaryTreeNode build() {
        // Root
        BinaryTreeNode node7 = new BinaryTreeNode(7);

        // Level 2
        BinaryTreeNode node4 = new BinaryTreeNode(4);
        BinaryTreeNode node9 = new BinaryTreeNode(9);
        node7.setLeft(node4);
        node7.setRight(node9);

        // Level 3
        BinaryTreeNode node2 = new BinaryTreeNode(2);
        BinaryTreeNode node5 = new BinaryTreeNode(5);
        node4.setLeft(node2);
        node4.setRight(node5);

        BinaryTreeNode node8 = new BinaryTreeNode(8);
        BinaryTreeNode node10 = new BinaryTreeNode(10);
        node9.setLeft(node8);
        node9.setRight(node10);

        // Level 4
        BinaryTreeNode node1 = new BinaryTreeNode(1);
        node2.setLeft(node1);

        return node7;
    }
}