import java.util.*;

public class MajorityElement {
    public static void main(String[] args) {
        var input = new int[] {1, 2, 3, 2, 2, 1, 2};
        var expected = 2;
        var actual = majorityElement(input);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static int majorityElement(int[] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i: array) {
            if(map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        return list.get(0).getKey();
    }
}
