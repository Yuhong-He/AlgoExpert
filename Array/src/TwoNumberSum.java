import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoNumberSum {
    public static void main(String[] args) {
        int[] output1 = twoNumberSum1(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10);
        System.out.println(Arrays.toString(output1));
        int[] output2 = twoNumberSum2(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10);
        System.out.println(Arrays.toString(output2));
        int[] output3 = twoNumberSum3(new int[] {3, 5, -4, 8, 11, 1, -1, 6}, 10);
        System.out.println(Arrays.toString(output3));
    }

    public static int[] twoNumberSum1(int[] array, int targetSum) {
        for(int i = 0; i < array.length; i++) {
            for(int j = array.length - 1; j > i; j--) {
                if((array[i] + array[j]) == targetSum) {
                    return new int[] {array[i], array[j]};
                }
            }
        }
        return new int[0];
    }

    public static int[] twoNumberSum2(int[] array, int targetSum) {
        HashSet<Integer> nums = new HashSet<>();
        for (int i : array) {
            int targetNum = targetSum - i;
            if (nums.contains(targetNum)) {
                return new int[]{i, targetNum};
            } else {
                nums.add(i);
            }
        }
        return new int[0];
    }

    public static int[] twoNumberSum3(int[] array, int targetSum) {
        Arrays.sort(array);
        int left = 0;
        int right = array.length - 1;
        while(left < right) {
            int sum = array[left] + array[right];
            if(sum == targetSum) {
                return new int[]{array[left], array[right]};
            } else if (sum < targetSum) {
                left++;
            } else {
                right--;
            }
        }
        return new int[0];
    }
}