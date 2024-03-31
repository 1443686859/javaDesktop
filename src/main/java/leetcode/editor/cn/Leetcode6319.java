package leetcode.editor.cn;

public class Leetcode6319 {
    public int[] evenOddBit(int n) {
        int[] result = new int[2];
        int index = 0;
        while (n != 0) {
            if ((n & 1) != 0) {
                result[index & 1]++;
            }
            n >>= 1;
            index++;
        }
        return result;
    }
}
