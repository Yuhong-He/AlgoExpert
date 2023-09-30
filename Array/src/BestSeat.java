public class BestSeat {
    public static void main(String[] args) {
        int[] input = new int[] {1, 0, 0, 1, 0, 0, 1};
        int expected = 1;
        int actual = bestSeat(input);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static int bestSeat(int[] seats) {
        int currentStart = 0;
        int rangeStart = 0;
        int rangeLength = 0;
        int currentLength = 0;
        boolean inRange = false;
        for(int i = 0; i < seats.length; i++) {
            if(seats[i] == 0) {
                if(!inRange) {
                    currentStart = i;
                    inRange = true;
                }
                currentLength++;
            } else {
                inRange = false;
                currentLength = 0;
            }
            if(currentLength > rangeLength) {
                rangeLength = currentLength;
                rangeStart = currentStart;
            }
        }
        if(rangeLength == 0) {
            return -1;
        } else {
            if(rangeLength % 2 == 1) {
                return (int) (rangeStart + rangeLength / 2.0);
            } else {
                return (int) (rangeStart + rangeLength / 2.0) - 1;
            }
        }
    }
}
