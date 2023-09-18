import java.util.Arrays;

public class SortedSquaredArray {
    public static void main(String[] args) {
        var input = new int[] {1, 2, 3, 5, 6, 8, 9};
        var expected = new int[] {1, 4, 9, 25, 36, 64, 81};
        var actual = sortedSquaredArray(input);
        System.out.println(Arrays.toString(expected));
        System.out.println(Arrays.toString(actual));
    }

    public static int[] sortedSquaredArray(int[] array) {
        int[] result = new int[array.length];
        int small = 0;
        int large = array.length - 1;
        for(int i = array.length - 1; i >= 0; i--) {
            if(Math.abs(array[small]) > Math.abs(array[large])) {
                result[i] = array[small] * array[small];
                small++;
            } else {
                result[i] = array[large] * array[large];
                large--;
            }
        }
        return result;
    }
}
