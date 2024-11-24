/**
一开始，你的银行账户里有 100 块钱。 

 给你一个整数purchaseAmount ，它表示你在一次购买中愿意支出的金额。 

 在一个商店里，你进行一次购买，实际支出的金额会向 最近 的 10 的 倍数 取整。换句话说，你实际会支付一个 非负 金额 roundedAmount ，满足 
roundedAmount 是 10 的倍数且 abs(roundedAmount - purchaseAmount) 的值 最小 。 

 如果存在多于一个最接近的 10 的倍数，较大的倍数 是你的实际支出金额。 

 请你返回一个整数，表示你在愿意支出金额为 purchaseAmount 块钱的前提下，购买之后剩下的余额。 

 注意： 0 也是 10 的倍数。 

 

 示例 1： 

 输入：purchaseAmount = 9
输出：90
解释：这个例子中，最接近 9 的 10 的倍数是 10 。所以你的账户余额为 100 - 10 = 90 。
 

 示例 2： 

 输入：purchaseAmount = 15
输出：80
解释：这个例子中，有 2 个最接近 15 的 10 的倍数：10 和 20，较大的数 20 是你的实际开销。
所以你的账户余额为 100 - 20 = 80 。
 

 

 提示： 

 
 0 <= purchaseAmount <= 100 
 

 👍 27 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-06-12 21:06:26
 */
public class AccountBalanceAfterRoundedPurchase{
    public static void main(String[] args) {
        Solution solution = new AccountBalanceAfterRoundedPurchase().new Solution();
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int accountBalanceAfterPurchase(int purchaseAmount) {
        int mod = purchaseAmount % 10;
        int target = (purchaseAmount / 10 + (mod >= 5 ? 1 : 0)) * 10;
        return 100 - target;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}