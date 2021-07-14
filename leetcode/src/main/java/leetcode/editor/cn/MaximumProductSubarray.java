//给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
//
// 
//
// 示例 1: 
//
// 输入: [2,3,-2,4]
//输出: 6
//解释: 子数组 [2,3] 有最大乘积 6。
// 
//
// 示例 2: 
//
// 输入: [-2,0,-1]
//输出: 0
//解释: 结果不能为 2, 因为 [-2,-1] 不是子数组。 
// Related Topics 数组 动态规划 
// 👍 1171 👎 0


package leetcode.editor.cn;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        Solution solution = new MaximumProductSubarray().new Solution();
        solution.maxProduct(new int[]{-2, 3, -4});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 动态规划求解，需要考虑负负得正的情况，因此需要两个dp数字，一个记录最大值，一个记录最小值。
         * @param nums
         * @return
         */
        public int maxProduct(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int len = nums.length;
            int maxProduct = nums[0];
            int[] dpMax = new int[len];
            int[] dpMin = new int[len];
            dpMax[0] = dpMin[0] = nums[0];
            for (int i = 1; i < len; i++) {
                dpMax[i] = Math.max(dpMin[i - 1] * nums[i], Math.max(dpMax[i - 1] * nums[i], nums[i]));
                dpMin[i] = Math.min(dpMin[i - 1] * nums[i], Math.min(dpMax[i - 1] * nums[i], nums[i]));
                maxProduct = Math.max(maxProduct, dpMax[i]);
            }
            return maxProduct;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}