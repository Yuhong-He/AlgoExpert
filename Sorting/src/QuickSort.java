import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] expected = {2, 3, 5, 5, 6, 8, 9};
        int[] input = {8, 5, 2, 9, 5, 6, 3};
        int[] actual = quickSort(input);
        System.out.println("expected: \t" + Arrays.toString(expected));
        System.out.println("actual: \t" + Arrays.toString(actual));
    }

    public static int[] quickSort(int[] array) {
        return quickSortHelper(array, 0, array.length - 1);
    }

    private static int[] quickSortHelper(int[] array, int left, int right) {
        if(left < right) {
            int partitionIndex = partition(array, left, right);
            quickSortHelper(array, left, partitionIndex - 1);
            quickSortHelper(array, partitionIndex + 1, right);
        }
        return array;
    }

    private static int partition(int[] arr, int left, int right) {
        int index = left + 1;
        for(int i = index; i <= right; i++) {
            if(arr[i] < arr[left]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, left, index - 1);
        return index - 1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
