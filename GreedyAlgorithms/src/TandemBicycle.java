import java.util.Arrays;
import java.util.stream.IntStream;

public class TandemBicycle {
    public static void main(String[] args) {
        int[] redShirtSpeeds = new int[] {5, 5, 3, 9, 2};
        int[] blueShirtSpeeds = new int[] {3, 6, 7, 2, 1};
        boolean fastest = true;
        int expected = 32;
        var actual = tandemBicycle(redShirtSpeeds, blueShirtSpeeds, fastest);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static int tandemBicycle(int[] redShirtSpeeds, int[] blueShirtSpeeds, boolean fastest) {
        Arrays.sort(redShirtSpeeds);
        Arrays.sort(blueShirtSpeeds);
        if(!fastest) {
//            final int[] finalRedShirtSpeeds = redShirtSpeeds;
//            redShirtSpeeds = IntStream.range(0, redShirtSpeeds.length).map(i -> finalRedShirtSpeeds[finalRedShirtSpeeds.length-i-1]).toArray();
            redShirtSpeeds = reverseArray(redShirtSpeeds);
        }
        int total = 0;
        for(int i = 0; i < redShirtSpeeds.length; i++) {
            total += Math.max(redShirtSpeeds[i], blueShirtSpeeds[blueShirtSpeeds.length - i - 1]);
        }
        return total;
    }

    private static int[] reverseArray(int[] array) {
        int[] result = new int[array.length];
        for(int i = 0; i < array.length; i++) {
            result[i] = array[array.length - i - 1];
        }
        return result;
    }
}
