package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Leetcode100030 {
    public static void main(String[] args) {
        Leetcode100030 leetcode100030 = new Leetcode100030();
        System.out.println(leetcode100030.minimumMoves(new int[][]{
                {1,1,0},{1,1,1},{1,2,1}
        }));
    }
    int result;
    List<int[]> list;
    List<Integer> noZeroList;
    int[][] gridA;

    public int minimumMoves(int[][] grid) {
        result = Integer.MAX_VALUE;
        gridA = grid;
         list = new ArrayList<>();
        noZeroList= new ArrayList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    list.add(new int[]{i,j});
                } else {
                    if (grid[i][j] != 1) {
                        noZeroList.add(i * 3 + j);
                    }
                }
            }
        }
        if (list.isEmpty()) {
            return 0;
        }
        dfs(0, 0, 0);
        return result;
    }
    public void dfs(int mask, int index, int currentResult) {
        if (index == noZeroList.size()) {
            result = Math.min(result, currentResult);
            return ;
        }
        int current = noZeroList.get(index);
        int x = current /3;
        int y = current % 3;
        int maxCount = gridA[x][y] - 1;
        int start = 1 << maxCount;
        start--;
        for (int i = start; i < (1 << list.size()); i++) {
            if (Integer.bitCount(i) == maxCount && (i & mask) == 0) {
                int total = 0;
                for (int j = 0; j < list.size(); j++) {
                    if (((i >> j) & 1) == 1) {
                        total += Math.abs(list.get(j)[0] - x) + Math.abs(list.get(j)[1] - y);
                    }
                }
                dfs(mask | i, index + 1, currentResult + total);
            }
        }
    }
}
