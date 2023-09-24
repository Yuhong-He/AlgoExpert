import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {
    public static void main(String[] args) {
        String characters = "Bste!hetsi ogEAxpelrt x ";
        String document = "AlgoExpert is the Best!";
        boolean expected = true;
        var actual = generateDocument(characters, document);
        System.out.println("expected: " + expected);
        System.out.println("actual: " + actual);
    }

    public static boolean generateDocument(String characters, String document) {
        Map<Character, Integer> charactersMap = new HashMap<>();
        Map<Character, Integer> documentMap = new HashMap<>();
        countFrequent(characters, charactersMap);
        countFrequent(document, documentMap);
        for (Character key : documentMap.keySet()) {
            if(!charactersMap.containsKey(key)) {
                return false;
            }
            if(documentMap.get(key) > charactersMap.get(key)) {
                return false;
            }
        }
        return true;
    }

    private static void countFrequent(String document, Map<Character, Integer> documentMap) {
        for(int i = 0; i < document.length(); i++) {
            if(!documentMap.containsKey(document.charAt(i))) {
                documentMap.put(document.charAt(i), 0);
            } else {
                documentMap.put(document.charAt(i), documentMap.get(document.charAt(i)) + 1);
            }
        }
    }
}
