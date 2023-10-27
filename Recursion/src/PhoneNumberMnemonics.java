import java.util.*;

public class PhoneNumberMnemonics {
    public static void main(String[] args) {
        String phoneNumber = "1905";
        String[] expected = new String[] {
                "1w0j",
                "1w0k",
                "1w0l",
                "1x0j",
                "1x0k",
                "1x0l",
                "1y0j",
                "1y0k",
                "1y0l",
                "1z0j",
                "1z0k",
                "1z0l"
        };
        ArrayList<String> actual = phoneNumberMnemonics(phoneNumber);
        System.out.println("expected: \n" + Arrays.toString(expected));
        System.out.println("actual: \n" + Arrays.toString(actual.toArray()));
    }

    static Map<Character, List<Character>> keyboards = Map.of(
            '1', List.of('1'),
            '2', List.of('a', 'b', 'c'),
            '3', List.of('d', 'e', 'f'),
            '4', List.of('g', 'h', 'i'),
            '5', List.of('j', 'k', 'l'),
            '6', List.of('m', 'n', 'o'),
            '7', List.of('p', 'q', 'r', 's'),
            '8', List.of('t', 'u', 'v'),
            '9', List.of('w', 'x', 'y', 'z'),
            '0', List.of('0')
    );

    public static ArrayList<String> phoneNumberMnemonics(String phoneNumber) {
        ArrayList<String> result = new ArrayList<>();
        String[] currentMnemonic = new String[phoneNumber.length()];
        helper(0, phoneNumber, currentMnemonic, result);
        return result;
    }

    public static void helper(int idx, String phoneNumber, String[] currentMnemonic, ArrayList<String> result) {
        if(idx == phoneNumber.length()) {
            String mnemonic = String.join("", currentMnemonic);
            result.add(mnemonic);
        } else {
            char digit = phoneNumber.charAt(idx);
            List<Character> list = keyboards.get(digit);
            for(char c: list) {
                currentMnemonic[idx] = String.valueOf(c);
                helper(idx + 1, phoneNumber, currentMnemonic, result);
            }
        }
    }
}
