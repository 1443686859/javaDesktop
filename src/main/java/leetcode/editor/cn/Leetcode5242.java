package leetcode.editor.cn;

public class Leetcode5242 {
    public String greatestLetter(String s) {
        int[] charArray = new int[26];
        int[] array = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLowerCase(s.charAt(i))) {
                charArray[s.charAt(i) - 'a']++;
            } else {
                array[s.charAt(i) - 'A']++;
            }
        }
        String result = "";
        for (int i = 0; i < 26; i++) {
            if(charArray[i] != 0 && array[i] != 0) {
                result = "" + (char)('A' + i);
            }
        }
        return  result;
    }
}
