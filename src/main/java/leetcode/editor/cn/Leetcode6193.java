package leetcode.editor.cn;

public class Leetcode6193 {
    public static void main(String[] args) {
        Leetcode6193  leetcode6193 = new Leetcode6193();
        System.out.println(leetcode6193.maxSum(new int[][]{
                {6,2,1,3},{4,2,1,5},{9,2,8,7}, {4,1,2,9}
        }));
    }
    public int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n];
        for (int i = 0; i < m; i++) {
            sum[i][0]= grid[i][0];
            for (int j = 1; j < n; j++) {
                sum[i][j] = sum[i][j - 1] + grid[i][j];
            }
        }
        int i = 0;
        int max = 0;
        while (i + 2 < m) {
            int j = 0;
            while (j + 2 < n) {
                int temp = 0;
                for (int start = i; start <= i + 2; start++) {
                    temp += sum[start][j + 2] - (j == 0 ? 0 : sum[start][j - 1]);
                }
                temp -= grid[i + 1][j] + grid[i + 1][j + 2];
                max = Math.max(max, temp);
                j++;
            }
            i++;
        }
        return max;
    }
}
