import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SweetAndSavory {
    public static void main(String[] args) {
        int[] dishes = new int[] {-3, -5, 1, 7};
        int target = 8;
        int[] expected = new int[] {-3, 7};
        int[] actual = sweetAndSavory(dishes, target);
        System.out.println("expected: " + Arrays.toString(expected));
        System.out.println("actual: " + Arrays.toString(actual));
    }

    public static int[] sweetAndSavory(int[] dishes, int target) {
        List<Integer> savory = new ArrayList<>();
        List<Integer> sweet = new ArrayList<>();
        int closest = Integer.MAX_VALUE;
        int[] result = {0, 0};
        for (int dish : dishes) {
            if (dish > 0) {
                savory.add(dish);
            } else {
                sweet.add(dish);
            }
        }
        sweet.sort(Comparator.comparingInt(Math::abs));
        savory.sort(Comparator.naturalOrder());
        int indexSavory = 0, indexSweet = 0;
        while(indexSweet < sweet.size() && indexSavory < savory.size()) {
            int currentSum = savory.get(indexSavory) + sweet.get(indexSweet);
            if(currentSum <= target) {
                int currentDistance = target - currentSum;
                if(currentDistance < closest) {
                    result = new int[]{sweet.get(indexSweet), savory.get(indexSavory)};
                    closest = currentDistance;
                }
                indexSavory++;
            } else {
                indexSweet++;
            }
        }
        return result;
    }
}
