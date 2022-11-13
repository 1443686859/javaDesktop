package leetcode.editor.cn;

public class Leetcode6101 {
    public static void main(String[] args) {
        Leetcode6101 leetcode6101 = new Leetcode6101();
        System.out.println(leetcode6101.checkXMatrix(new int[][]{{2,0,0,1},{0,3,1,0},{0,5,2,0},{4,0,0,2}}));
    }
    public boolean checkXMatrix(int[][] grid) {
        int n = grid.length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == j || (i + j) == n - 1) {
                    if (grid[i][j] == 0) {
                        return false;
                    }
                } else {
                    if (grid[i][j] != 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
