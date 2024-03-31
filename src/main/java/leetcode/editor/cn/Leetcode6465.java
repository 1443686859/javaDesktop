package leetcode.editor.cn;

public class Leetcode6465 {
    public static void main(String[] args) {
        Leetcode6465 leetcode6465 = new Leetcode6465();
        System.out.println(leetcode6465.smallestString("cbabc"));
    }
    public String smallestString(String s) {
        char[] current = s.toCharArray();
        int count = 0;
        boolean start = false;
        for (int i = 0; i < current.length; i++) {
            char c = changet(current[i]);
            if (current[i] == 'a') {
                count++;
            }
            if (c > current[i] && start) {
                break;
            } else if (c < current[i]) {
                current[i] = c;
                start = true;
            }
        }
        if (count == current.length) {
            return s.substring(0, count - 1) + changet('a');
        }
        return new String(current);
    }
    public char changet(char c) {
        return (char)('a' + (c - 'a' - 1 + 26) % 26);
    }
}
