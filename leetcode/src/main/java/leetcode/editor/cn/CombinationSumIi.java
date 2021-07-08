//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 
// 👍 622 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumIi {
    public static void main(String[] args) {
        Solution solution = new CombinationSumIi().new Solution();
        solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 因为不能重复选择，所以需要对数组进行排序，让相等的数相邻，在层级遍历的时候，要传递某一层从哪个下标开始获取
         * 结束条件是target==0，此时可以将结果加入结果集
         * 在回溯过程中，如果target<0，则整个子树都要剪掉，因为数组正序排列，后面不会有符合条件的选择
         * 当发现当前的数和之前的一样，则进行小剪枝，将本层的当前数去掉，因为之前的数已经被选择过了，一旦有任何符合条件的选择，都会造成重复
         *
         * @param candidates
         * @param target
         * @return
         */
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            Arrays.sort(candidates);
            List<List<Integer>> result = new ArrayList<>();
            backTrack(result, candidates, target, 0, new ArrayList<>());
            return result;
        }

        public void backTrack(List<List<Integer>> result, int[] candidates, int target, int index, List<Integer> cur) {
            if (target == 0) {
                result.add(new ArrayList<>(cur));
                return;
            }
            for (int i = index; i < candidates.length; i++) {
                //大剪枝，直接将整个树剪掉
                if (target - candidates[i] < 0) {
                    break;
                }
                //小剪枝，重复了，前面肯定选过了，在这一层就跳过
                if (i > index && candidates[i] == candidates[i-1]) {
                    continue;
                }
                //做选择
                cur.add(candidates[i]);
                //这里的index一定是i+1，不是index+1
                backTrack(result, candidates, target - candidates[i], i + 1, cur);
                cur.remove(cur.size() - 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}