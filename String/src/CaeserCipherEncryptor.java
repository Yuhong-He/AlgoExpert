import java.util.Arrays;

public class CaeserCipherEncryptor {
    public static void main(String[] args) {
        String actual = caesarCypherEncryptor("abc", 52);
        String expected = "abc";
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static String caesarCypherEncryptor(String str, int key) {
        // In ASCII, A = 41, Z = 90, a = 97, z = 122
        StringBuilder result = new StringBuilder();
        key = key % 26;
        for(int i = 0; i < str.length(); i++) {
            if(((int) str.charAt(i) + key) > 122) {
                int shift = (int) str.charAt(i) + key - 122;
                result.append((char) (97 - 1 + shift));
            } else {
                result.append((char) ((int) str.charAt(i) + key));
            }
        }
        return result.toString();
    }
}
