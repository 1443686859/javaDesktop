package leetcode.editor.cn;

import java.util.Collection;
import java.util.TreeMap;

public class Leetcode6198 {
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        int[] nums = new int[nums2.length];
        long result = 0;
        TreeMap<Integer, Integer> countMap = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums1[i] - nums2[i];
            Collection<Integer> current = countMap.headMap(nums[i], true).values();
            for (Integer c : current) {
                result += c;
            }
            countMap.put(nums[i] - diff, countMap.getOrDefault(nums[i] - diff, 0) + 1);
        }
        return result;
    }
}
