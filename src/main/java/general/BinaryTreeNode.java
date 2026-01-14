package general;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BinaryTreeNode {
    int value;
    BinaryTreeNode left;
    BinaryTreeNode right;

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
