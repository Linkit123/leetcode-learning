package test.assignment.MyExample;

import java.util.Arrays;
import java.util.Collections;

import lombok.Getter;
import lombok.Setter;

public class BinaryTree {
    public static void main(String[] args) {
        ex9();
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

    // print pre-order tree
    public static void ex5() {
        var binaryTreeBuilder = new BinaryTreeBuilder();
        var root = binaryTreeBuilder.build();

        printPreOrder(root);
    }

    static void printPreOrder(BinaryTreeNode node) {
        System.out.println("current node: " + node.getValue());
        if (node.getLeft() == null)
            return;

        printPreOrder(node.getLeft());
        printPreOrder(node.getRight());
    }

    // print post-order tree
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

    // count all nodes
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

    // calculate height of tree
    public static void ex8() {
        var binaryTreeBuilder = new BinaryTreeBuilder();
        var root = binaryTreeBuilder.build();
        System.err.println("height of tree: " + heightOfTree(root));
    }

    static int heightOfTree(BinaryTreeNode node) {
        if (node.getLeft() == null) {
            return 0;
        }

        int left = heightOfTree(node.getLeft());
        int right = heightOfTree(node.getLeft());

        // find max
        int max = Collections.max(Arrays.asList(left, right));
        return max + 1;
    }

    // count leaf nodes
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
}

@Getter
@Setter
class BinaryTreeNode {
    private int value;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    public boolean hasOneChild() {
        return (left == null && right != null) || (left != null && right == null);
    }
}

class BinaryTreeBuilder {
    public BinaryTreeNode build() {
        // Step 1: Tạo root
        BinaryTreeNode node = new BinaryTreeNode(10);

        // Step 2: Thêm children của root
        BinaryTreeNode leftNode = new BinaryTreeNode(8);
        BinaryTreeNode rightNode = new BinaryTreeNode(9);
        node.setLeft(leftNode);
        node.setRight(rightNode);

        // Step 3: Thêm children của node 5
        BinaryTreeNode left1Node = new BinaryTreeNode(3);
        BinaryTreeNode right1Node = new BinaryTreeNode(7);
        leftNode.setLeft(left1Node);
        leftNode.setRight(right1Node);

        BinaryTreeNode left2Node = new BinaryTreeNode(2);
        // BinaryTreeNode right2Node = new BinaryTreeNode(1);
        left1Node.setLeft(left2Node);
        // left1Node.setRight(right2Node);
        return node;
    }
}