//集合 s 包含从 1 到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个数字复制了成了集合里面的另外一个数字的值，导致集合 丢失了一个数字 并且 有
//一个数字重复 。 
//
// 给定一个数组 nums 代表了集合 S 发生错误后的结果。 
//
// 请你找出重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,2,4]
//输出：[2,3]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// 1 <= nums[i] <= 10⁴ 
// 
// Related Topics 位运算 数组 哈希表 排序 👍 250 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

public class SetMismatch {
    public static void main(String[] args) {
        Solution solution = new SetMismatch().new Solution();
        solution.findErrorNums(new int[]{3,2,3,4,6,5});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] findErrorNums(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int num : nums) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            int[] ans = new int[2];
            for (int i = 1; i <= nums.length; i++) {
                Integer count = map.getOrDefault(i, 0);
                if (count == 0) {
                    ans[1] = i;
                } else if (count == 2) {
                    ans[0] = i;
                }
            }

            return ans;

//            Arrays.sort(nums);
//            int n = nums.length, x = nums[n - 1];
//            int[] ans = new int[2];
//            for (int i = 0; i < n - 1; i++) {
//                if (nums[i] == nums[i + 1]) {
//                    ans[0] = nums[i];
//                } else {
//                    x ^= nums[i];
//                }
//            }
//
//            for (int i = 1; i <= n; i++) {
//                x ^= i;
//            }
//            ans[1] = x;
//            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}