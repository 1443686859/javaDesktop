package leetcode.editor.cn;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Leetcode6403 {
    public static void main(String[] args) {
        Leetcode6403 leetcode6403 = new Leetcode6403();
        System.out.println(leetcode6403.findMaxFish(new int[][]{{0,2,1,0},{4,0,0,3},{1,0,0,4},{0,3,2,0}}));
    }
    int[][] directions = new int[][]{{0,1}, {0, -1}, {-1, 0}, {1, 0}};
    public int findMaxFish(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] != 0) {
                    boolean[][] visted = new boolean[grid.length][grid[0].length];
                    max = Math.max(max, getMax(grid, new int[]{i, j}, visted));
                }
            }
        }
        return max;
    }


    public int getMax(int[][] grid, int[] current, boolean[][] visited) {
        if (current[0] < 0 || current[0] >= grid.length || current[1] < 0 || current[1] >= grid[0].length || visited[current[0]][current[1]] || grid[current[0]][current[1]] == 0) {
            return 0;
        }
        visited[current[0]][current[1]] = true;
        int currentMax = grid[current[0]][current[1]];
        for (int[] direction : directions) {
            int nx = current[0] + direction[0];
            int ny = current[1] + direction[1];
            currentMax += getMax(grid, new int[]{nx, ny}, visited);
        }
        return currentMax;
    }


}
