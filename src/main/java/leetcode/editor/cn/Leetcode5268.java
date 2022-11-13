package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Leetcode5268 {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        int[] prev = new int[2001];
        int[] after = new int[2001];
        for (int i = 0; i < nums1.length; i++) {
            prev[nums1[i] + 1000] ++;
        }
        for (int i = 0; i < nums2.length; i++) {
            after[nums2[i] + 1000] ++;
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> prevResult = new ArrayList<>();
        List<Integer> afterResult = new ArrayList<>();
        for (int i = 0; i < 2001; i++) {
            if (prev[i] != 0 && after[i] == 0) {
                prevResult.add(i - 1000);
            }
            if (prev[i] == 0 && after[i] != 0) {
                afterResult.add(i - 1000);
            }
        }
        result.add(prevResult);
        result.add(afterResult);
        return result;
    }
}
