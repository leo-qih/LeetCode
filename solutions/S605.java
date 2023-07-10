package solutions;

/**
 * 605. Can Place Flowers
 */

public class S605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int len = flowerbed.length;
        for (int i = 0; i < len;) {
            if (flowerbed[i] == 1) {
                i += 2;
            } else if (i == len - 1 || flowerbed[i + 1] == 0) {
                n--;
                i += 2;
            } else {
                i += 3;
            }
            if (n <= 0) return true;
        }

        return n <= 0;
    }
}
