import java.util.*;

public class TournamentWinner {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> competitions =
                new ArrayList<>();
        ArrayList<String> competition1 =
                new ArrayList<>(Arrays.asList("HTML", "Java"));
        ArrayList<String> competition2 =
                new ArrayList<>(Arrays.asList("Java", "Python"));
        ArrayList<String> competition3 =
                new ArrayList<>(Arrays.asList("Python", "HTML"));
        competitions.add(competition1);
        competitions.add(competition2);
        competitions.add(competition3);
        ArrayList<Integer> results = new ArrayList<>(Arrays.asList(0, 1, 1));
        String expected = "Java";
        String actual = tournamentWinner(competitions, results);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static String tournamentWinner(
            ArrayList<ArrayList<String>> competitions, ArrayList<Integer> results
    ) {
        String bestTeam = "";
        HashMap<String, Integer> best = new HashMap<>();
        best.put("", 0);
        HashMap<String, Integer> map = new HashMap<>();
        for(int i = 0; i < competitions.size(); i++) {
            if(results.get(i) == 1) {
                bestTeam = getBestTeam(map, best, competitions, i, 0, bestTeam);
            } else {
                bestTeam = getBestTeam(map, best, competitions, i, 1, bestTeam);
            }
        }
        return bestTeam;
    }

    public static String getBestTeam(HashMap<String, Integer> map, HashMap<String, Integer> best,
                                   ArrayList<ArrayList<String>> competitions, int i, int winner, String bestTeam) {
        String teamName = competitions.get(i).get(winner);
        if(map.containsKey(teamName)) {
            map.put(teamName, map.get(teamName) + 3);
        } else {
            map.put(teamName, 3);
        }
        if(map.get(teamName) > best.get(bestTeam)) {
            bestTeam = teamName;
            best.put(bestTeam, map.get(teamName));
        }
        return bestTeam;
    }
}



