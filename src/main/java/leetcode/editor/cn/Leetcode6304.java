package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Leetcode6304 {
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for (int i : banned) {
            set.add(i);
        }
        int result = 0;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            if (sum + i > maxSum) {
                break;
            }
            if (!set.contains(i) && sum + i <= maxSum) {
                result++;
                sum += i;
            }
        }
        return result;
    }
}
