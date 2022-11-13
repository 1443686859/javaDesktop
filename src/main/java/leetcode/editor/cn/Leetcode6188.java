package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Leetcode6188 {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        int[][] sort = new int[n][2];
        for (int i = 0; i < n; i++) {
            sort[i][0] = heights[i];
            sort[i][1] = i;
        }
        Arrays.sort(sort, (a, b) -> {
            return b[0] - a[0];
        });
        String[] newResult = new String[n];
        for (int i = 0; i < n; i++) {
            newResult[i] = names[sort[i][1]];
        }
        return newResult;
    }
}
