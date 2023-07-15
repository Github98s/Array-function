import java.util.HashMap;
import java.util.Map;

public class AnagramChecker {

    public static boolean areAnagrams(String str1, String str2) {
        // Remove spaces and punctuation, and convert to lowercase
        str1 = str1.replaceAll("[^a-zA-Z]", "").toLowerCase();
        str2 = str2.replaceAll("[^a-zA-Z]", "").toLowerCase();

        if (str1.length() != str2.length()) {
            return false; // Anagrams must have the same length
        }

        Map<Character, Integer> charFrequency = new HashMap<>();

        // Count the occurrences of each character in str1
        for (char c : str1.toCharArray()) {
            charFrequency.put(c, charFrequency.getOrDefault(c, 0) + 1);
        }

        // Check if the characters in str2 match the counts in charFrequency
        for (char c : str2.toCharArray()) {
            int count = charFrequency.getOrDefault(c, 0);
            if (count == 0) {
                return false; // Character not present in str1 or already used up
            }
            charFrequency.put(c, count - 1); // Decrease the count for the character
        }

        return true;
    }

    public static void main(String[] args) {
        String str1 = "listen";
        String str2 = "silent";
        System.out.println(areAnagrams(str1, str2)); // Output: true

        str1 = "restful";
        str2 = "fluster";
        System.out.println(areAnagrams(str1, str2)); // Output: true
    }
}
