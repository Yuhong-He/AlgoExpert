public class MaxSubsetSumNoAdjacent {
    public static void main(String[] args) {
        int[] input = {75, 105, 120, 75, 90, 135};
        int expected = 330;
        int actual = maxSubsetSumNoAdjacent(input);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static int maxSubsetSumNoAdjacent(int[] array) {
        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        }
        int second = array[0];
        int first = Math.max(array[0], array[1]);
        for (int i = 2; i < array.length; i++) {
            int current = Math.max(first, second + array[i]);
            second = first;
            first = current;
        }
        return first;
    }
}
