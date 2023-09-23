import java.util.*;

public class CommonCharacters {
    public static void main(String[] args) {
        String[] input = new String[] {"aaaa", "a"};
        String[] expected = new String[] {"b", "c"};
        String[] actual = commonCharacters(input);
        System.out.println("expected: " + Arrays.toString(expected));
        System.out.println("actual: " + Arrays.toString(actual));
    }

    public static String[] commonCharacters(String[] strings) {
        Set<Character> set = new HashSet<>();
        List<String> list = new ArrayList<>();
        for(int i = 0; i < strings[0].length(); i++) {
            char c = strings[0].charAt(i);
            if(!set.contains(c)) {
                int count = 1;
                for(int j = 1; j < strings.length; j++) {
                    if(strings[j].contains(String.valueOf(c))) {
                        count++;
                    } else {
                        break;
                    }
                }
                if(count == strings.length) {
                    list.add(String.valueOf(c));
                }
                set.add(c);
            }
        }
        return list.toArray(String[]::new);
    }
}
