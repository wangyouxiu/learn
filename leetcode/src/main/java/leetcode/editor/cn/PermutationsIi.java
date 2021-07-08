//给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,1,2]
//输出：
//[[1,1,2],
// [1,2,1],
// [2,1,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 8 
// -10 <= nums[i] <= 10 
// 
// Related Topics 数组 回溯 
// 👍 739 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsIi {
    public static void main(String[] args) {
        Solution solution = new PermutationsIi().new Solution();
        solution.permuteUnique(new int[]{1, 1, 2});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        boolean[] isUse;
        public List<List<Integer>> permuteUnique(int[] nums) {
            List<List<Integer>> result = new ArrayList<>();
            //数组排序
            Arrays.sort(nums);
            isUse = new boolean[nums.length];
            backTrack(result, nums, new ArrayList<>(), 0);
            return result;
        }

        /**
         * 1.index == nums.length 表示找到了结果
         * 2.遍历中，如果这个数字已经被选择就不能够再选择这个数字。
         * 但是有另一种情况，当前数字没有被选过，但是和前面一个数字重复，就需要保证，当前数字和前面数字的顺序。方法就是，必须前面的数字先被选择，当前数字才可以被选择。
         * @param result
         * @param nums
         * @param cur
         * @param index
         */
        public void backTrack(List<List<Integer>> result, int[] nums, List<Integer> cur, int index) {
            if (index == nums.length) {
                result.add(new ArrayList<>(cur));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (isUse[i] || (i > 0 && nums[i] == nums[i - 1] && !isUse[i - 1])) {
                    continue;
                }

                //做选择
                cur.add(nums[i]);
                isUse[i] = true;
                backTrack(result, nums, cur, index + 1);
                cur.remove(cur.size() - 1);
                isUse[i] = false;
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}