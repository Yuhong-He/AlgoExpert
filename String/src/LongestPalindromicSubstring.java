public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String input = "ab";
        String expected = "";
        String actual = longestPalindromicSubstring(input);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static String longestPalindromicSubstring(String str) {
        String result = "";
        if(str.length() == 1 || (str.length() == 2 && str.charAt(0) == str.charAt(1))) {
            return str;
        }
        for(int i = 1; i < str.length() - 1; i++) {
            int left = i - 1;
            int right = i + 1;
            while(left >= 0 && right < str.length()) {
                String current;
                if(str.charAt(left) == str.charAt(right)) { // case odd palindrome
                    current = str.substring(left, right + 1);
                    if(current.length() > result.length()) {
                        result = current;
                    }
                } else if (str.charAt(right - 1) == str.charAt(right)) { // case even palindrome
                    left = right - 1;
                    current = str.substring(left, right + 1);
                    if(current.length() > result.length()) {
                        result = current;
                    }
                } else {
                    break;
                }
                left--;
                right++;
            }
        }
        return result;
    }
}
