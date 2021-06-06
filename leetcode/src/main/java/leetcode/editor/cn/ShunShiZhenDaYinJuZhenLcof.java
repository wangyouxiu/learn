//输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。 
//
// 
//
// 示例 1： 
//
// 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 限制： 
//
// 
// 0 <= matrix.length <= 100 
// 0 <= matrix[i].length <= 100 
// 
//
// 注意：本题与主站 54 题相同：https://leetcode-cn.com/problems/spiral-matrix/ 
// Related Topics 数组 
// 👍 254 👎 0

  
package leetcode.editor.cn;
public class ShunShiZhenDaYinJuZhenLcof{
    public static void main(String[] args) {
        Solution solution = new ShunShiZhenDaYinJuZhenLcof().new Solution();
    }
//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix.length == 0) {
            return new int[0];
        }
        //先确定四个边界
        int l = 0, r = matrix[0].length - 1, t = 0, b = matrix.length - 1;
        int[] arr = new int[(r + 1) * (b + 1)];
        int n = 0;
        while (true) {
            //从左到右
            for (int i = l; i <= r; i++) {
                arr[n++] = matrix[t][i];
            }
            if (++t > b) {
                break;
            }
            //从上到下
            for (int i = t; i <= b; i++) {
                arr[n++] = matrix[i][r];
            }
            if (--r < l) {
                break;
            }
            //从右到左
            for (int i = r; i >= l; i--) {
                arr[n++] = matrix[b][i];
            }
            if (--b < t) {
                break;
            }
            //从下到上
            for (int i = b; i >= t; i--) {
                arr[n++] = matrix[i][l];
            }
            if (++l > r) {
                break;
            }
        }
        return arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}