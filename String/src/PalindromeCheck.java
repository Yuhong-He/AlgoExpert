import java.lang.reflect.Array;

public class PalindromeCheck {
    public static void main(String[] args) {
        boolean expected = true;
        boolean actual = isPalindrome("abba");
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static boolean isPalindrome(String str) {
        for (int i = 0; i < str.length(); i++) {
            int j = str.length() - 1 - i;
            if(i > j) {
                break;
            }
            if(str.charAt(i) != str.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}
