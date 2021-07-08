//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯 
// 👍 1421 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        Solution solution = new CombinationSum().new Solution();
        solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList<>();
            callBack(result, new ArrayList<Integer>(), candidates, target, 0, 0);
            return result;
        }

        public void callBack(List<List<Integer>> result, List<Integer> cur, int[] candidates, int target, int index,int curResult) {
            if (index == candidates.length) {
                return;
            }
            //终止条件
            if (curResult == target) {
                result.add(new ArrayList<>(cur));
                return;
            }
            //跳过当前值
            callBack(result, cur, candidates, target, index + 1, curResult);
            //如果加上当前值还没有达到target，可以选择当前值
            if (curResult + candidates[index] <= target) {
                //选择当前值
                curResult += candidates[index];
                cur.add(candidates[index]);
                //回溯,仍然选当前值
                callBack(result, cur, candidates, target, index, curResult);
                //清除当前选择
                curResult -= candidates[index];
                cur.remove(cur.size() - 1);
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}