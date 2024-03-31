package leetcode.editor.cn;

public class Leetcode6333 {
    public int[] findColumnWidth(int[][] grid) {
        int[] result = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length;  j++) {
                result[j] = Math.max(result[j], String.valueOf(grid[i][j]).length());
            }
        }
        return result;
    }
}
