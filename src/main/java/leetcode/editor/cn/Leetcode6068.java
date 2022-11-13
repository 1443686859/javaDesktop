package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode6068 {
    public static void main(String[] args) {
        Leetcode6068 leetcode6068 = new Leetcode6068();
        System.out.println(leetcode6068.maximumWhiteTiles(new int[][]{{10,11}, {1,1}}, 2));
    }
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (a, b) -> {
            return a[0] - b[0];
        });
        int n = tiles.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int tempResult = 0;
            int tempLength = tiles[i][1] - tiles[i][0] + 1;
            if (carpetLen <= tempLength) {
                return carpetLen;
            }
            int resLength = carpetLen - tempLength;
            tempResult += tempLength;
            int prev = i;
            for (int j = i + 1; j < n; j++) {
                
            }
        }
        return result;
    }
}
