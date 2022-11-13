package leetcode.editor.cn;

public class Leetcode6192 {
    public int commonFactors(int a, int b) {
        int max = gcd(a, b);
        int count = 0;
        for (int i = 1; i <= max; i++) {
            if (a % i == 0 && b % i == 0) {
                count++;
            }
        }
        return count;
    }
    public int gcd(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        if (max % min == 0) {
            return min;
        }
        return gcd(min, max - min);
    }
}
