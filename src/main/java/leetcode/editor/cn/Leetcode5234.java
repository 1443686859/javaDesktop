package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Leetcode5234 {
    public List<String> removeAnagrams(String[] words) {
        List<String> word = new ArrayList<>();
        word.add(words[0]);
        for (int i = 1; i < words.length; i++) {
            if (!compare(get(words[i - 1]), get(words[i]))) {
                word.add(words[i]);
            }
        }
        return word;
    }
    public int[] get(String word) {
        int[] chars = new int[26];
        for (int i = 0; i < word.length(); i++) {
            chars[word.charAt(i) - 'a']++;
        }
        return chars;
    }
    public boolean compare(int[] one, int[] two) {
        for (int i = 0; i < 26; i++) {
            if (one[i] != two[i]) {
                return false;
            }
        }
        return true;
    }
}
