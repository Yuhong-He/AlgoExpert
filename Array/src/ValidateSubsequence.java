import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class ValidateSubsequence {
    public static void main(String[] args) {
        var array = Arrays.asList(5, 1, 22, 25, 6, -1, 8, 10);
        var sequence = Arrays.asList(22, 25, 6);
        System.out.println(isValidSubsequence1(array, sequence));
        System.out.println(isValidSubsequence2(array, sequence));
    }

    public static boolean isValidSubsequence1(List<Integer> array, List<Integer> sequence) {
        int arrayIndex = 0;
        int sequenceIndex = 0;
        if(sequence.size() > array.size()) {
            return false;
        }
        while(arrayIndex < array.size()) {
            if(Objects.equals(array.get(arrayIndex), sequence.get(sequenceIndex))) {
                sequenceIndex++;
            }
            arrayIndex++;
            if(sequenceIndex == sequence.size()) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidSubsequence2(List<Integer> array, List<Integer> sequence) {
        int sequenceIndex = 0;
        for(int i : array) {
            if(sequenceIndex == sequence.size()) {
                break;
            }
            if(sequence.get(sequenceIndex).equals(i)) {
                sequenceIndex++;
            }
        }
        return sequenceIndex == sequence.size();
    }
}
