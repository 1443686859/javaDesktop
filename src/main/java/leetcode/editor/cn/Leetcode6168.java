package leetcode.editor.cn;

public class Leetcode6168 {
    public static void main(String[] args) {
        Leetcode6168 leetcode6168 = new Leetcode6168();
        System.out.println(leetcode6168.numberOfWays(272,
                270,
                6));
    }
    public int numberOfWays(int startPos, int endPos, int k) {
        long mod = (long)(10e9 + 7);
        int distance = Math.abs(endPos - startPos);
        if (k < distance) {
            return 0;
        }
        if (k == distance) {
            return 1;
        }

        int count = k / distance;
        int result = 0;
        for (int i = 1; i <= count; i++) {
            int last = k - i * distance;
            if ((i & 1) == 1) {
                if ((last & 1) == 1) {
                    continue;
                }
                if (last == 0)  {
                    result = (int)((result + 1) % mod);
                } else {
                    last /= 2;
                    result = (int)((result % mod + last % mod) % mod);
                }
            }

        }
        return result;
    }
}
