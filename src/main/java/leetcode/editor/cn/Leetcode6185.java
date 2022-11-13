package leetcode.editor.cn;

import java.util.Arrays;

public class Leetcode6185 {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        Arrays.sort(players);
        Arrays.sort(trainers);
        int result = 0;
        int startIndex = 0;
        for (int i = 0; i < players.length; i++) {
            while (startIndex < trainers.length && trainers[startIndex] < players[i]) {
                startIndex++;
            }
            if (startIndex >= trainers.length) {
                break;
            }
            startIndex++;
            result++;
        }
        return result;
    }
}
