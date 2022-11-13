package leetcode.editor.cn;

public class Leetcode6128 {
    public String bestHand(int[] ranks, char[] suits) {
        String[] count = new String[]{"Flush", "Three of a Kind","Pair","High Card"};
        boolean color = true;
        for (int i = 1; i < suits.length; i++) {
            if (suits[i - 1] != suits[i]) {
                color = false;
            }
        }
        if (color) {
            return count[0];
        }
        int[] countNum = new int[14];
        boolean three = false;
        boolean two = false;
        for (int i = 0; i < ranks.length; i++) {
            countNum[ranks[i]]++;
            if (countNum[ranks[i]] >= 2) {
                two = true;
            }
            if (countNum[ranks[i]] >= 3) {
                three = true;
            }
        }
        if (three) {
            return count[1];
        } else if (two) {
            return count[2];
        } else {
            return count[3];
        }
    }
}
