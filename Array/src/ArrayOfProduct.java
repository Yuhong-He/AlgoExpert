import java.util.Arrays;

public class ArrayOfProduct {
    public static void main(String[] args) {
        var input = new int[] {5, 1, 4, 2};
        var expected = new int[] {8, 40, 10, 20};
        int[] actual = arrayOfProducts2(input);
        System.out.println("expected: " + Arrays.toString(expected));
        System.out.println("actual: " + Arrays.toString(actual));
    }

    public static int[] arrayOfProducts1(int[] array) {
        int[] result = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            result[i] = 1;
            for(int j = 0; j < array.length; j++) {
                if(j != i) {
                    result[i] = result[i] * array[j];
                }
            }
        }
        return result;
    }

    public static int[] arrayOfProducts2(int[] array) {
        int[] result = new int[array.length];
        int[] left = new int[array.length];
        int[] right = new int[array.length];
        int temp = 1;
        for(int i = 0; i < array.length; i++) {
            left[i] = temp;
            temp *= array[i];
        }
        temp = 1;
        for(int i = array.length - 1; i >= 0; i--) {
            right[i] = temp;
            temp *= array[i];
        }
        for(int i = 0; i < result.length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}
