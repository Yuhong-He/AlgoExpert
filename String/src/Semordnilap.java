import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Semordnilap {
    public static void main(String[] args) {
        String[] input = new String[] {"desserts", "stressed", "hello"};
        ArrayList<ArrayList<String>> expected = new ArrayList<ArrayList<String>>();
        ArrayList<String> pair = new ArrayList<String>();
        pair.add("desserts");
        pair.add("stressed");
        expected.add(pair);
        ArrayList<ArrayList<String>> actual = semordnilap2(input);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static ArrayList<ArrayList<String>> semordnilap1(String[] words) {
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for(int i = 0; i < words.length; i++) {
            ArrayList<String> pair = new ArrayList<>();
            for(int j = i; j < words.length; j++) {
                if(words[i].length() == words[j].length() && i != j) {
                    pair.add(words[i]);
                    pair.add(words[j]);
                    for(int index = 0; index < words[i].length(); index++) {
                        if(words[i].charAt(index) != words[j].charAt(words[j].length() - index - 1)) {
                            pair.remove(words[i]);
                            pair.remove(words[j]);
                            break;
                        }
                    }
                }
                if(!pair.isEmpty()) {
                    result.add(pair);
                    break;
                }
            }
        }
        return result;
    }

    public static ArrayList<ArrayList<String>> semordnilap2(String[] words) {
        HashSet<String> set = new HashSet<>(Set.of(words));
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        for(String word: words) {
            String reverse = String.valueOf(new StringBuilder(word).reverse());
            if(set.contains(reverse) && !word.equals(reverse)) {
                ArrayList<String> pair = new ArrayList<>();
                pair.add(word);
                pair.add(reverse);
                result.add(pair);
                set.remove(word);
                set.remove(reverse);
            }
        }
        return result;
    }
}
