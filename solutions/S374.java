package solutions;

/**
 * 374. Guess Number Higher or Lower
 */

public class S374 {
    public int guessNumber(int n) {
        int min = 1, max = n;
        while (min <= max) {
            int num = min + (max - min) / 2;
            int res = guess(num);
            if (res == 0) return num;
            else if (res == -1) {
                max = num - 1;
            } else {
                min = num + 1;
            }
        }

        return -1;
    }
}
