import java.util.ArrayList;
import java.util.List;

public class ReverseWordsInString {
    public static void main(String[] args) {
        String input = "test        ";
        String expected = "        test";
        String actual = reverseWordsInString(input);
        System.out.println(expected);
        System.out.println(actual);
    }

    public static String reverseWordsInString(String string) {
        List<String> words = new ArrayList<>();
        List<String> spaces = new ArrayList<>();
        StringBuilder word = new StringBuilder();
        StringBuilder space = new StringBuilder();
        for(int i = 0; i < string.length(); i++) {
            if(string.charAt(i) != ' ') { // case word
                if(space.toString().length() > 0) {
                    spaces.add(space.toString());
                }
                word.append(string.charAt(i));
                space = new StringBuilder();
            } else { // case space
                if(word.toString().length() > 0) {
                    words.add(word.toString());
                }
                space.append(string.charAt(i));
                word = new StringBuilder();
            }
            if(i == string.length() - 1) { // case end
                if(word.toString().length() > 0) {
                    words.add(word.toString());
                }
                if(space.toString().length() > 0) {
                    spaces.add(space.toString());
                }
            }
        }
        StringBuilder result = new StringBuilder();
        if(string.endsWith(" ")) {
            for(int i = spaces.size() - 1; i >= 0; i--) {
                result.append(spaces.get(i));
                if(spaces.size() > words.size()) {
                    if(i != 0) {
                        result.append(spaces.get(i - 1));
                    }
                } else {
                    result.append(words.get(i));
                }
            }
        } else {
            for(int i = words.size() - 1; i >= 0; i--) {
                result.append(words.get(i));
                if(words.size() > spaces.size()) {
                    if(i != 0) {
                        result.append(spaces.get(i - 1));
                    }
                }
            }
        }
        return result.toString();
    }
}
