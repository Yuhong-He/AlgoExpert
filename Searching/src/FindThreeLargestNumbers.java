import java.util.Arrays;

public class FindThreeLargestNumbers {
    public static void main(String[] args) {
        int[] expected = {18, 141, 541};
        int[] actual = findThreeLargestNumbers(new int[] {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7});
        System.out.println("expected: \t" + Arrays.toString(expected));
        System.out.println("actual: \t" + Arrays.toString(actual));
    }

    public static int[] findThreeLargestNumbers(int[] array) {
        int[] largest = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE};
        for(int i: array) {
            updateLargest(largest, i);
        }
        return largest;
    }

    private static void updateLargest(int[] largest, int num) {
        if(num > largest[2]) {
            shiftAndUpdate(largest, num, 2);
        } else if(num > largest[1]) {
            shiftAndUpdate(largest, num, 1);
        } else if(num > largest[0]) {
            shiftAndUpdate(largest, num, 0);
        }
    }

    private static void shiftAndUpdate(int[] largest, int num, int index) {
        for(int i = 0; i <= index; i++) {
            if(i == index) {
                largest[i] = num;
            } else {
                largest[i] = largest[i + 1];
            }
        }
    }
}
