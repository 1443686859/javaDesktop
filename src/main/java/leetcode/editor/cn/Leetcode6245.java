package leetcode.editor.cn;

public class Leetcode6245 {
    public int pivotInteger(int n) {
        if (n == 1) {
            return 1;
        }
        int total = (n + 1) * n / 2;
        for (int i = 1; i < n; i++) {
            int current = (i + 1) * i / 2;
            if (current == total - current + i) {
                return i;
            }
        }
        return - 1;
    }
}
