//和谐数组是指一个数组里元素的最大值和最小值之间的差别 正好是 1 。
//
// 现在，给你一个整数数组 nums ，请你在所有可能的子序列中找到最长的和谐子序列的长度。 
//
// 数组的子序列是一个由数组派生出来的序列，它可以通过删除一些元素或不删除元素、且不改变其余元素的顺序而得到。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,3,2,2,5,2,3,7]
//输出：5
//解释：最长的和谐子序列是 [3,2,2,2,3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,4]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,1,1]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// 
// Related Topics 数组 哈希表 排序 👍 307 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

public class LongestHarmoniousSubsequence {
    public static void main(String[] args) {
        Solution solution = new LongestHarmoniousSubsequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findLHS(int[] nums) {
            // 滑动窗口
            Arrays.sort(nums);

            int ans = 0;
            for (int i = 0, j = 0; j < nums.length; j++) {
                while (i < j && nums[j] - nums[i] > 1) {
                    i++;
                }
                if (nums[j] - nums[i] == 1) {
                    ans = Math.max(ans, j - i + 1);
                }
            }
            return ans;


            // hash 计数法
//            HashMap<Integer, Integer> map = new HashMap<>();
//            for (int num : nums) {
//                map.put(num, map.getOrDefault(num, 0) + 1);
//            }
//            int ans = 0;
//            for (int num : nums) {
//                if (map.containsKey(num - 1)) {
//                    int t = map.get(num) + map.get(num - 1);
//                    ans = Math.max(ans, t);
//                }
//            }
//            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}