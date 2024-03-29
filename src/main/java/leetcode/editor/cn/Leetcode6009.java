package leetcode.editor.cn;

public class Leetcode6009 {
    public int minSteps(String s, String t) {
        int[] sArray = new int[26];
        int[] tArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sArray[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            tArray[t.charAt(i) - 'a']++;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            count += Math.abs(sArray[i] - tArray[i]);
        }
        return count;
    }
}
