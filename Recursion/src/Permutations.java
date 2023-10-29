import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<List<Integer>> expected = List.of(
                List.of(1, 2, 3),
                List.of(1, 3, 2),
                List.of(2, 1 ,3),
                List.of(2, 3, 1),
                List.of(3, 1, 2),
                List.of(3, 2, 1)
        );
        List<List<Integer>> actual = getPermutations(input);
        System.out.println("expected: \t" + Arrays.toString(expected.toArray()));
        System.out.println("actual: \t" + Arrays.toString(actual.toArray()));
    }

    public static List<List<Integer>> getPermutations(List<Integer> array) {
        ArrayList<List<Integer>> permutations = new ArrayList<>();
        helper(array, new ArrayList<>(), permutations);
        return permutations;
    }

    public static void helper(List<Integer> array, ArrayList<Integer> currentPermutation, ArrayList<List<Integer>> permutations) {
        if (array.isEmpty() && !currentPermutation.isEmpty()) {
            permutations.add(currentPermutation);
        } else {
            for (int i = 0; i < array.size(); i++) {
                ArrayList<Integer> newArr = new ArrayList<>(array);
                newArr.remove(i);
                ArrayList<Integer> newPermutation = new ArrayList<>(currentPermutation);
                newPermutation.add(array.get(i));
                helper(newArr, newPermutation, permutations);
            }
        }
    }
}
