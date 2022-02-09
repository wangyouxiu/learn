//给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: rowIndex = 3
//输出: [1,3,3,1]
// 
//
// 示例 2: 
//
// 
//输入: rowIndex = 0
//输出: [1]
// 
//
// 示例 3: 
//
// 
//输入: rowIndex = 1
//输出: [1,1]
// 
//
// 
//
// 提示: 
//
// 
// 0 <= rowIndex <= 33 
// 
//
// 
//
// 进阶： 
//
// 你可以优化你的算法到 O(rowIndex) 空间复杂度吗？ 
// Related Topics 数组 动态规划 👍 361 👎 0


package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleIi {
    public static void main(String[] args) {
        Solution solution = new PascalsTriangleIi().new Solution();
        solution.getRow(5);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getRow(int rowIndex) {
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int i = 1; i <= rowIndex; i++) {
                row.add(0);
                for (int j = i; j > 0; j--) {
                    row.set(j, row.get(j) + row.get(j - 1));
                }
            }
            return row;

//            List<Integer> pre = new ArrayList<>();
//            for (int i = 0; i <= rowIndex; i++) {
//                List<Integer> cur = new ArrayList<>();
//                for (int j = 0; j <= i; j++) {
//                    if (j == 0 || j == i) {
//                        cur.add(1);
//                    } else {
//                        cur.add(pre.get(j - 1) + pre.get(j));
//                    }
//                }
//                pre = cur;
//            }
//            return pre;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}