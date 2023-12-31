import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Powerset {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<List<Integer>> perms = powerset(input);
        System.out.println(perms);
    }

    public static List<List<Integer>> powerset(List<Integer> array) {
        return powerset(array, array.size() - 1);
    }

    public static List<List<Integer>> powerset(List<Integer> array, int idx) {
        if(idx < 0) {
            List<List<Integer>> emptySet = new ArrayList<>();
            emptySet.add(new ArrayList<>());
            return emptySet;
        }
        int ele = array.get(idx);
        List<List<Integer>> subsets = powerset(array, idx - 1);
        int length = subsets.size();
        for(int i = 0; i < length; i++) {
            List<Integer> currentSubset = new ArrayList<>(subsets.get(i));
            currentSubset.add(ele);
            subsets.add(currentSubset);
        }
        return subsets;
    }
}
