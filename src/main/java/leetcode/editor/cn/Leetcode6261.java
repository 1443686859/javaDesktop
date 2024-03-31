package leetcode.editor.cn;

public class Leetcode6261 {
    public int maximumValue(String[] strs) {
        int max = 0;
        for (int i = 0; i < strs.length; i++) {
            max = Math.max(max ,get(strs[i]));
        }
        return max;
    }
    public int get(String current) {
        int defaultValue = current.length();
        int temp = 0;
        for (int i = 0; i < current.length(); i++) {
            if (Character.isLetter(current.charAt(i))) {
                return defaultValue;
            } else {
                temp = temp * 10 + (current.charAt(i) - '0');
            }
        }
        return  temp;
    }
}
