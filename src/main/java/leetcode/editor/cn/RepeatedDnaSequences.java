//DNA序列 由一系列核苷酸组成，缩写为
// 'A', 'C', 'G' 和
// 'T'.。 
//
// 
// 例如，
// "ACGAATTCCG" 是一个 DNA序列 。 
// 
//
// 在研究 DNA 时，识别 DNA 中的重复序列非常有用。 
//
// 给定一个表示 DNA序列 的字符串 s ，返回所有在 DNA 分子中出现不止一次的 长度为 10 的序列(子字符串)。你可以按 任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
//输出：["AAAAACCCCC","CCCCCAAAAA"]
// 
//
// 示例 2： 
//
// 
//输入：s = "AAAAAAAAAAAAA"
//输出：["AAAAAAAAAA"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 10⁵ 
// s[i]=='A'、'C'、'G' or 'T' 
// 
//
// Related Topics 位运算 哈希表 字符串 滑动窗口 哈希函数 滚动哈希 👍 509 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import javax.swing.plaf.IconUIResource;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author  YourName
 * @date 2023-11-05 08:13:17
 */
public class RepeatedDnaSequences{
    public static void main(String[] args) {
        Solution solution = new RepeatedDnaSequences().new Solution();
        System.out.println(solution.findRepeatedDnaSequences("TGCTCCTGTCACAACTTCTTTACCAGCCTGTTTTTCTAGAGTCGGCTCAAAACCTGCCTTTATGCGCAGCTGTCCACGAGAATTTCATGTTATCGAGGACCGCGATATACCCAATCGCGCGCCCCAGAAAAAAGAGTCTTACCAGATGTATACGGTGACGACCCAGTGGGTAAGACCGCTCTGCTCAGCGACCCGTCCATACCCACAGTCAGCCATGTGTGACATATCAGCGTGCATTCTTGATCTGTATGGGTGCGCTGCCCCCGCACTTGATGGGGTATGTGATGACTCCGCTCGGTAAGCAAGACCCTGGGGGTTCGGACGTAGGGTATACCCGAACTTCACGTATGCGGACACCAACGCACGTGCCAATTTATCTAACGTATGTCTCCATGCCGCCCAGAAGGTTAAAGTGGACCGCCGTTCGTATACTGTTTCTGCAATTGTGTGCGGCAGCACCAGGTAGAGAGCATTCTATTTCGCTAGCTAGTAAATCTACTTCACCGAGTCTGGAAGCTCCAATCGCTGTTTACAAACTTTTTGCCCCTGCGTGGGTCAGGCCATGTCCCGTTCCCGAGGATTCTAGCACTGACCTAGCCCTATATCACGAGCCGGGTTTTCTTAAAATAGAGATCGGGACGTTAAGGTCTTATGAACGGCTTCAGCTATCTTCCGCTTACCAACTGAGCCGAACTATCTCCGGGTGTTACATGGATCCTAAAATGCTCTCCAATTTTGCCCCTGCATGGTATTTCTCTTGAGACTACTGGATCTACCTGGGTTGTGCATGTTTCGTGTCTCTTCCGACGTTCGACAATTGGGGGCGACGCTTTAAGTTCTACTACGGTGAGATGCACATCCCACGGACGCCCTTTTCCTTTGGCTCTTCCTACGTTCGCGAGCGGTCCTGTAGGACAGTTGCTTTATGCCAACTTTTACGAGGGTGGAATACAGTATCGCCATGACACTCTGAAAAAGGATGGAAGACCTGAGATTCACC"
        ));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int[] count = new int[(1 << 20) - 1];
        int temp = 0;
        char[] str = s.toCharArray();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < str.length; i++) {
            char current = str[i];
            switch (current) {
                case 'A':
                    temp = (temp << 2)| 0;
                    break;
                case 'C':
                    temp = (temp << 2)| 1;
                    break;
                case 'G':
                    temp = (temp << 2)| 2;
                    break;
                case 'T':
                    temp = (temp << 2)| 3;
                    break;
            }
            if (i >= 9) {
                if (++count[temp] == 2) {
                    ans.add(s.substring(i - 9, i + 1));
                }
                temp &= (1 << 18) - 1;
            }

        }
        return ans;
    }
    public int findChampion(int n, int[][] edges) {
        int[] in = new int[n];
        for (int[] edge : edges) {
            in[edge[1]]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (in[i] == 0) {
                result.add(i);
            }
        }
        return result.size() > 1 || result.size() == 0 ? -1 : result.get(0);
    }
    List<Integer>[] grap ;
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = values.length;
        grap = new List[n];
        Arrays.setAll(grap, e -> new ArrayList<>());
        for (int[] edge : edges) {
            grap[edge[0]].add(edge[1]);
        }
        return 0;
    }
 

}
//leetcode submit region end(Prohibit modification and deletion)

}