import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BalancedBrackets {
    public static void main(String[] args) {
        String input = "([])(){}(())()()";
        boolean expected = true;
        boolean actual = balancedBrackets(input);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static boolean balancedBrackets(String str) {
        List<Character> openCharacters = List.of('(', '[', '{');
        List<Character> closeCharacters = List.of(')', ']', '}');
        Map<Character, Character> matchPair = Map.of(')', '(', ']', '[', '}', '{');
        List<Character> stack = new ArrayList<>();
        for(int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            if(openCharacters.contains(letter)) {
                stack.add(letter);
            } else if(closeCharacters.contains(letter)) {
                if(stack.size() == 0) {
                    return false;
                }
                if(stack.get(stack.size() - 1) == matchPair.get(letter)) {
                    stack.remove(stack.size() - 1);
                } else {
                    return false;
                }
            }
        }
        return stack.size() == 0;
    }
}
