//你是一位系统管理员，手里有一份文件夹列表 folder，你的任务是要删除该列表中的所有 子文件夹，并以 任意顺序 返回剩下的文件夹。 
//
// 如果文件夹 folder[i] 位于另一个文件夹 folder[j] 下，那么 folder[i] 就是 folder[j] 的 子文件夹 。 
//
// 文件夹的「路径」是由一个或多个按以下格式串联形成的字符串：'/' 后跟一个或者多个小写英文字母。 
//
// 
// 例如，"/leetcode" 和 "/leetcode/problems" 都是有效的路径，而空字符串和 "/" 不是。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
//输出：["/a","/c/d","/c/f"]
//解释："/a/b" 是 "/a" 的子文件夹，而 "/c/d/e" 是 "/c/d" 的子文件夹。
// 
//
// 示例 2： 
//
// 
//输入：folder = ["/a","/a/b/c","/a/b/d"]
//输出：["/a"]
//解释：文件夹 "/a/b/c" 和 "/a/b/d" 都会被删除，因为它们都是 "/a" 的子文件夹。
// 
//
// 示例 3： 
//
// 
//输入: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
//输出: ["/a/b/c","/a/b/ca","/a/b/d"] 
//
// 
//
// 提示： 
//
// 
// 1 <= folder.length <= 4 * 10⁴ 
// 2 <= folder[i].length <= 100 
// folder[i] 只包含小写字母和 '/' 
// folder[i] 总是以字符 '/' 起始 
// 每个文件夹名都是 唯一 的 
// 
//
// Related Topics 字典树 数组 字符串 👍 132 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.ArrayList;
import java.util.List;

/**
 * @author  YourName
 * @date 2023-02-08 20:09:04
 */
public class RemoveSubFoldersFromTheFilesystem{
    public static void main(String[] args) {
        Solution solution = new RemoveSubFoldersFromTheFilesystem().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        class Node{
            Node[] child;
            int index;
            public Node() {
                child = new Node[27];
                index = -1;
            }
        }
        Node root;
        List<Integer> indexList;
    public List<String> removeSubfolders(String[] folder) {
        root = new Node();
        for (int i = 0; i < folder.length; i++) {
            insert(folder[i], root, i);
        }
        indexList = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        dfs(root);
        for (int i : indexList) {
            ans.add(folder[i]);
        }
        return ans;
    }
    public void dfs(Node current) {
        if (current.index != -1) {
            indexList.add(current.index);
        }
        for (int i = 0; i < 27; i++) {
            if (current.child[i] != null) {
                if (i == 26 && current.index != -1) {
                    return;
                }
                dfs(current.child[i]);
            }
        }
    }
    public void insert(String current, Node root, int currentIndex) {
            Node temp = root;
            for (int i = 0; i < current.length(); i++) {
                int index = current.charAt(i) == '/' ? 26 : current.charAt(i) - 'a';
                if (index == 26 && temp.index != -1) {
                    break;
                }
                if (temp.child[index] == null) {
                    temp.child[index] = new Node();
                }
                temp = temp.child[index];
                if (i == current.length() - 1) {
                    temp.index = currentIndex;
                }
            }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}