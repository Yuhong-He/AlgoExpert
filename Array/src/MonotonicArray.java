public class MonotonicArray {
    public static void main(String[] args) {
        var array = new int[] {-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        var expected = true;
        var actual = isMonotonic(array);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static boolean isMonotonic(int[] array) {
        if(array.length == 0 || array.length == 1) {
            return true;
        }
        boolean increase = false;
        boolean decrease = false;
        for(int i = 0; i < array.length - 1; i++) {
            int j = i + 1;
            if(array[j] > array[i]) {
                increase = true;
            } else if(array[j] < array[i]) {
                decrease = true;
            }

            if(increase && decrease) {
                return false;
            }
        }
        return true;
    }
}
