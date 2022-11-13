package leetcode.editor.cn;

public class Leetcode5203 {
    public int digArtifacts(int n, int[][] artifacts, int[][] dig) {
        boolean[][] digged =  new boolean[n][n];
        for (int[] digs : dig) {
            digged[digs[0]][digs[1]] = true;
        }
        int result = 0;
        for (int[] artifact : artifacts) {
            int[] start = new int[]{artifact[0], artifact[1]};
            int[] end = new int[]{artifact[2],artifact[3]};
            boolean isDigged = true;
            for (int i = start[0]; i <= end[0]; i++) {
                for (int j = start[1]; j <= end[1];j ++) {
                    if (digged[i][j] == false) {
                        isDigged = false;
                        break;
                    }
                }
                if (!isDigged) {
                    break;
                }
            }
            if (isDigged) {
                result++;
            }
        }
        return result;
    }
}
