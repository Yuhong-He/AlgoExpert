import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class SunSetViews {
    public static void main(String[] args) {
        int[] buildings = new int[] {3, 5, 4, 4, 3, 1, 3, 2};
        String direction = "EAST";
        ArrayList<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(3);
        expected.add(6);
        expected.add(7);
        ArrayList<Integer> actual = sunsetViews(buildings, direction);
        System.out.println("expected: \t" + Arrays.toString(expected.toArray()));
        System.out.println("actual: \t" + Arrays.toString(actual.toArray()));
    }

    public static ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        ArrayList<Integer> result = new ArrayList<>();
        int highest = 0;
        if(direction.equals("WEST")) {
            for (int i = 0; i < buildings.length; i++) {
                if(buildings[i] > highest)
                    result.add(i);
                highest = Math.max(buildings[i], highest);
            }
        } else {
            for (int i = buildings.length - 1; i >= 0; i--) {
                if(buildings[i] > highest)
                    result.add(i);
                highest = Math.max(buildings[i], highest);
            }
            Collections.reverse(result);
        }
        return result;
    }
}
