package leetcode.editor.cn;

public class Leetcode6028 {
    public static void main(String[] args) {
        Leetcode6028 leetCode6028 = new Leetcode6028();
        System.out.println(leetCode6028.countCollisions("SSRSSRLLRSLLRSRSSRLRRRRLLRRLSSRR"));
    }
    public int countCollisions(String directions) {
        int result = 0;
        char[] current = directions.toCharArray();
        int n = directions.length();
        for (int i = 0; i < n; i++) {
            if (current[i] == 'R') {
                int end = i + 1;
                while (end < n && current[end] == 'R') {
                    end ++;
                }
                if (end < n) {
                    if (current[end] == 'L') {
                        result += end - i + 1;
                    }
                    if (current[end] == 'S') {
                        result += end - i;
                    }
                    int start = i ;
                    while (start <= end) {
                        current[start] = 'S';
                        start++;
                    }
                }
            }
            if (current[i] == 'L') {
                if (i > 0 && (current[i - 1] == 'R' || current[i - 1] == 'S')) {
                    current[i] = 'S';
                    result ++;
                    if (current[i - 1] == 'R') {
                        current[i - 1] = 'S';
                        result++;
                    }
                }
            }
        }
        return result;
    }
}
