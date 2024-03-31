package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode6257 {
    public int deleteGreatestValue(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            Arrays.sort(grid[i]);
        }
        int result = 0;

        for (int j = grid[0].length - 1; j >=0; j--) {
            int max = 0;
            for (int i = 0; i < grid.length; i++) {
                max = Math.max(max, grid[i][j]);
            }
            result += max;
        }
        return result;
    }
}
