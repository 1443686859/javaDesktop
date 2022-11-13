package leetcode.editor.cn;

public class Leetcode6109 {
    int mod = (int)1e9 + 7;
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        long[] result = new long[n + 1];
        result[1] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = i + delay; j <= Math.min(n ,i + forget - 1); j++) {
                result[j] =  (result[j] + result[i]) % mod;
            }
        }
        long ans = 0;
        for (int i = n - forget + 1; i <= n; i++) {
            ans = (ans +result[i]) % mod;
        }
        return (int)ans;
    }
}
