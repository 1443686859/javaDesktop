package leetcode.editor.cn;

public class Leetcode5229 {

    public static void main(String[] args) {
        Leetcode5229 leetcode5299 = new Leetcode5229();
        System.out.println(leetcode5299.maximumsSplicedArray(new int[]{20,40,20,70,30}, new int[]{50,20,50,40,20}));
    }
    public int maximumsSplicedArray(int[] nums1, int[] nums2) {
        int n = nums1.length;
        long[] sum1 = new long[n + 1];
        long[] sum2 = new long[n + 1];
        for (int i = 0; i < n; i++) {
            sum1[i + 1] = sum1[i] + nums1[i];
            sum2[i + 1] = sum2[i] + nums2[i];
        }
        long result = Math.max(sum1[n], sum2[n]);
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long preResult = Math.max(sum1[i], sum2[i]);
                long afterResult = Math.max(sum1[n] - sum1[j + 1], sum2[n] - sum2[j + 1]);
                long currentResult = Math.max(sum1[j + 1] - sum1[i], sum2[j + 1] - sum2[i]);
                result = Math.max(result, preResult + afterResult + currentResult);
            }
        }
        return (int)result;
    }
}
