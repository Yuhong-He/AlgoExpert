public class EvaluateExpressionTree {
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
        BinaryTree node1 = new BinaryTree(-1);
        BinaryTree node2 = new BinaryTree(-2);
        BinaryTree node3 = new BinaryTree(-3);
        BinaryTree node4 = new BinaryTree(-4);
        BinaryTree node5 = new BinaryTree(2);
        BinaryTree node6 = new BinaryTree(8);
        BinaryTree node7 = new BinaryTree(3);
        BinaryTree node8 = new BinaryTree(2);
        BinaryTree node9 = new BinaryTree(3);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node4.right = node9;

        int expected = 6;
        int actual = evaluateExpressionTree(node1);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static int evaluateExpressionTree(BinaryTree tree) {
        if(tree.value >= 0) {
            return tree.value;
        }
        int left = evaluateExpressionTree(tree.left);
        int right = evaluateExpressionTree(tree.right);
        switch (tree.value) {
            case -1: return left + right;
            case -2: return left - right;
            case -3: return left / right;
            default: return left * right;
        }
    }

}
