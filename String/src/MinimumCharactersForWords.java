import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinimumCharactersForWords {
    public static void main(String[] args) {
        String[] words = new String[] {"this", "that", "did", "deed", "them!", "a"};
        char[] expected = new char[] {'t', 't', 'h', 'i', 's', 'a', 'd', 'd', 'e', 'e', 'm', '!'};
        char[] actual = minimumCharactersForWords(words);
        System.out.println("expected: \t" + Arrays.toString(expected));
        System.out.println("actual: \t" + Arrays.toString(actual));
    }

    public static char[] minimumCharactersForWords(String[] words) {
        HashMap<Character, Integer> result = new HashMap<>();
        for(String word: words) {
            HashMap<Character, Integer> count = new HashMap<>();
            for(int i = 0; i < word.length(); i++) {
                if(count.containsKey(word.charAt(i))) {
                    count.put(word.charAt(i), count.get(word.charAt(i)) + 1);
                } else {
                    count.put(word.charAt(i), 1);
                }
            }
            for(Character c: count.keySet()) {
                if(result.containsKey(c)) {
                    if(count.get(c) > result.get(c)) {
                        result.put(c, count.get(c));
                    }
                } else {
                    result.put(c, count.get(c));
                }
            }
        }
        List<Character> resultList = new ArrayList<>();
        for(Character c: result.keySet()) {
            for(int i = 0; i < result.get(c); i++) {
                resultList.add(c);
            }
        }
        char[] charArray = new char[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            charArray[i] = resultList.get(i);
        }
        return charArray;
    }
}
