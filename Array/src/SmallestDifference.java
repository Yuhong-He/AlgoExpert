import java.util.Arrays;

public class SmallestDifference {
    public static void main(String[] args) {
        int[] input1 = {-1, 5, 10, 20, 28, 3};
        int[] input2 = {26, 134, 135, 15, 17};
        int[] expected = {28, 26};
        int[] actual = smallestDifference2(input1, input2);
        System.out.println("expected: " + Arrays.toString(expected));
        System.out.println("actual: " + Arrays.toString(actual));
    }

    public static int[] smallestDifference1(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int smallestOne = 0;
        int smallestTwo = 0;
        int smallestSum = Integer.MAX_VALUE;
        for (int i : arrayOne) {
            for (int j : arrayTwo) {
                int currentSum = Math.abs(i - j);
                if (currentSum == 0) {
                    return new int[]{i, j};
                } else {
                    if (currentSum < smallestSum) {
                        smallestSum = currentSum;
                        smallestOne = i;
                        smallestTwo = j;
                    }
                }
            }
        }
        return new int[] {smallestOne, smallestTwo};
    }

    public static int[] smallestDifference2(int[] arrayOne, int[] arrayTwo) {
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        int indexOne = 0;
        int indexTwo = 0;
        int smallestSum = Integer.MAX_VALUE;
        int currentSum;
        int[] result = new int[2];
        while(indexOne < arrayOne.length && indexTwo < arrayTwo.length) {
            int one = arrayOne[indexOne];
            int two = arrayTwo[indexTwo];
            if(one > two) {
                currentSum = Math.abs(one - two);
                indexTwo++;
            } else if (one < two) {
                currentSum = Math.abs(two - one);
                indexOne++;
            } else {
                result = new int[] {one, two};
                break;
            }
            if(currentSum < smallestSum) {
                smallestSum = currentSum;
                result = new int[] {one, two};
            }
        }
        return result;
    }
}
