package solutions;

/**
 * 1071. Greatest Common Divisor of Strings
 */

public class S1071 {
    public String gcdOfStrings(String str1, String str2) {
        if (!str1.concat(str2).equals(str2.concat(str1))) {
            return "";
        }

        return str1.substring(0, gcd(str1.length(), str2.length()));
    }

    public int gcd(int a, int b) {
        return  b == 0 ? a : gcd(b, a % b);
    }
}
