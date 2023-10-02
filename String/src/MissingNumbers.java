import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MissingNumbers {
    public static void main(String[] args) {
        int[] input = new int[] {4, 5, 1, 3};
        int[] expected = new int[] {2, 6};
        int[] actual = missingNumbers(input);
        System.out.println("expected: \t" + Arrays.toString(expected));
        System.out.println("actual: \t" + Arrays.toString(actual));
    }

    public static int[] missingNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        int[] missed = new int[] {0, 0};
        for (int num : nums) {
            list.add(num);
        }
        for(int i = 1; i < nums.length + 2 + 1; i++) {
            if(!list.contains(i)) {
                if(missed[0] == 0) {
                    missed[0] = i;
                } else {
                    missed[1] = i;
                }
            }
        }
        return missed;
    }
}
