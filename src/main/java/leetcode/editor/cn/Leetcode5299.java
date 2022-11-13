package leetcode.editor.cn;

public class Leetcode5299 {
    public static void main(String[] args) {
        Leetcode5299 leetcode5299 = new Leetcode5299();
        System.out.println(leetcode5299.divisorSubstrings(430043, 2));
    }
    public int divisorSubstrings(int num, int k) {
        int result = 0;
        String current = num + "";
        for (int i = 0; i < current.length(); i++) {
            int end = i + k;
            if (end <= current.length()) {
                String now = current.substring(i, end);
                int start = Integer.valueOf(now);
                if (start == 0) {
                    continue;
                }
                if (num % start == 0) {
                    result++;
                }
            }
        }
        return result;
    }
}
