import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MoveElementToEnd {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(2, 1, 2, 2, 2, 3, 4, 2));
        int toMove = 2;
        List<Integer> expectedStart = new ArrayList<>(Arrays.asList(1, 3, 4));
        List<Integer> expectedEnd = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2));
        List<Integer> actual = moveElementToEnd(array, toMove);
        System.out.println("expectedStart: " + expectedStart);
        System.out.println("expectedEnd: " + expectedEnd);
        System.out.println("actual: " + actual);
    }

    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove) {
        List<Integer> end = new ArrayList<>();
        for(int i = 0; i < array.size(); i++) {
            if(array.get(i) == toMove) {
                array.remove(i);
                end.add(toMove);
                i--;
            }
        }
        array.addAll(end);
        return array;
    }
}
