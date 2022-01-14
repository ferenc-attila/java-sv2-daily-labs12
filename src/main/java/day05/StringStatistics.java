package day05;

import java.util.HashMap;
import java.util.Map;

public class StringStatistics {

    public Map<Character, Integer> createStringStatistics(String string) {
        Map<Character, Integer> numberOfCharacters = new HashMap<>();
        char[] chars = string.toCharArray();
        for (char c : chars) {
            if (!numberOfCharacters.containsKey(c)) {
                numberOfCharacters.put(c, 1);
            } else {
                numberOfCharacters.put(c, numberOfCharacters.get(c) + 1);
            }
        }
        return numberOfCharacters;
    }
}
