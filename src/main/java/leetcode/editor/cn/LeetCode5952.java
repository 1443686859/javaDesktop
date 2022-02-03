package leetcode.editor.cn;

public class LeetCode5952 {
    public static void main(String[] args) {
        LeetCode5952 soulution = new LeetCode5952();
        System.out.println(soulution.countPoints("B0B6G0R6R0R6G9"));
    }
    public int countPoints(String rings) {
        int n = rings.length() / 2;
        int[][] result = new int[10][3];
        for (int i = 0 ; i < n; i++) {
            char color = rings.charAt(2 * i);
            int location = rings.charAt(2 * i + 1) - '0';
            if (color == 'R') {
                result[location][0] ++;
            } else if (color == 'G') {
                result[location][1] ++;
            } else {
                result[location][2]++;
            }
        }
        int count = 0;
        for (int i = 0; i < 10; i++) {
            if (result[i][0] > 0 && result[i][1] > 0 && result[i][2] > 0) {
                count++;
            }
        }
        return count;
    }
}
