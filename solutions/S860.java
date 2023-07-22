package solutions;

/**
 * 860. Lemonade Change
 */

public class S860 {
    public boolean lemonadeChange(int[] bills) {
        int[] coinCnt = new int[2]; // count of [5, 10]
        for (int bill : bills) {
            switch (bill) {
                case 5:
                    coinCnt[0]++;
                    break;
                case 10:
                    if (coinCnt[0] < 1) return false;
                    coinCnt[1]++;
                    coinCnt[0]--;
                    break;
                case 20:
                    if (coinCnt[1] < 1) {
                        if (coinCnt[0] < 3) return false;
                        coinCnt[0] -= 3;
                    } else {
                        if (coinCnt[0] < 1) return false;
                        coinCnt[0]--;
                        coinCnt[1]--;
                    }
                    break;
                default:
                    break;
            }
        }

        return true;
    }
}