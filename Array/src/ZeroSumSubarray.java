import java.util.HashSet;

public class ZeroSumSubarray {
    public static void main(String[] args) {
        int[] input = new int[] {4, 2, -1, -1, 3};
        var expected = true;
        var actual = zeroSumSubarray(input);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static boolean zeroSumSubarray(int[] nums) {
        HashSet<Integer> sums = new HashSet<>();
        int currentSum = 0;
        sums.add(currentSum);
        for(int num: nums) {
            currentSum += num;
            if(sums.contains(currentSum)) {
                return true;
            }
            sums.add(currentSum);
        }
        return false;
    }
}
