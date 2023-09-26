import java.util.ArrayList;

public class Semordnilap {
    public static void main(String[] args) {
        String[] input = new String[] {"desserts", "stressed", "hello"};
        ArrayList<ArrayList<String>> expected = new ArrayList<ArrayList<String>>();
        ArrayList<String> pair = new ArrayList<String>();
        pair.add("desserts");
        pair.add("stressed");
        expected.add(pair);
        ArrayList<ArrayList<String>> actual = semordnilap(input);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static ArrayList<ArrayList<String>> semordnilap(String[] words) {
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
}
