package leetcode.editor.cn;

import java.util.*;

public class Leetcode6048 {
    public int minimumCardPickup(int[] cards) {
        int[] result = new int[100001];
        Arrays.fill(result, -1);
        int minResult = Integer.MAX_VALUE;
        for (int i = 0; i < cards.length; i++) {
            if (result[cards[i]] != -1) {
                minResult = Math.min(i - result[cards[i]] + 1, minResult);
            }
            result[cards[i]] = i;
        }
        return minResult == Integer.MAX_VALUE ? -1 : minResult;
    }
}
