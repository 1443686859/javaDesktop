package leetcode.editor.cn;

public class Leetcode6125 {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n ; j++) {
                int index = 0;
                boolean equal = true;
                while (index < n) {
                    if (grid[i][index] != grid[index][j]) {
                        equal = false;
                        break;
                    }
                    index++;
                }
                if (equal) {
                    result++;
                }
            }

        }
        return result;
    }
}
