import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductSum {
    public static void main(String[] args) {
        List<Object> test = new ArrayList<>(Arrays.asList(
                5,
                2,
                new ArrayList<Object>(Arrays.asList(7, -1)),
                3,
                new ArrayList<Object>(
                        Arrays.asList(6, new ArrayList<Object>(Arrays.asList(-13, 8)), 4)
                )
        ));
        int expected = 12;
        int actual = productSum(test);
        System.out.println("expected: \t" + expected);
        System.out.println("actual: \t" + actual);
    }

    public static int productSum(List<Object> array) {
        return productSumRecursion(array, 1);
    }

    public static int productSumRecursion(List<Object> array, int multiple) {
        int sum = 0;
        for(Object o: array) {
            if(o instanceof ArrayList) {
                sum += productSumRecursion((List<Object>) o, multiple + 1);
            } else {
                sum += (int) o;
            }
        }
        return sum * multiple;
    }
}
