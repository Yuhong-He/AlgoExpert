import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OptimalFreelancing {
    public static void main(String[] args) {
        HashMap[] input = new HashMap[3];
        HashMap<String, Integer> job1 = new HashMap<>();
        job1.put("deadline", 1);
        job1.put("payment", 1);
        input[0] = job1;
        HashMap<String, Integer> job2 = new HashMap<>();
        job2.put("deadline", 2);
        job2.put("payment", 1);
        input[1] = job2;
        HashMap<String, Integer> job3 = new HashMap<>();
        job3.put("deadline", 2);
        job3.put("payment", 2);
        input[2] = job3;
        var expected = 3;
        var actual = optimalFreelancing(input);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static int optimalFreelancing(Map<String, Integer>[] jobs) {
        final int LENGTH_OF_WEEK = 7;
        int profit = 0;
        Arrays.sort(jobs, (o1, o2) -> o2.get("payment").compareTo(o1.get("payment")));

        boolean[] timeline = new boolean[LENGTH_OF_WEEK];

        for(Map<String, Integer> job: jobs) {
            int maxTime = Math.min(job.get("deadline"), LENGTH_OF_WEEK);
            for(int time = maxTime - 1; time >= 0; time--) {
                if(!timeline[time]) {
                    timeline[time] = true;
                    profit += job.get("payment");
                    break;
                }
            }
        }
        return profit;
    }
}
