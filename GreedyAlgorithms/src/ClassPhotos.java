import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ClassPhotos {
    public static void main(String[] args) {
        ArrayList<Integer> redShirtHeights =
                new ArrayList<>(Arrays.asList(5, 8, 1, 3, 4, 9));
        ArrayList<Integer> blueShirtHeights =
                new ArrayList<>(Arrays.asList(6, 9, 2, 4, 5, 1));
        boolean expected = false;
        boolean actual = classPhotos(redShirtHeights, blueShirtHeights);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static boolean classPhotos(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
        Collections.sort(redShirtHeights);
        Collections.sort(blueShirtHeights);
        int length = redShirtHeights.size();
        boolean redBack = false;
        boolean blueBack = false;
        for(int i = 0; i < length; i++) {
            if(redShirtHeights.get(i) > blueShirtHeights.get(i)) {
                redBack = true;
            } else if(redShirtHeights.get(i) < blueShirtHeights.get(i)) {
                blueBack = true;
            } else {
                return false;
            }
            if(redBack && blueBack) {
                return false;
            }
        }
        return true;
    }
}
