public class KadanesAlgorithm {
    public static void main(String[] args) {
        int[] input = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        int expected = 19;
        int actual = kadanesAlgorithm(input);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static int kadanesAlgorithm(int[] array) {
        int max = array[0];
        int current = array[0];
        for (int i = 1; i < array.length; i++) {
            int num = array[i];
            current = Math.max(num, current + num);
            max = Math.max(max, current);
        }
        return max;
    }
}
