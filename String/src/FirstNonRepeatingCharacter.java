import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        String input = "abcdcaf";
        int expected = 1;
        var actual = firstNonRepeatingCharacter(input);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static int firstNonRepeatingCharacter(String string) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < string.length(); i++) {
            if(!map.containsKey(string.charAt(i))) {
                map.put(string.charAt(i), 1);
            } else {
                map.put(string.charAt(i), map.get(string.charAt(i)) + 1);
            }
        }
        for(int i = 0; i < string.length(); i++) {
            if(map.get(string.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
