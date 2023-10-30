public class FindClosestValueInBST {
    public static class BST {
        public int value;
        public BST left;
        public BST right;

        public BST(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        BST bst1 = new BST(10);
        BST bst2 = new BST(5);
        BST bst3 = new BST(15);
        BST bst4 = new BST(2);
        BST bst5 = new BST(5);
        BST bst6 = new BST(13);
        BST bst7 = new BST(22);
        BST bst8 = new BST(1);
        BST bst9 = new BST(14);
        bst1.left = bst2;
        bst1.right = bst3;
        bst2.left = bst4;
        bst2.right = bst5;
        bst4.left = bst8;
        bst3.left = bst6;
        bst3.right = bst7;
        bst6.left = bst9;

        int expected = 13;
        int actual = findClosestValueInBst(bst1, 12);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static int findClosestValueInBst(BST tree, int target) {
        return helper(tree, target, tree.value);
    }

    public static int helper(BST node, int target, int closest) {
        int preDiff = Math.abs(target - closest);
        int currentDiff = Math.abs(target - node.value);
        if(currentDiff < preDiff) {
            closest = node.value;
        }
        if(target < node.value && node.left != null) {
            return helper(node.left, target, closest);
        } else if(target > node.value && node.right != null) {
            return helper(node.right, target, closest);
        } else {
            return closest;
        }
    }
}
