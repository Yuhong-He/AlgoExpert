import java.util.Arrays;

public class MinimumWaitingTime {
    public static void main(String[] args) {
        int[] queries = new int[] {3, 2, 1, 2, 6};
        int expected = 17;
        int actual = minimumWaitingTime(queries);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static int minimumWaitingTime(int[] queries) {
        Arrays.sort(queries);
        int currentWaitingTime = 0;
        int waitingTime = 0;
        for (int query : queries) {
            waitingTime += currentWaitingTime;
            currentWaitingTime += query;
        }
        return waitingTime;
    }
}
