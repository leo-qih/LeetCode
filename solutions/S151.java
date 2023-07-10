package solutions;

/**
 * 151. Reverse Words in a String
 */

public class S151 {
    public String reverseWords(String s) {
        s = ' ' + s;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        for (int r = n, l = n - 1; l >= 0; l--) {
            char c = s.charAt(l);
            if (c == ' ') {
                if (r - l > 1) {
                    sb.append(s.substring(l, r));
                }
                r = l;
            }
        }

        return sb.deleteCharAt(0).toString();
    }
}
