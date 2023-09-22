import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumberSum {
    public static void main(String[] args) {
        List<Integer[]> expected = new ArrayList<Integer[]>();
        expected.add(new Integer[] {-8, 2, 6});
        expected.add(new Integer[] {-8, 3, 5});
        expected.add(new Integer[] {-6, 1, 5});
        List<Integer[]> actual = threeNumberSum(new int[] {12, 3, 1, 2, -6, 5, -8, 6}, 0);
        System.out.println(expected);
        System.out.println(actual);
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {
        List<Integer[]> result = new ArrayList<>();
        Arrays.sort(array);
        for(int current = 0; current < array.length; current++) {
            int left = current + 1;
            int right = array.length - 1;
            while(left < right) {
                int sum = array[current] + array[left] + array[right];
                if(sum == targetSum) {
                    Integer[] triplet = { array[current], array[left], array[right] };
                    result.add(triplet);
                    left++;
                    right--;
                } else if (sum < targetSum) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
