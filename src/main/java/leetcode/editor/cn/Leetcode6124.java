package leetcode.editor.cn;

public class Leetcode6124 {
    public char repeatedCharacter(String s) {
        int[] array = new int[26];
        char ans = 'a';
        for (int i = 0; i < s.length(); i++) {
            array[s.charAt(i) - 'a']++;
            if (array[s.charAt(i) - 'a'] == 2) {
                ans = s.charAt(i);
                break;
            }
        }
        return ans;
    }
}
