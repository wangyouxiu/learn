    //两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。 
//
// 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。 
//
// 
//
// 示例 1： 
//
// 
//输入：x = 1, y = 4
//输出：2
//解释：
//1   (0 0 0 1)
//4   (0 1 0 0)
//       ↑   ↑
//上面的箭头指出了对应二进制位不同的位置。
// 
//
// 示例 2： 
//
// 
//输入：x = 3, y = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 0 <= x, y <= 231 - 1 
// 
// Related Topics 位运算 
// 👍 494 👎 0

  
package leetcode.editor.cn;

public class HammingDistance{
    public static void main(String[] args) {
        Solution solution = new HammingDistance().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //通过手动位移需要遍历每一个位，而 z & (z-1)能够迅速减去一个1
        //因此使用该方式，能够快速统计有几个1
        public int hammingDistance(int x, int y) {
            int z = x ^ y, res = 0;
            while (z != 0) {
                z &= z-1;
                res++;
            }
            return res;
        }

        //使用内置函数计算1的个数
//        public int hammingDistance(int x, int y) {
//            return Integer.bitCount(x ^ y);
//        }

        //手动通过右移操作统计为1的位数
//        public int hammingDistance(int x, int y) {
//            int z = x ^ y, res = 0;
//            while (z != 0) {
//                res += z & 1;
//                z >>= 1;
//            }
//            return res;
//        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}