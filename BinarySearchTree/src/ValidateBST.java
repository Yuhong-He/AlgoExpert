public class ValidateBST {
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

        boolean expected = false;
        boolean actual = validateBst(bst1);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static boolean validateBst(BST tree) {
        return helper(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean helper(BST tree, int minValue, int maxValue) {
        if (tree.value < minValue || tree.value >= maxValue) {
            return false;
        }
        if (tree.left != null && ! helper(tree.left, minValue, tree.value)) {
            return false;
        }
        if (tree.right != null && ! helper(tree.right, tree.value, maxValue)) {
            return false;
        }
        return true;
    }

//    public static boolean helper(BST tree, int treeValue) {
//        if (tree.left != null) {
//            if (tree.left.value > treeValue) {
//                return false;
//            }
//            return helper(tree.left, tree.left.value);
//        } else if(tree.right != null) {
//            if (tree.right.value < treeValue) {
//                return false;
//            }
//            return helper(tree.right, tree.right.value);
//        }
//        return true;
//    }
}
