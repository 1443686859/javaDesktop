package leetcode.editor.cn;

public class Leetcode6156 {
    public static void main(String[] args) {
        Leetcode6156 leetcode6156 = new Leetcode6156();
        System.out.println(leetcode6156.minimumRecolors("WBBWWBBWBW", 7));
    }
    public int minimumRecolors(String blocks, int k) {
        int w = 0;
        int b = 0;
        int left = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < blocks.length(); i++) {
            if (blocks.charAt(i) == 'W') {
                w++;
            } else {
                b++;
            }
            if (i - left + 1 > k) {
                if (blocks.charAt(left) == 'W') {
                    w--;
                } else {
                    b--;
                }
                left++;
            }
            if (i - left + 1 == k) {
                result = Math.min(result, w);
            }
        }
        return result;
    }
}
