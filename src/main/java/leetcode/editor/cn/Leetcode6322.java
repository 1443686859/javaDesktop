package leetcode.editor.cn;

public class Leetcode6322 {
    public static void main(String[] args) {
        Leetcode6322 leetcode6322 = new Leetcode6322();
        System.out.println(leetcode6322.checkValidGrid(new int[][]{
                {0,11,16,5,20},{17,4,19,10,15},{12,1,8,21,6},{3,18,23,14,9},{24,13,2,7,22}
        }));
    }
    int[][] directions = new int[][]{
            {1, 2}, {-1, 2}, {1,-2}, {-1,-2},{2,1}, {2, -1}, {-2, 1}, {-2 , -1}
    };
    public boolean checkValidGrid(int[][] grid) {
        return dfs(grid, new int[2], 0);
    }
    public boolean dfs(int[][] grid, int[] start, int target) {
        if (target == grid.length * grid.length) {
            return true;
        }
        if (target != grid[start[0]][start[1]]) {
            return false;
        }
        boolean result = false;
        for (int[] direction : directions) {
            int[] current = new int[2];
            current[0] = start[0];
            current[1] = start[1];
            current[0] += direction[0];
            current[1] += direction[1];
            if (current[0] >= 0 && current[0] < grid.length && current[1] >= 0 && current[1] < grid.length) {
                result |= dfs(grid, current, target +1 );
            }
        }
        return result;
    }
}
