package leetcode.editor.cn;

public class Leetcode6425 {
    public static void main(String[] args) {
        Leetcode6425 leetcode6425 = new Leetcode6425();
        System.out.println(leetcode6425.longestSemiRepetitiveSubstring("52233"));
        System.out.println();
    }

        public int longestSemiRepetitiveSubstring(String s) {
            int n = s.length();
            int[] count = new int[n ];
            for (int i = 1; i < n; i++) {
                count[i] = count[i - 1] + (s.charAt(i - 1) == s.charAt(i) ? 1 :0);
            }
            int max = 1;
            for (int i = 0; i < n; i++) {
                int target = count[i] - 1;
                int left = 0;
                int right = i;
                while (left <= right) {
                    int mid = (left + right) / 2;
                    if (count[mid] >= target) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                max = Math.max(max, i - right);
            }
            return max;
        }

}
