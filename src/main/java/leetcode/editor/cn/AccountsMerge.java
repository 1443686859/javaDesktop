/**
给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元
素是 emails 表示该账户的邮箱地址。 

 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们
可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。 

 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是 按字符 ASCII 顺序排列 的邮箱地址。账户本身可以以 任意顺序 返回。 

 

 示例 1： 

 
输入：accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", 
"johnnybravo@mail.com"], ["John", "johnsmith@mail.com", "john_newyork@mail.com"], [
"Mary", "mary@mail.com"]]
输出：[["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'], 
 ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
解释：
第一个和第三个 John 是同一个人，因为他们有共同的邮箱地址 "johnsmith@mail.com"。 
第二个 John 和 Mary 是不同的人，因为他们的邮箱地址没有被其他帐户使用。
可以以任何顺序返回这些列表，例如答案 [['Mary'，'mary@mail.com']，['John'，'johnnybravo@mail.com']，
['John'，'john00@mail.com'，'john_newyork@mail.com'，'johnsmith@mail.com']] 也是正确的。
 

 示例 2： 

 
输入：accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@
m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@
m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co",
"Fern1@m.co","Fern0@m.co"]]
输出：[["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co",
"Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],[
"Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.
co","Fern5@m.co"]]
 

 

 提示： 

 
 1 <= accounts.length <= 1000 
 2 <= accounts[i].length <= 10 
 1 <= accounts[i][j].length <= 30 
 accounts[i][0] 由英文字母组成 
 accounts[i][j] (for j > 0) 是有效的邮箱地址 
 

 👍 519 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.*;

/**
 * @author  YourName
 * @date 2024-07-15 20:56:48
 */
public class AccountsMerge{
    public static void main(String[] args) {
        Solution solution = new AccountsMerge().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, List<Integer>> emailToIdx = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            for (int k = 1; k < accounts.get(i).size(); k++) {
                emailToIdx.computeIfAbsent(accounts.get(i).get(k), x -> new ArrayList<>()).add(i);
            }
        }

        List<List<String>> ans = new ArrayList<>();
        boolean[] vis = new boolean[accounts.size()];
        Set<String> emailSet = new HashSet<>(); // 用于收集 DFS 中访问到的邮箱地址
        for (int i = 0; i < accounts.size(); i++) {
            if (vis[i]) {
                continue;
            }
            emailSet.clear();
            dfs(i, accounts, emailToIdx, vis, emailSet);

            List<String> res = new ArrayList<>(emailSet);
            Collections.sort(res);
            res.add(0, accounts.get(i).get(0));

            ans.add(res);
        }
        return ans;
    }

    private void dfs(int i, List<List<String>> accounts, Map<String, List<Integer>> emailToIdx, boolean[] vis, Set<String> emailSet) {
        vis[i] = true;
        for (int k = 1; k < accounts.get(i).size(); k++) {
            String email = accounts.get(i).get(k);
            if (emailSet.contains(email)) {
                continue;
            }
            emailSet.add(email);
            for (int j : emailToIdx.get(email)) { // 遍历所有包含该邮箱地址的账户下标 j
                if (!vis[j]) { // j 没有访问过
                    dfs(j, accounts, emailToIdx, vis, emailSet);
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}