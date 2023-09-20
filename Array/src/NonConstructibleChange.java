import java.util.Arrays;

public class NonConstructibleChange {
    public static void main(String[] args) {
        int[] input = new int[] {6, 4, 5, 1, 1, 8, 9};
        int actual = nonConstructibleChange(input);
        int expected = 20;
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static int nonConstructibleChange(int[] coins) {
        Arrays.sort(coins);
        int currentChange = 0;
        for(int coin : coins) {
            if(coin > currentChange + 1) {
                return currentChange + 1;
            }
            currentChange += coin;
        }
        return currentChange + 1;
    }
}
