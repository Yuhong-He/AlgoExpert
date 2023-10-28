public class StaircaseTraversal {
    public static void main(String[] args) {
        int stairs = 4;
        int maxSteps = 2;
        int expected = 5;
        int actual = staircaseTraversal(stairs, maxSteps);
        System.out.println("expected:" + expected);
        System.out.println("actual:" + actual);
    }

    public static int staircaseTraversal(int height, int maxSteps) {
        return helper(height, maxSteps);
    }

    public static int helper(int height, int maxSteps) {
        if(height <= 1) {
            return 1;
        }

        int num = 0;
        for(int step = 1; step < Math.min(height, maxSteps) + 1; step++) {
            num += helper(height - step, maxSteps);
        }
        return num;
    }
}
