import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        List<String> words = new ArrayList<>(
                Arrays.asList("yo", "act", "flop", "tac", "foo", "cat", "oy", "olfp")
        );
        List<List<String>> expected = new ArrayList<>();
        expected.add(new ArrayList<>(List.of("yo", "oy")));
        expected.add(new ArrayList<>(List.of("flop", "olfp")));
        expected.add(new ArrayList<>(List.of("act", "tac", "cat")));
        expected.add(new ArrayList<>(List.of("foo")));
        List<List<String>> actual = groupAnagrams(words);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static List<List<String>> groupAnagrams(List<String> words) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for(String word: words) {
            String newWord = String.valueOf(word);
            char[] wordArr = newWord.toCharArray();
            Arrays.sort(wordArr);
            String wordSorted = String.valueOf(wordArr);
            List<String> list;
            if(!map.containsKey(wordSorted)) {
                list = new ArrayList<>();
            } else {
                list = map.get(wordSorted);
            }
            list.add(word);
            map.put(wordSorted, list);
        }
        for(String key: map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}
