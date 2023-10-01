public class OneEdit {
    public static void main(String[] args) {
        String stringOne = "helo";
        String stringTwo = "helle";
        boolean expected = false;
        boolean actual = oneEdit(stringOne, stringTwo);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static boolean oneEdit(String stringOne, String stringTwo) {
        if(Math.abs(stringOne.length() - stringTwo.length()) > 1) {
            return false;
        }
        for(int i = 0; i < Math.min(stringOne.length(), stringTwo.length()); i++) {
            if(stringOne.charAt(i) != stringTwo.charAt(i)) {
                if(stringOne.length() > stringTwo.length()) {
                    return stringOne.substring(i + 1).equals(stringTwo.substring(i));
                } else if(stringOne.length() < stringTwo.length()) {
                    return stringOne.substring(i).equals(stringTwo.substring(i + 1));
                } else {
                    return stringOne.substring(i + 1).equals(stringTwo.substring(i + 1));
                }
            }
        }
        return true;
    }
}
