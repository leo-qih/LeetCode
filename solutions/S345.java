package solutions;

import java.util.HashSet;
import java.util.List;

/**
 * 345. Reverse Vowels of a String
 */
public class S345 {
     public String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        char[] cs = s.toCharArray();
        int n = cs.length;
        for (int i = 0, j = n - 1; i < j;) {
            if (vowels.contains(cs[i]) && vowels.contains(cs[j])) {
                char temp = cs[i];
                cs[i] = cs[j];
                cs[j] = temp;
                i++;
                j--;
            } else if (!vowels.contains(cs[i])) {
                i++;
            } else {
                j--;
            }
        }

        return String.valueOf(cs);
    }
}
