//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 数组 排序 
// 👍 994 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public static void main(String[] args) {
        Solution solution = new MergeIntervals().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 先排序，按照左端点升序排序
         * 然后再判断是否有重合，有重合需要将右端点扩展至右端点的最大值
         * 没有重合则需要将当前的数组加入集合中
         * @param intervals
         * @return
         */
        public int[][] merge(int[][] intervals) {
            if (intervals.length == 0) {
                return new int[0][2];
            }
            Arrays.sort(intervals, Comparator.comparingInt((int[] v) -> v[0]));
            List<int[]> result = new ArrayList<>();
            for (int i = 0; i < intervals.length; i++) {
                if (result.isEmpty() || result.get(result.size() - 1)[1] < intervals[i][0]) {
                    result.add(intervals[i]);
                } else {
                    result.get(result.size() - 1)[1] = Math.max(result.get(result.size() - 1)[1], intervals[i][1]);
                }
            }
            return result.toArray(new int[result.size()][]);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}