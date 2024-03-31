package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Leetcode6362 {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<int[]> current = new ArrayList<>();
        int index1 = 0;
        int index2 = 0;
        while (index1 < nums1.length && index2 < nums2.length) {
            if (nums1[index1][0] == nums2[index2][0]) {
                current.add(new int[]{nums1[index1][0], nums1[index1][1] + nums2[index2][1]});
                index2++;
                index1++;
            } else if (nums1[index1][0] > nums2[index2][0]) {
                current.add(nums2[index2]);
                index2++;
            } else {
                current.add(nums1[index1]);
                index1++;
            }
        }
        while (index1 < nums1.length) {
            current.add(nums1[index1]);
            index1++;
        }
        while (index2 < nums2.length) {
            current.add(nums2[index2]);
            index2++;
        }
        int[][] result = new int[current.size()][2];
        current.toArray(result);
        return result;
    }
}
