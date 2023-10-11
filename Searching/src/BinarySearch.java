public class BinarySearch {
    public static void main(String[] args) {
        int expected = -1;
        int actual = binarySearch(new int[]{1, 5, 23, 111}, 120);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static int binarySearch(int[] array, int target) {
        int left = 0;
        int right = array.length - 1;
        while(left <= right) {
            int middle = (left + right) / 2;
            if(middle == right) {
                return -1;
            }
            int potentialMatch = array[middle];
            if(target == potentialMatch) {
                return middle;
            } else if(target > potentialMatch) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}
