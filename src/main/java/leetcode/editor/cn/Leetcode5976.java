package leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class Leetcode5976 {
    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n; i++) {
            Set<Integer> currentRow = new HashSet<>();
            Set<Integer> currentCol = new HashSet<>();
            for (int j = 0; j < n; j++) {
                currentRow.add(matrix[i][j]);
                currentCol.add(matrix[j][i]);
            }
            if (currentRow.size() != n) {
                return false;
            }
            if (currentCol.size() != n) {
                return false;
            }
        }
        return true;
    }
}
