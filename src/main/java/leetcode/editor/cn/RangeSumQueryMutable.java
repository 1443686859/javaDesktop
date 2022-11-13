//给你一个数组 nums ，请你完成两类查询。 
//
// 
// 其中一类查询要求 更新 数组 nums 下标对应的值 
// 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right 
// 
//
// 实现 NumArray 类： 
//
// 
// NumArray(int[] nums) 用整数数组 nums 初始化对象 
// void update(int index, int val) 将 nums[index] 的值 更新 为 val 
// int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元
//素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]） 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：
//["NumArray", "sumRange", "update", "sumRange"]
//[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
//输出：
//[null, 9, null, 8]
//
//解释：
//NumArray numArray = new NumArray([1, 3, 5]);
//numArray.sumRange(0, 2); // 返回 1 + 3 + 5 = 9
//numArray.update(1, 2);   // nums = [1,2,5]
//numArray.sumRange(0, 2); // 返回 1 + 2 + 5 = 8
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 10⁴ 
// -100 <= nums[i] <= 100 
// 0 <= index < nums.length 
// -100 <= val <= 100 
// 0 <= left <= right < nums.length 
// 调用 pdate 和 sumRange 方法次数不大于 3 * 10⁴ 
// 
// Related Topics 设计 树状数组 线段树 数组 👍 378 👎 0

package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2022-04-04 10:03:22
 */
public class RangeSumQueryMutable{
    public static void main(String[] args) {
        NumArray numArray = new RangeSumQueryMutable().new NumArray(new int[]{7,2,7,2,0});
        numArray.update(4,6);
        numArray.update(0,2);
        numArray.update(0,9);
        System.out.println(numArray.sumRange(4,4));
        numArray.update(3, 8);
        System.out.println(numArray.sumRange(0,4));
        numArray.update(4,1);
        System.out.println(numArray.sumRange(0, 3));
        System.out.println(numArray.sumRange(0, 4));
        numArray.update(0, 4);
        System.out.println(numArray.sumRange(4, 6));
        numArray.update(1, 2);
        System.out.println(numArray.sumRange(0, 2));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class NumArray {
        int[] nums;
        long[] c;
        int n;
    public NumArray(int[] nums) {
        this.n = nums.length;
        c = new long[n + 1];
        this.nums = nums;
        for (int i = 0; i < n; i++) {
            add(i + 1, nums[i]);
        }
    }
    
    public void update(int index, int val) {
        add(index + 1, val - nums[index]);
    }
    
    public int sumRange(int left, int right) {
        long pre = 0;
        if (left >= 0) {
            int start = left;
            while (start > 0) {
                pre += c[start];
                start -= lowbit(start);
            }
        }
        long after = 0;
        if (right + 1 <= n) {
            int start = right + 1;
            while (start > 0) {
                after += c[start];
                start -= lowbit(start);
            }
        }
        return (int)(after - pre);
    }
    public int lowbit(int i) {
        return i & (-i);
    }
    public void add(int i, int val) {
        while (i <= n) {
            c[i] += val;
            i += lowbit(i);
        }

    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}