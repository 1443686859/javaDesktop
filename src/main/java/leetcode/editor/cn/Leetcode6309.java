package leetcode.editor.cn;

public class Leetcode6309 {
    public static void main(String[] args) {
        Leetcode6309 leetcode6309 = new Leetcode6309();
        System.out.println(leetcode6309.findValidSplit(new int[]{557663,280817,472963,156253,273349,884803,756869,763183,557663,964357,821411,887849,891133,453379,464279,574373,852749,15031,156253,360169,526159,410203,6101,954851,860599,802573,971693,279173,134243,187367,896953,665011,277747,439441,225683,555143,496303,290317,652033,713311,230107,770047,308323,319607,772907,627217,119311,922463,119311,641131,922463,404773,728417,948281,612373,857707,990589,12739,9127,857963,53113,956003,363397,768613,47981,466027,981569,41597,87149,55021,600883,111953,119083,471871,125641,922463,562577,269069,806999,981073,857707,831587,149351,996461,432457,10903,921091,119083,72671,843289,567323,317003,802129,612373}));
    }
    public int findValidSplit(int[] nums) {
        int n = nums.length;
        int[] maxRight = new int[n];
        for (int i = 0; i < n; i++) {
            int max = i;
            for (int j = i + 1; j < n; j++) {
                if (gcd(nums[i], nums[j]) != 1) {
                    max = Math.max(max, j);
                }
            }
            maxRight[i] = max;
        }
        int right = 0;
        for (int i = 0; i < n; i++) {
            right = Math.max(right, maxRight[i]);
            if (i == right) {
                return i;
            }
            if (right >= n - 1) {
                return -1;
            }
        }
        return -1;
    }
    public long gcd(long a, long b) {
        return a == 0 ? b : gcd(b % a, a);
    }
}
