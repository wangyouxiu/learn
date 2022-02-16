//给你一个 m * n 的矩阵，矩阵中的数字 各不相同 。请你按 任意 顺序返回矩阵中的所有幸运数。
//
// 幸运数是指矩阵中满足同时下列两个条件的元素： 
//
// 
// 在同一行的所有元素中最小 
// 在同一列的所有元素中最大 
// 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[3,7,8],[9,11,13],[15,16,17]]
//输出：[15]
//解释：15 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,10,4,2],[9,3,8,7],[15,16,17,12]]
//输出：[12]
//解释：12 是唯一的幸运数，因为它是其所在行中的最小值，也是所在列中的最大值。
// 
//
// 示例 3： 
//
// 输入：matrix = [[7,8],[1,2]]
//输出：[7]
// 
//
// 
//
// 提示： 
//
// 
// m == mat.length 
// n == mat[i].length 
// 1 <= n, m <= 50 
// 1 <= matrix[i][j] <= 10^5 
// 矩阵中的所有元素都是不同的 
// 
// Related Topics 数组 矩阵 👍 77 👎 0


package leetcode.editor.cn;

import java.util.*;

public class LuckyNumbersInAMatrix {
    public static void main(String[] args) {
        Solution solution = new LuckyNumbersInAMatrix().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> luckyNumbers(int[][] matrix) {
            // 预处理数组,获取矩阵每行的最小数组,每列的最大数组,之后遍历矩阵,判断是否相等
            int n = matrix.length, m = matrix[0].length;
            int[] row = new int[n];
            Arrays.fill(row, Integer.MAX_VALUE);
            int[] col = new int[m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    row[i] = Math.min(row[i], matrix[i][j]);
                    col[j] = Math.max(col[j], matrix[i][j]);
                }
            }

            List<Integer> ans = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (matrix[i][j] == row[i] && matrix[i][j] == col[j]) {
                        ans.add(row[i]);
                    }
                }
            }
            return ans;


            // 利用数组中数字的唯一性,使用set进行判断
//            int n = matrix.length, m = matrix[0].length;
//            List<Integer> ans = new ArrayList<>();
//            Set<Integer> set = new HashSet<>();
//            // 求每行最小值
//            for (int i = 0; i < n; i++) {
//                int min = matrix[i][0];
//                for (int j = 1; j < m; j++) {
//                    if (matrix[i][j] < min) {
//                        min = matrix[i][j];
//                    }
//                }
//                set.add(min);
//            }
//            for (int j = 0; j < m; j++) {
//                int max = matrix[0][j];
//                for (int i = 1; i < n; i++) {
//                    if (matrix[i][j] > max) {
//                        max = matrix[i][j];
//                    }
//                }
//                if (set.contains(max)) {
//                    ans.add(max);
//                }
//            }
//            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}