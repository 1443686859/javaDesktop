package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Leetcode6031 {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        int maxIndex = -1;
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                int startIndex = Math.max(i - k, maxIndex + 1);
                int endIndex = Math.min(nums.length - 1, i + k);
                maxIndex = endIndex;
                for (int start = startIndex; start <= endIndex; start++) {
                    resultList.add(start);
                }
            }
        }
        return resultList;
    }
}
