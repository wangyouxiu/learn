//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SE
//E"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "AB
//CB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 
// 👍 952 👎 0


package leetcode.editor.cn;

public class WordSearch {
    public static void main(String[] args) {
        Solution solution = new WordSearch().new Solution();
        solution.exist(new char[][]{{'A', 'B', 'C', 'E' }, {'S', 'F', 'C', 'S' }, {'A', 'D', 'E', 'E' }}, "ABCCED");
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean exist(char[][] board, String word) {
            int n = board.length;
            int m = board[0].length;
            boolean[][] isUse = new boolean[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    boolean check = check(i, j, word, 0, board, isUse);
                    if (check) {
                        return true;
                    }
                }
            }

            return false;
        }

        private boolean check(int i, int j, String word, int index, char[][] board, boolean[][] isUse) {
            if (board[i][j] != word.charAt(index)) {
                return false;
            } else if (index == word.length() - 1) {
                return true;
            }
            isUse[i][j] = true;
            int[][] temp = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            boolean result = false;
            for (int[] tempp : temp) {
                int newi = i + tempp[0];
                int newj = j + tempp[1];
                if (newi >= 0 && newi < board.length && newj >= 0 && newj < board[0].length) {
                    //没访问过
                    if (!isUse[newi][newj]) {
                        boolean check = check(newi, newj, word, index + 1, board, isUse);
                        if (check) {
                            result = true;
                            break;
                        }
                    }
                }
            }
            isUse[i][j] = false;
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}