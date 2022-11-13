package leetcode.editor.cn;

public class Leetcode6077 {
    public static void main(String[] args) {
        Leetcode6077 leetcode6077 = new Leetcode6077();
        System.out.println(leetcode6077.totalStrength(new int[]{1,3,1,2}));
    }
    public int totalStrength(int[] strength) {
        int mod = 1000000007;
        int[] sum = new int[strength.length + 1];
        sum[0] = 0;
        for (int i = 0; i < strength.length; i++) {
            sum[i + 1] += sum[i] + strength[i];
        }
        int result = 0;
        for (int i = 0; i < strength.length; i++) {
            int maxLength = i + 1;
            int min = strength[i];
            for (int j = 0; j < maxLength; j++) {
                min = Math.min(min, strength[i - j]);
                result = (result + (min * (sum[i + 1] - sum[i - j])) % mod) % mod;
            }
        }
        return result;
    }
}
