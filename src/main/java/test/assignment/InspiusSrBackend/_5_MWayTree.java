package test.assignment.InspiusSrBackend;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * M-Way Tree implementation in Java
 * 
 * A multiway search tree where nodes can hold multiple keys and
 * have multiple children. Keys stay sorted in each node.
 * 
 * @author dev
 */
public class _5_MWayTree {

    private TreeNode root;
    private int maxChildren; // m value
    private int maxKeys; // m - 1

    /**
     * Constructor - initializes tree with max children limit
     * 
     * @param m maximum number of children per node (must be >= 3)
     */
    public _5_MWayTree(int m) {
        if (m < 3) {
            throw new IllegalArgumentException("m must be at least 3, got: " + m);
        }
        this.maxChildren = m;
        this.maxKeys = m - 1;
        this.root = null;
    }

    /**
     * Inserts a new key into the tree
     * 
     * Steps:
     * 1. Empty tree -> create root
     * 2. Find insertion spot
     * 3. Add key keeping sorted order
     * 4. Split if node exceeds max keys
     * 
     * @param key the value to insert
     */
    public void insert(int key) {
        // Handle empty tree
        if (root == null) {
            root = new TreeNode();
            root.keys.add(key);
            System.out.println("Inserted " + key + " as root");
            return;
        }

        // Find where to put the key
        TreeNode targetNode = findInsertPosition(root, key);

        // Add and sort
        targetNode.keys.add(key);
        Collections.sort(targetNode.keys);

        System.out.println("Inserted " + key + " into node with keys: " + targetNode.keys);

        // Check if split needed
        if (targetNode.keys.size() > maxKeys) {
            splitNode(targetNode);
        }
    }

    /**
     * Finds the node where new key should be inserted
     * Traverses down the tree recursively
     * 
     * @param node current node
     * @param key  key to insert
     * @return leaf node for insertion
     */
    private TreeNode findInsertPosition(TreeNode node, int key) {
        // Found a leaf
        if (node.children.isEmpty()) {
            return node;
        }

        // Determine which child to follow
        int childIdx = 0;
        while (childIdx < node.keys.size() && key > node.keys.get(childIdx)) {
            childIdx++;
        }

        // No such child exists, treat current node as leaf
        if (childIdx >= node.children.size()) {
            return node;
        }

        // Go deeper
        return findInsertPosition(node.children.get(childIdx), key);
    }

    /**
     * Splits an overfull node
     * 
     * When node has too many keys:
     * - Take middle key
     * - Promote to parent (or create new root)
     * - Split remaining keys into left/right nodes
     * 
     * @param node the node to split
     */
    private void splitNode(TreeNode node) {
        int midIdx = node.keys.size() / 2;
        int promoteKey = node.keys.get(midIdx);

        System.out.println("Splitting node, promoting key: " + promoteKey);

        // Create new nodes
        TreeNode leftNode = new TreeNode();
        TreeNode rightNode = new TreeNode();

        // Distribute keys
        leftNode.keys = new ArrayList<>(node.keys.subList(0, midIdx));
        rightNode.keys = new ArrayList<>(node.keys.subList(midIdx + 1, node.keys.size()));

        // Handle children if present
        if (!node.children.isEmpty()) {
            leftNode.children = new ArrayList<>(node.children.subList(0, midIdx + 1));
            rightNode.children = new ArrayList<>(node.children.subList(midIdx + 1, node.children.size()));

            // Update parent refs
            for (TreeNode child : leftNode.children) {
                child.parent = leftNode;
            }
            for (TreeNode child : rightNode.children) {
                child.parent = rightNode;
            }
        }

        // Was this the root?
        if (node == root) {
            TreeNode newRoot = new TreeNode();
            newRoot.keys.add(promoteKey);
            newRoot.children.add(leftNode);
            newRoot.children.add(rightNode);

            leftNode.parent = newRoot;
            rightNode.parent = newRoot;

            root = newRoot;
            System.out.println("Created new root with key: " + promoteKey);
        } else {
            // Promote to existing parent
            TreeNode parent = node.parent;
            parent.keys.add(promoteKey);
            Collections.sort(parent.keys);

            // Replace old node with split nodes
            int nodeIdx = parent.children.indexOf(node);
            parent.children.remove(nodeIdx);
            parent.children.add(nodeIdx, rightNode);
            parent.children.add(nodeIdx, leftNode);

            leftNode.parent = parent;
            rightNode.parent = parent;

            // Parent might overflow now
            if (parent.keys.size() > maxKeys) {
                splitNode(parent);
            }
        }
    }

    /**
     * Displays tree structure for debugging
     */
    public void display() {
        System.out.println("\n=== M-Way Tree Structure (m=" + maxChildren + ") ===");
        if (root == null) {
            System.out.println("Tree is empty");
        } else {
            displayNode(root, 0);
        }
        System.out.println("================================\n");
    }

    /**
     * Helper to recursively print nodes
     */
    private void displayNode(TreeNode node, int depth) {
        String indent = "  ".repeat(depth);
        System.out.println(indent + "Node: " + node.keys);

        for (int i = 0; i < node.children.size(); i++) {
            System.out.println(indent + "  Child " + i + ":");
            displayNode(node.children.get(i), depth + 1);
        }
    }

    /**
     * Inner class representing a tree node
     */
    class TreeNode {
        List<Integer> keys;
        List<TreeNode> children;
        TreeNode parent;

        TreeNode() {
            this.keys = new ArrayList<>();
            this.children = new ArrayList<>();
            this.parent = null;
        }

        @Override
        public String toString() {
            return "TreeNode(keys=" + keys + ")";
        }
    }

    /**
     * Test the implementation
     */
    public static void main(String[] args) {
        _5_MWayTree tree = new _5_MWayTree(3);
        System.out.println("Creating M-Way Tree with m=3 (max 2 keys, 3 children per node)\n");

        // Insert sample data
        int[] keys = { 10, 20, 5, 6, 7, 8, 30, 15, 40 };

        for (int key : keys) {
            System.out.println("\n--- Inserting " + key + " ---");
            tree.insert(key);
            tree.display();
        }

        System.out.println("\nFinal tree state:");
        tree.display();
    }
}