import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BranchSums {
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
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
        BinaryTree node10 = new BinaryTree(10);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node4.left = node8;
        node4.right = node9;
        node5.left = node10;
        node3.left = node6;
        node3.right = node7;

        int[] expected = new int[] {15, 16, 18, 10, 11};
        List<Integer> result = branchSums(node1);
        System.out.println("expected: \t" + Arrays.toString(expected));
        System.out.println("result: \t" + Arrays.toString(result.toArray()));
    }

    public static List<Integer> branchSums(BinaryTree root) {
        List<Integer> result = new ArrayList<>();
        calculateBranchSums(root, 0, result);
        return result;
    }

    public static void calculateBranchSums(BinaryTree node, int sum, List<Integer> result) {
        if(node != null) {
            sum += node.value;
            if(node.left == null && node.right == null) {
                result.add(sum);
            }
            calculateBranchSums(node.left, sum, result);
            calculateBranchSums(node.right, sum, result);
        }
    }
}
