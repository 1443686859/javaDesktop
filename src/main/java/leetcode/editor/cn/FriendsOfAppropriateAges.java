/**
在社交媒体网站上有 n 个用户。给你一个整数数组 ages ，其中 ages[i] 是第 i 个用户的年龄。 

 如果下述任意一个条件为真，那么用户 x 将不会向用户 y（x != y）发送好友请求： 

 
 ages[y] <= 0.5 * ages[x] + 7 
 ages[y] > ages[x] 
 ages[y] > 100 && ages[x] < 100 
 

 否则，x 将会向 y 发送一条好友请求。 

 注意，如果 x 向 y 发送一条好友请求，y 不必也向 x 发送一条好友请求。另外，用户不会向自己发送好友请求。 

 返回在该社交媒体网站上产生的好友请求总数。 

 

 示例 1： 

 
输入：ages = [16,16]
输出：2
解释：2 人互发好友请求。
 

 示例 2： 

 
输入：ages = [16,17,18]
输出：2
解释：产生的好友请求为 17 -> 16 ，18 -> 17 。
 

 示例 3： 

 
输入：ages = [20,30,100,110,120]
输出：3
解释：产生的好友请求为 110 -> 100 ，120 -> 110 ，120 -> 100 。
 

 

 提示： 

 
 n == ages.length 
 1 <= n <= 2 * 10⁴ 
 1 <= ages[i] <= 120 
 

 👍 239 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;


/**
 * @author  YourName
 * @date 2024-11-17 15:47:01
 */
public class FriendsOfAppropriateAges{
    public static void main(String[] args) {
        Solution solution = new FriendsOfAppropriateAges().new Solution();
        System.out.println(solution.numFriendRequests(new int[]{73,106,39,6,26,15,30,100,71,35,46,112,6,60,110}));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numFriendRequests(int[] ages) {
        int[] count = new int[121];
        int result = 0;
        int c = 0;
        for (int i = 0; i < ages.length; i++) {
            count[ages[i]]++;
        }
        int left = 0;
        for (int i = 0; i < count.length; i++) {
            c += count[i];
            if (left * 2 <= i + 14) {
                c -= count[left];
                left++;
            }
            if (c > 0) {
                result += c * count[i] - count[i];
            }
        }
        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}