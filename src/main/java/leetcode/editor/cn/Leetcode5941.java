package leetcode.editor.cn;

import java.util.*;

public class Leetcode5941 {
    public static void main(String[] args) {
        Leetcode5941 solution = new Leetcode5941();
        System.out.println(solution.findAllPeople(4, new int[][]{
                {0,2,1},{1,3,1},{4,5,1}
        }, 3));
    }
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });
        Set<Integer> resultList = new HashSet<>();
        resultList.add(0);
        resultList.add(firstPerson);
        int lastTime = meetings[0][2];
        int currentTime = lastTime;
        Set<Integer> temp = new HashSet<>();
        for (int i = 0; i < meetings.length; i++) {
            currentTime = meetings[i][2];
            if (currentTime != lastTime) {
                lastTime = currentTime;
            } else {

            }
            if (resultList.contains(meetings[i][0]) || resultList.contains(meetings[i][1])) {
                resultList.add(meetings[i][0]);
                resultList.add(meetings[i][1]);
            }
        }
        return new ArrayList<>(resultList);
    }
}
