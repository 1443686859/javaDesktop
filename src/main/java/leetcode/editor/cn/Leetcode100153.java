package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode100153 {
    public static void main(String[] args) {
        Leetcode100153 leetcode100153 = new Leetcode100153();
        System.out.println(leetcode100153.minimumAddedCoins(new int[]{100000}, 100000));
    }
    public int minimumAddedCoins(int[] coins, int target) {
        boolean[] count = new boolean[target + 1];
        Arrays.sort(coins);
        for (int i : coins) {
            if (i > target) {
                continue;
            }
            for (int j = 1; j < i; j ++) {
                if (count[j] && j + i <= target) {
                    count[j + i] = true;
                }
            }
            if (count[i] && 2 * i <= target) {
                count[2 * i] = true;
            }
            count[i] = true;
        }
        int left = 1;
        int result = 0;
        while (left <= target) {
            if (count[left] == false) {
                result++;
                count[left] = true;
                for (int i = target; i >= 1; i--) {
                    if (count[i] && i + left <= target) {
                        count[i + left] = true;
                    }
                }
            }
            left++;
        }
        return result;
    }
}
