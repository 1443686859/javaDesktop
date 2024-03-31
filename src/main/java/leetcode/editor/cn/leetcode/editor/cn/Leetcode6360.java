package leetcode.editor.cn.leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

public class Leetcode6360 {
    public long[] distance(int[] nums) {
        Map<Long, Long> countMap = new HashMap<>();
        Map<Long, Long> indexMap = new HashMap<>();
        int n = nums.length;
        long[] result = new  long[n];
        for (int i = 0; i < n; i++) {
            long current = nums[i];
            long currentResult = countMap.getOrDefault(current, 0l) * i - indexMap.getOrDefault(current, 0l);
            result[i] += currentResult;
            countMap.put(current, countMap.getOrDefault(current, 0l) + 1);
            indexMap.put(current, indexMap.getOrDefault(current, 0l) + i);
        }
        countMap.clear();
        indexMap.clear();
        for (int i = n - 1; i >= 0; i--) {
            long current = nums[i];
            long currentResult = indexMap.getOrDefault(current, 0l) - countMap.getOrDefault(current, 0l) * i;
            result[i] += currentResult;
            countMap.put(current, countMap.getOrDefault(current, 0l) + 1);
            indexMap.put(current, indexMap.getOrDefault(current, 0l) + i);
        }
        return result;
    }
}
