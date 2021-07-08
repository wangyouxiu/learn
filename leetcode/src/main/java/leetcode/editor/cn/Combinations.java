//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 数组 回溯 
// 👍 617 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    public static void main(String[] args) {
        Solution solution = new Combinations().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            backTrack(result, n, k, new ArrayList<>(), 1);
            return result;
        }

        public void backTrack(List<List<Integer>> result, int n, int k, List<Integer> cur,int index) {
            if (cur.size() == k) {
                result.add(new ArrayList<>(cur));
                return;
            }
            for (int i = index; i <= n; i++) {
                cur.add(i);
                backTrack(result, n, k, cur, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}