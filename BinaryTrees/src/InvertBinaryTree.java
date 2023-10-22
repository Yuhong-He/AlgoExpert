public class InvertBinaryTree {
    static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        public BinaryTree(int value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public static void main(String[] args) {
        BinaryTree node1 = new BinaryTree(1);
        BinaryTree node2 = new BinaryTree(2);
        BinaryTree node3 = new BinaryTree(3);
        BinaryTree node4 = new BinaryTree(4);
        BinaryTree node5 = new BinaryTree(5);
        BinaryTree node6 = new BinaryTree(6);
        BinaryTree node7 = new BinaryTree(7);
        BinaryTree node8 = new BinaryTree(8);
        BinaryTree node9 = new BinaryTree(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node8;
        node4.right = node9;
        node3.left = node6;
        node3.right = node7;
        invertBinaryTree(node1);
    }

    public static void invertBinaryTree(BinaryTree tree) {
        if(tree != null) {
            BinaryTree left = tree.left;
            tree.left = tree.right;
            tree.right = left;
            invertBinaryTree(tree.right);
            invertBinaryTree(tree.left);
        }
    }
}
