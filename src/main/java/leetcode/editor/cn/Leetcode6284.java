package leetcode.editor.cn;

public class Leetcode6284 {
    public static void main(String[] args) {
        Leetcode6284 l = new Leetcode6284();

    }
    public boolean isItPossible(String word1, String word2) {
        int count1 = 0;
        int count2 = 0;
        if (word1.length() == 0 || word2.length() == 0) {
            return false;
        }
        if (word1.equals(word2)) {
            return true;
        }
        int[] word1Count = new int[26];
        int[] word2Count = new int[26];
        for (Character character : word1.toCharArray()) {
            if (word1Count[character - 'a'] == 0) {
                count1++;
            }
            word1Count[character - 'a']++;
        }
        for (Character character : word2.toCharArray()) {
            if (word2Count[character - 'a'] == 0) {
                count2++;
            }
            word2Count[character - 'a']++;
        }
        if (Math.abs(count2 - count1) > 2) {
            return false;
        }
        if (count1 == count2) {
            int pre = -1;
            for (int i = 0; i < 26; i++) {
                if (word1Count[i] != 0 && word2Count[i] == 0) {
                    pre = i;
                    int tempCount1 = count1;
                    if (word1Count[pre] - 1 == 0) {
                        tempCount1--;
                    }
                    for (int j = 0; j < 26; j ++) {
                        if (word2Count[j] > 0 && j != pre && word1Count[j] == 0) {
                            int tempCount2 = count2;
                            if (word2Count[j] - 1 == 0) {
                                tempCount2--;
                            }
                            if (tempCount1 == tempCount2) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        if (Math.abs(count2 - count1) >= 1) {
            int[] max = count2 > count1 ? word2Count : word1Count;
            int[] min = count2 > count1 ? word1Count : word2Count;
            int pre = -1;
            for (int i = 0; i < 26; i++)  {
                if (max[i] >= 1 && min[i] == 0) {
                    pre = i;
                    int tempCount1 = Math.max(count2, count1);
                    if (max[pre] - 1 == 0) {
                        tempCount1--;
                    }
                    int tempCount2 = Math.min(count2, count1) + 1;
                    for (int j = 0; j < 26; j ++) {
                        int preCount = tempCount1;
                        int afterCount = tempCount2;
                        if (min[j] >= 1 && j != pre) {
                            if (max[j] == 0) {
                                preCount++;
                            }
                            if (min[j] - 1 == 0) {
                                afterCount --;
                            }
                            if (preCount == afterCount) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
