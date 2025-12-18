package test.assignment.MyExample;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BinaryTreeNode {
    private int value;
    private BinaryTreeNode left;
    private BinaryTreeNode right;

    public BinaryTreeNode() {
    }

    public BinaryTreeNode(int value) {
        this.value = value;
    }

    public boolean isLeaf() {
        return this.left == null && this.right == null;
    }

    public boolean hasOneChild() {
        return (left == null && right != null) || (left != null && right == null);
    }
}

