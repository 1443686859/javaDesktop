package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

public class Leetcode6347 {
    public static void main(String[] args) {
        Leetcode6347 leetcode6347 = new Leetcode6347();
        System.out.println(leetcode6347.vowelStrings(new String[]{"aba","bcb","ece","aa","e"}, new int[][]{{0,2},{1,4},{1,1}}));
    }
    public int[] vowelStrings(String[] words, int[][] queries) {
        int n = words.length;
        int[] count = new int[n + 1];
        List<Character> characterList = Arrays.asList( 'a','e','i','o','u');
        for (int i = 0; i < n; i++) {
            count[i + 1] = count[i];
            if (characterList.contains(words[i].charAt(0)) && characterList.contains(words[i].charAt(words[i].length() - 1))) {
                count[i + 1] = count[i] + 1;
            }
        }
        int[] ans = new int[queries.length];
        int index = 0;
        for (int[] query : queries) {
            ans[index] = count[query[1] + 1] - count[query[0]];
            index++;
        }
        return ans;
    }
}
