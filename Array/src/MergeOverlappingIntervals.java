import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][] {{1, 2}, {3, 5}, {4, 7}, {6, 8}, {9, 10}};
        int[][] expected = new int[][] {{1, 2}, {3, 8}, {9, 10}};
        int[][] actual = mergeOverlappingIntervals(intervals);
        System.out.println("expected:");
        for (int[] ints : expected) {
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("actual:");
        for (int[] ints : actual) {
            for (int anInt : ints) {
                System.out.print(anInt);
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    public static int[][] mergeOverlappingIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        int[] current = intervals[0];
        result.add(current);
        for(int[] next: intervals) {
            if(current[1] >= next[0]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                current = next;
                result.add(current);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
