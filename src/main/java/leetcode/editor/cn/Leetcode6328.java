package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class Leetcode6328 {
    public static void main(String[] args) {
        Leetcode6328 leetcode6328 = new Leetcode6328();
        System.out.println(leetcode6328.maximumCostSubstring("adaa", "d", new int[]{-1000}));
    }
    public int maximumCostSubstring(String s, String chars, int[] vals) {
        Map<Character, Integer> valueMap = new HashMap<>();
        for (int i = 0; i < chars.length(); i++) {
            valueMap.put(chars.charAt(i), vals[i]);
        }
        int[] preSum = new int[s.length() + 1];
        int result = 0;
        int ans = 0;
        int min = 0;
        for (int i = 0; i < s.length(); i++) {
            result += valueMap.getOrDefault(s.charAt(i), s.charAt(i) - 'a' + 1);
            preSum[i + 1] = result;
            ans = Math.max(ans, result - min);
            min = Math.min(min, result);
        }

        return ans;
    }
}
