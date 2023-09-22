import java.util.Arrays;

public class RunLengthEncoding {
    public static void main(String[] args) {
        String input = "AAAAAAAAAAAAABBCCCCDD";
        String expected = "9A4A2B4C2D";
        String actual = runLengthEncoding(input);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static String runLengthEncoding(String string) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while(i < string.length()) {
            char encodingChar = string.charAt(i);
            int encodingCount = 1;
            boolean encodingMode = true;
            while(encodingMode && (i + encodingCount) < string.length()) {
                if(encodingChar == string.charAt(i + encodingCount)) {
                    encodingCount++;
                } else {
                    encodingMode = false;
                }
            }
            if(encodingCount > 9) {
                int encodingTimes = (int) Math.floor((double) encodingCount / 9);
                int remainder = encodingCount % 9;
                for(int j = 0; j < encodingTimes; j++) {
                    result.append(9).append(encodingChar);
                }
                result.append(remainder).append(encodingChar);
            } else {
                result.append(encodingCount).append(encodingChar);
            }
            i += encodingCount;
        }
        return result.toString();
    }
}
