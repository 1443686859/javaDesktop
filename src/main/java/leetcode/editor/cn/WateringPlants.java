/**
你打算用一个水罐给花园里的 n 株植物浇水。植物排成一行，从左到右进行标记，编号从 0 到 n - 1 。其中，第 i 株植物的位置是 x = i 。x = -
1 处有一条河，你可以在那里重新灌满你的水罐。 

 每一株植物都需要浇特定量的水。你将会按下面描述的方式完成浇水： 

 
 按从左到右的顺序给植物浇水。 
 在给当前植物浇完水之后，如果你没有足够的水 完全 浇灌下一株植物，那么你就需要返回河边重新装满水罐。 
 你 不能 提前重新灌满水罐。 
 

 最初，你在河边（也就是，x = -1），在 x 轴上每移动 一个单位 都需要 一步 。 

 给你一个下标从 0 开始的整数数组 plants ，数组由 n 个整数组成。其中，plants[i] 为第 i 株植物需要的水量。另有一个整数 
capacity 表示水罐的容量，返回浇灌所有植物需要的 步数 。 

 

 示例 1： 

 
输入：plants = [2,2,3,3], capacity = 5
输出：14
解释：从河边开始，此时水罐是装满的：
- 走到植物 0 (1 步) ，浇水。水罐中还有 3 单位的水。
- 走到植物 1 (1 步) ，浇水。水罐中还有 1 单位的水。
- 由于不能完全浇灌植物 2 ，回到河边取水 (2 步)。
- 走到植物 2 (3 步) ，浇水。水罐中还有 2 单位的水。
- 由于不能完全浇灌植物 3 ，回到河边取水 (3 步)。
- 走到植物 3 (4 步) ，浇水。
需要的步数是 = 1 + 1 + 2 + 3 + 3 + 4 = 14 。
 

 示例 2： 

 
输入：plants = [1,1,1,4,2,3], capacity = 4
输出：30
解释：从河边开始，此时水罐是装满的：
- 走到植物 0，1，2 (3 步) ，浇水。回到河边取水 (3 步)。
- 走到植物 3 (4 步) ，浇水。回到河边取水 (4 步)。
- 走到植物 4 (5 步) ，浇水。回到河边取水 (5 步)。
- 走到植物 5 (6 步) ，浇水。
需要的步数是 = 3 + 3 + 4 + 4 + 5 + 5 + 6 = 30 。 

 示例 3： 

 
输入：plants = [7,7,7,7,7,7,7], capacity = 8
输出：49
解释：每次浇水都需要重新灌满水罐。
需要的步数是 = 1 + 1 + 2 + 2 + 3 + 3 + 4 + 4 + 5 + 5 + 6 + 6 + 7 = 49 。
 

 

 提示： 

 
 n == plants.length 
 1 <= n <= 1000 
 1 <= plants[i] <= 10⁶ 
 max(plants[i]) <= capacity <= 10⁹ 
 

 👍 41 👎 0

*/
package leetcode.editor.cn; //如果你的算法题是中文的，后缀就是cn，如果是英文的就是en
 /**
 * @author  YourName
 * @date 2024-05-08 20:45:36
 */
public class WateringPlants{
    public static void main(String[] args) {
        Solution solution = new WateringPlants().new Solution();
        System.out.println(solution.wateringPlants(new int[]{2,2,3,3}, 5));
   }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int wateringPlants(int[] plants, int capacity) {
        int res = capacity;
        int count = 0;
        int index = 0;
        for (int i : plants) { 
            if (res < i) {
                res = capacity;
                count += index * 2;
            }
            index++;
            count++;
            res -= i;
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}