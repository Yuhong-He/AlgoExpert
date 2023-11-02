import java.util.Arrays;

public class NumberOfWaysToMakeChange {
    public static void main(String[] args) {
        int[] input = {1, 5};
        int expected = 2;
        int actual = numberOfWaysToMakeChange(6, input);
        System.out.println("expected: "+ expected);
        System.out.println("actual: "+ actual);
    }

    public static int numberOfWaysToMakeChange(int n, int[] denoms) {
        int[] ways = new int[n + 1];
        ways[0] = 1;
        for(int denom: denoms) {
            for (int amount = 1; amount < n + 1; amount++) {
                if (denom <= amount) {
//                    System.out.println("denom: " + denom);
//                    System.out.println("amount: " + amount);
//                    System.out.println("ways[amount]: " + ways[amount]);
//                    System.out.println("ways[amount - denom]: " + ways[amount - denom]);
//                    System.out.println(Arrays.toString(ways));
                    ways[amount] += ways[amount - denom];
                }
            }
        }
        return ways[n];
    }
}
