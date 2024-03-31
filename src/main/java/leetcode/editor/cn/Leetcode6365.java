package leetcode.editor.cn;

public class Leetcode6365 {
    public int minOperations(int n) {
        int temp = 0;
        int min = Integer.bitCount(n);
        while ((n & (n - 1)) != 0) {
            n = n + (n & - n);
            temp++;
            min = Math.min(min, Integer.bitCount(n) + temp);
        }
        return min;
    }
}
