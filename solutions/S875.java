package solutions;

/**
 * 875. Koko Eating Bananas
 */

public class S875 {
    public int minEatingSpeed(int[] piles, int h) {
        int maxSpeed = 0;
        for (int pileCnt : piles) {
            maxSpeed = Math.max(maxSpeed, pileCnt);
        }

        int minSpeed = 1;
        while (minSpeed < maxSpeed) {
            int mid = minSpeed + (maxSpeed - minSpeed) / 2;
            int hours = getHoursToEatAll(piles, mid);
            if (hours <= h) {
                maxSpeed = mid;
            } else {
                minSpeed = mid + 1;
            }
        }

        return minSpeed;
    }

    public int getHoursToEatAll(int[] piles, int speed) {
        int totalHours = 0;
        for (int pileCnt : piles) {
            totalHours += pileCnt / speed + (pileCnt % speed == 0 ? 0 : 1);
        }

        return totalHours;
    }
}
