package leetcode.editor.cn;

public class Leetcode6065 {
    public int largestCombination(int[] candidates) {
        int[] count = new int[32];
        int n = candidates.length;
        int result = 0;
        for (int i = 0; i < n; i++) {
            int temp = candidates[i];
            int index = 0;
            while (temp != 0) {
                if ((temp & 1) != 0) {
                    count[index]++;
                    result = Math.max(result, count[index]);
                }
                temp >>= 1;
                index++;
            }
        }
        return result;
    }
}
