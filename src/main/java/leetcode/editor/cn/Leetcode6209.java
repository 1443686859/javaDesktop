package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Leetcode6209 {
    public static void main(String[] args) {
        Leetcode6209 leetcode6209 = new Leetcode6209();
        leetcode6209.productQueries(508, new int[][] {{0,4},{5,6},{5,6},{0,3},{4,6},{3,3},{1,3},{5,5},{3,3},{5,5},{0,6},{4,6},{4,4},{5,5},{4,6},{2,3},{4,6},{4,4},{2,4},{3,6},{2,6},{0,6},{5,5},{2,2},{6,6},{4,4},{4,4},{6,6},{1,2},{0,1},{6,6},{0,2},{6,6},{0,4},{6,6},{0,6},{6,6},{0,4},{0,3},{1,4},{4,5},{4,5},{6,6},{3,3},{3,6},{3,3},{2,6},{3,5},{1,6},{6,6},{6,6},{0,3},{4,5},{4,4},{4,4},{1,1},{3,6},{4,4},{0,3},{2,6},{3,5},{4,6},{6,6},{2,3},{4,6},{3,5},{5,6},{1,2},{2,2},{1,3},{5,6},{4,6},{2,5},{3,6},{1,1},{1,2},{0,6},{6,6},{1,1},{2,4},{1,2},{2,5},{3,6},{4,5},{0,3},{0,5},{1,1},{2,6},{0,3},{0,0},{5,6},{5,5},{0,4}});
    }
    int mod = (int)1e9 + 7;
    public int[] productQueries(int n, int[][] queries) {

        int length = queries.length;
        List<Long> result = new ArrayList<>();
        int[] ans = new int[length];
        int temp = n;
        int index = 0;
        long tempResult = 0;
        while (temp != 0) {
            if ((temp & 1) != 0) {
                tempResult = tempResult + index;
                result.add(tempResult);
            }
            index++;
            temp >>= 1;
        }
        for (int i = 0; i < length; i++) {
            int preIndex = queries[i][0] - 1;
            int behindIndex = queries[i][1];
            if (preIndex == -1) {
                ans[i] = (int)(fastPow(2,result.get(behindIndex)) % mod) ;
            } else {
                ans[i] = (int)((fastPow(2,result.get(behindIndex) - result.get(preIndex))) % mod);
            }
        }
        return ans;
    }
    public int fastPow(int base, long n) {
        long temp = base;
        long result = 1;
        while (n != 0) {
            if ((n & 1) == 1) {
                result = (result * temp) % mod;
            }
            temp = (temp % mod * temp % mod) % mod;
            n >>= 1;
        }
        return (int)result;
    }
}
