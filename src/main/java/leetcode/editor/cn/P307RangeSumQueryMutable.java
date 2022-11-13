package leetcode.editor.cn;
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
// Related Topics 设计 树状数组 线段树 数组 👍 332 👎 0

public class P307RangeSumQueryMutable{
    //leetcode submit region begin(Prohibit modification and deletion)
class NumArray {
    int[] result;
    int[] sum;
//  树状数组是根据二进制来划分数组计算和 如 13（ 1 1 0 1）二进制表达可由 1，4，8来划分， 计算前缀和可有
//  Sum(13)=Sum(1,8)+Sum(9,12)+Sum(13,13),区间跨度分别为8，4，1
        // 同样的每次修改数组中的值，需要修改的区间也由当前的最低1决定，5=(0101)2
// 6 = (0110)_26=(0110)2
// 8 = (0100)_28=(1000) 2

    // 获取最低的1
    int getLowbit(int x) {
        return x & -x;
    }


    void add(int index, int val) {
        while (index < sum.length) {
            sum[index] += val;
            index += getLowbit(index);
        }
    }
    // 树状数组

    int getSum(int index) {
        int ans = 0;
        while (index >= 1) {
            ans += sum[index];
            index -= getLowbit(index);
        }
        return ans;
    }

    public NumArray(int[] nums) {
        result = nums;
        // 树状数组索引从一开始
        sum = new int[result.length + 1];
        for (int i = 0; i < result.length; i++) {
           add(i + 1, result[i]);
        }
    }
    
    public void update(int index, int val) {
        add(index + 1, val - result[index]);
        result[index] = val;
    }
    
    public int sumRange(int left, int right) {
        return getSum(right + 1) - getSum(left);
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