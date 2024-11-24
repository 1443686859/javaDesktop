/**
一个音乐会总共有 n 排座位，编号从 0 到 n - 1 ，每一排有 m 个座椅，编号为 0 到 m - 1 。你需要设计一个买票系统，针对以下情况进行座位安排
： 

 
 同一组的 k 位观众坐在 同一排座位，且座位连续 。 
 k 位观众中 每一位 都有座位坐，但他们 不一定 坐在一起。 
 

 由于观众非常挑剔，所以： 

 
 只有当一个组里所有成员座位的排数都 小于等于 maxRow ，这个组才能订座位。每一组的 maxRow 可能 不同 。 
 如果有多排座位可以选择，优先选择 最小 的排数。如果同一排中有多个座位可以坐，优先选择号码 最小 的。 
 

 请你实现 BookMyShow 类： 

 
 BookMyShow(int n, int m) ，初始化对象，n 是排数，m 是每一排的座位数。 
 int[] gather(int k, int maxRow) 返回长度为 2 的数组，表示 k 个成员中 第一个座位 的排数和座位编号，这 k 位成员必须坐
在 同一排座位，且座位连续 。换言之，返回最小可能的 r 和 c 满足第 r 排中 [c, c + k - 1] 的座位都是空的，且 r <= maxRow 。
如果 无法 安排座位，返回 [] 。 
 boolean scatter(int k, int maxRow) 如果组里所有 k 个成员 不一定 要坐在一起的前提下，都能在第 0 排到第 
maxRow 排之间找到座位，那么请返回 true 。这种情况下，每个成员都优先找排数 最小 ，然后是座位编号最小的座位。如果不能安排所有 k 个成员的座位，请返回 
false 。 
 

 

 示例 1： 

 
输入：
["BookMyShow", "gather", "gather", "scatter", "scatter"]
[[2, 5], [4, 0], [2, 0], [5, 1], [5, 1]]
输出：
[null, [0, 0], [], true, false]

解释：
BookMyShow bms = new BookMyShow(2, 5); // 总共有 2 排，每排 5 个座位。
bms.gather(4, 0); // 返回 [0, 0]
                  // 这一组安排第 0 排 [0, 3] 的座位。
bms.gather(2, 0); // 返回 []
                  // 第 0 排只剩下 1 个座位。
                  // 所以无法安排 2 个连续座位。
bms.scatter(5, 1); // 返回 True
                   // 这一组安排第 0 排第 4 个座位和第 1 排 [0, 3] 的座位。
bms.scatter(5, 1); // 返回 False
                   // 总共只剩下 1 个座位。
 

 

 提示： 

 
 1 <= n <= 5 * 10⁴ 
 1 <= m, k <= 10⁹ 
 0 <= maxRow <= n - 1 
 gather 和 scatter 总 调用次数不超过 5 * 10⁴ 次。 
 

 👍 51 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en

import java.util.Arrays;

/**
 * @author  YourName
 * @date 2024-09-28 12:33:50
 */
public class BookingConcertTicketsInGroups{
    public static void main(String[] args) {
//        Solution solution = new BookingConcertTicketsInGroups().new Solution();
//        BookMyShow bms = new BookMyShow(5,9);
//        bms.gather(10, 1);
//        // 返回 [0, 0] // 这一组安排第 0 排 [0, 3] 的座位。
//        bms.scatter(3, 3);
//        bms.gather(9, 1);
//        bms.gather(10, 2);
//        bms.gather(2, 0);
   }
//leetcode submit region begin(Prohibit modification and deletion)
 class BookMyShow {
        int M;
        int[] base;
        long[] sum;
    int[] h;
        int currentRow;

    public BookMyShow(int n, int m) {
        base = new int[n];
        sum = new long[n + 1];
        h = new int[n + 1];
        M = m;
        currentRow = 0;
        for (int i = 0; i < n; i++) {
            addSum(i + 1, m);
            updateMax(i + 1, m);
        }

    }
    public int lowbit(int x) {
        return x & -x;
    }
    public void addSum(int x, int val) {
        base[x - 1] += val;
        while (x < sum.length) {
            sum[x] += val;
            x += lowbit(x);
        }
    }
    public long preSum(int x) {
        long result = 0;
        while (x > 0) {
            result += sum[x];
            x -= lowbit(x);
        }
        return result;
    }
    public int preMax(int x) {
        int result = Integer.MIN_VALUE;
        while (x > 0)  {
            result = Math.max(result, h[x]);
            x -= lowbit(x);
        }
        return result;
    }
    public void updateMax(int x, int val) {
        base[x - 1] = val;
        while (x < h.length) {
            h[x] = base[x - 1];
            int lx = lowbit(x);
            for (int j = 1; j < lx; j *= 2) {
                h[x] = Math.max(h[x], h[x - j]);
            }
            x += lx;
        }
    }
    
    public int[] gather(int k, int maxRow) {
        if (preMax(maxRow + 1) < k) {
            return new int[0];
        }
        int left = 1;
        int right = maxRow + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (preMax(mid) >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        int[] result = new int[]{left - 1, M - base[left - 1]};
        addSum(left, -k);
        updateMax(left, base[left - 1]);
        return result;
    }
    
    public boolean scatter(int k, int maxRow) {
        if (preSum(maxRow + 1) < k) {
            return false;
        }
        int left = 1;
        int right = maxRow + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (preSum(mid) >= k) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        for (; currentRow < left - 1; currentRow++) {
            k -= base[currentRow];
            addSum(currentRow + 1, - base[currentRow]);
            updateMax(currentRow + 1,0);
        }
        addSum(left, -k);
        updateMax(left, base[left - 1]);
        return true;

    }

}

/**
 * Your BookMyShow object will be instantiated and called as such:
 * BookMyShow obj = new BookMyShow(n, m);
 * int[] param_1 = obj.gather(k,maxRow);
 * boolean param_2 = obj.scatter(k,maxRow);
 */
//leetcode submit region end(Prohibit modification and deletion)

}