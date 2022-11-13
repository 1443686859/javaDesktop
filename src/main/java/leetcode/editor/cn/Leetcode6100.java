package leetcode.editor.cn;

public class Leetcode6100 {
    public static void main(String[] args) {
        Leetcode6100 leetcode6100 = new Leetcode6100();
        System.out.println(leetcode6100.countHousePlacements(1000));
    }
    long MOD = (int)(1e9 + 7);
    public int countHousePlacements(int n) {
        long[][] f = new long[n][2];
        f[0][1] = 1;
        f[0][0] = 1;
        for (int i = 1; i < n; i++) {
            f[i][0] = (f[i - 1][0] + f[i - 1][1]) % MOD;
            f[i][1] = f[i - 1][0] % MOD ;
        }
        int result = (int)((f[n - 1][0] + f[n - 1][1]) % MOD);
        return (int) ((result  % MOD * result % MOD) % MOD);
    }
}
