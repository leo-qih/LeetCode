package solutions;

/**
 * 1732. Find the Highest Altitude
 */

public class S1732 {
    public int largestAltitude(int[] gain) {
        int altitude = 0, maxAltitude = 0;
        for (int num : gain) {
            altitude += num;
            maxAltitude = Math.max(maxAltitude, altitude);
        }

        return maxAltitude;
    }
}
