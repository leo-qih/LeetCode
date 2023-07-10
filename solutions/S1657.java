package solutions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 1657. Determine if Two Strings Are Close
 */

public class S1657 {
    public boolean closeStrings(String word1, String word2) {
        int len1 = word1.length(), len2 = word2.length();
        if (len1 != len2) return false;

        Map<Character, Integer> freq1 = getFreq(word1), freq2 = getFreq(word2);
        if (!freq1.keySet().equals(freq2.keySet())) return false;
        List<Integer> freqArr1 = new ArrayList<>(freq1.values());
        List<Integer> freqArr2 = new ArrayList<>(freq2.values());
        Collections.sort(freqArr1);
        Collections.sort(freqArr2);
        for (int i = 0; i < freqArr1.size(); i++) {
            if (!freqArr1.get(i).equals(freqArr2.get(i))) return false;
        }

        return true;
    }

    public Map<Character, Integer> getFreq(String word) {
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        return freq;
    }
}
