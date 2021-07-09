//给定一个 n × n 的二维矩阵 matrix 表示一个图像。请你将图像顺时针旋转 90 度。
//
// 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[[7,4,1],[8,5,2],[9,6,3]]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
//输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
// 
//
// 示例 3： 
//
// 
//输入：matrix = [[1]]
//输出：[[1]]
// 
//
// 示例 4： 
//
// 
//输入：matrix = [[1,2],[3,4]]
//输出：[[3,1],[4,2]]
// 
//
// 
//
// 提示： 
//
// 
// matrix.length == n 
// matrix[i].length == n 
// 1 <= n <= 20 
// -1000 <= matrix[i][j] <= 1000 
// 
// Related Topics 数组 数学 矩阵 
// 👍 921 👎 0


package leetcode.editor.cn;

public class RotateImage {
    public static void main(String[] args) {
        Solution solution = new RotateImage().new Solution();
        solution.rotate(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 其实也并不是很难，只要找到规律即可。考虑如下数组
         * [1,2,3]
         * [4,5,6]
         * [7,8,9]
         * 顺时针旋转90度之后
         * [7,4,1]
         * [8,5,2]
         * [9,6,3]
         *
         * 可以看出对于任意i行的数，都会变为第i列的数。对于任意第j列的数，都会变为n-j-1行的数
         * 因此对于任意[i][j] = [n-j-1][i]
         * 再考虑遍历问题，对于n为奇数，只需要遍历，n/2行，(n+1)/2列
         * 对于n为偶数，需要遍历，n/2行，n/2列。
         * 又因为int类型舍尾的特点，我们选择遍历，n/2行，(n+1)/2列
         * 对于任意的[i][j]节点，我们使用临时节点存储，然后处理旋转导致的覆盖。根据上述公式，我们很容易得到
         * [i][j] = [n-j-1][i]
         * [n-j-1][i] = [n-i-1][n-j-1]   (这一步骤中，i = n-j-1 , j = i。套用上述公式)
         * [n-i-1][n-j-1] = [j][n-i-1]   (这一步骤中，i = n-i-1, j = n-j-1)
         * [j][n-i-1] = [i][j]           (同样套上述公式，我们发现又回到了[i][j]，也说明上述公式正确性，在代码中我们这里就是temp)
         *
         * @param matrix
         */
        public void rotate(int[][] matrix) {
            int n = matrix.length;
            for (int i = 0; i < n / 2; i++) {
                for (int j = 0; j < (n + 1) / 2; j++) {
                    //对于每一个i,j位置做处理
                    int temp = matrix[i][j];
                    matrix[i][j] = matrix[n - j - 1][i];
                    matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                    matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                    matrix[j][n - i - 1] = temp;
                }
            }

        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}