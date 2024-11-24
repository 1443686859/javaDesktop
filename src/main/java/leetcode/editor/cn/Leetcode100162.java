package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Leetcode100162 {
    public int maxFrequencyElements(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : nums) {
            countMap.merge(i, 1, Integer::sum);
        }
        int max = 0;
        int maxCount = 0;
        for (int i : nums) {
            int value = countMap.get(i);
            if (maxCount < value) {
               max = 1;
               maxCount = value;
            }  else if (maxCount == value) {
                max++;
            }
        }
        return max;
    }
}
