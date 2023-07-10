package solutions;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 394. Decode String
 */

public class S394 {
    public String decodeString(String s) {
        Deque<String> chars = new ArrayDeque<>();
        Deque<Integer> nums = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int repeatTime = 0, j = i;
                while (Character.isDigit(c)) {
                    repeatTime = repeatTime * 10 + (c - '0');
                    j++;
                    c = s.charAt(j);
                }
                nums.push(repeatTime);
                i = j - 1;
            } else if (c == ']') {
                StringBuilder subStr = new StringBuilder();
                while (!chars.peek().equals("[")) {
                    subStr.insert(0, chars.pop());
                }
                chars.pop();

                int repeatTime = nums.pop();
                StringBuilder str = new StringBuilder();
                for (int j = 0; j < repeatTime; j++) {
                    str.append(subStr);
                }
                chars.push(str.toString());
            } else {
                chars.push(String.valueOf(c));
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!chars.isEmpty()) {
            sb.insert(0, chars.pop());
        }

        return sb.toString();
    }
}
