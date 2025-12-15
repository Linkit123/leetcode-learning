package Mwaytree;

import lombok.Getter;
import lombok.Setter;

public class MwayTree {
    public static void main(String[] args) {
        ex3();
    }

    public static void ex1() {
        // Step 1: Tạo root
        BinaryTreeNode node = new BinaryTreeNode(10);

        // Step 2: Thêm children của root
        BinaryTreeNode leftNode = new BinaryTreeNode(5);
        BinaryTreeNode rightNode = new BinaryTreeNode(15);
        node.setLeft(leftNode);
        node.setRight(rightNode);

        // Step 3: Thêm children của node 5
        BinaryTreeNode left1Node = new BinaryTreeNode(3);
        BinaryTreeNode right1Node = new BinaryTreeNode(7);
        leftNode.setLeft(left1Node);
        left1Node.setRight(right1Node);

        // Verify
        System.err.println("Root: " + node.getValue());
        System.err.println("Left of root: " + node.getLeft().getValue());
        System.err.println("Right of root: " + node.getRight().getValue());
    }

    public static void ex2() {
        BinaryTreeNode leaf = new BinaryTreeNode(5);
        leaf.setLeft(new BinaryTreeNode(3));
        System.out.println(leaf.isLeaf());
    }

    public static void ex3() {
        BinaryTreeNode leaf = new BinaryTreeNode(5);
        leaf.setLeft(new BinaryTreeNode(3));
        leaf.setRight(new BinaryTreeNode(3));
        System.out.println(leaf.hasOneChild());
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
