package solutions;

import java.util.Arrays;

/**
 * 2681. Power of Heroes
 */
public class S2681 {
    public int sumOfPower(int[] nums) {
        // sub sequence, so the order of the elements will not affect the final answer
        // assume a, b, c, d, e are five numbers in ASC order
        // if d is the largest number
        // then power(d) = d^3 + d^2 * (a * 2^2 + b * 2^1 + c * 2^0)
        // if e is the largest number
        // then power(e) = e^3 + e^2 * (a * 2^3 + b * 2^2 + c * 2^1 + d * 2^0)
        // assume s = (a * 2^2 + b * 2^1 + c * 2^0),
        // power(d) = d^3 + d^2 * s = d^2 * (d + s);
        // power(e) = e^3 + e^2 *s' = e^2 * (s' + e), s' = 2 * s + d
        final long MOD = (long) 1e9 + 7;
        Arrays.sort(nums);
        long power = 0, s = 0;
        for (long num : nums) {
            power = (power + num * num % MOD * (num + s)) % MOD;
            s = (2 * s + num) % MOD;
        }

        return (int) power;
    }
}