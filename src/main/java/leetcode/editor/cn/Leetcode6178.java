package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Leetcode6178 {
    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals, (a, b) ->{
            if (a[0] != b[0]) {
                return a[0] - b[0];
            } else {
                return a[1] - b[1];
            }
        });
        int n = intervals.length;
        List<Integer>[] currentList = new List[n];
        for (int i = 0; i < n; i++) {
            currentList[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            int index = searchRight(intervals, intervals[i][1], i);
            for (int j = i + 1; j < index; i++) {
                currentList[j].add(i);
                currentList[i].add(j);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {

        }
        return 0;
    }
    public int searchRight(int[][] intervals, int target, int left) {
        int right = intervals.length - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (intervals[mid][0] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return Math.min(right + 1, intervals.length - 1);
    }

}
