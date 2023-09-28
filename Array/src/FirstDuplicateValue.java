import java.util.HashSet;

public class FirstDuplicateValue {
    public static void main(String[] args) {
        var input = new int[] {2, 1, 5, 3, 3, 2, 4};
        var expected = 3;
        var actual = firstDuplicateValue(input);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static int firstDuplicateValue(int[] array) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : array) {
            if (!set.add(i)) {
                return i;
            }
        }
        return -1;
    }
}
