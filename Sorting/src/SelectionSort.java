import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] expected = {2, 3, 5, 5, 6, 8, 9};
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        int[] actual = selectionSort(input);
        System.out.println("expected: \t" + Arrays.toString(expected));
        System.out.println("actual: \t" + Arrays.toString(actual));
    }

    public static int[] selectionSort(int[] array) {
        for(int i = 0; i < array.length; i++) {
            int minIndex = i;
            for(int j = i; j < array.length; j++) {
                if(array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
        return array;
    }
}
