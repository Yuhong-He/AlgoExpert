import java.util.Arrays;

public class ThreeNumberSort {
    public static void main(String[] args) {
        var array = new int[] {1, 0, 0, -1, -1, 0, 1, 1};
        var order = new int[] {0, 1, -1};
        var expected = new int[] {0, 0, 0, 1, 1, 1, -1, -1};
        var actual = threeNumberSort(array, order);
        System.out.println("expected: \t" + Arrays.toString(expected));
        System.out.println("actual: \t" + Arrays.toString(actual));
    }

    public static int[] threeNumberSort(int[] array, int[] order) {
        int sorted_index = 0;
        for (int k : order) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == k) {
                    int temp = array[i];
                    array[i] = array[sorted_index];
                    array[sorted_index] = temp;
                    sorted_index++;
                }
            }
        }
        return array;
    }
}
