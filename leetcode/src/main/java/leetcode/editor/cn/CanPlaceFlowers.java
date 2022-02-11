//假设有一个很长的花坛，一部分地块种植了花，另一部分却没有。可是，花不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
//
// 给你一个整数数组 flowerbed 表示花坛，由若干 0 和 1 组成，其中 0 表示没种植花，1 表示种植了花。另有一个数 n ，能否在不打破种植规则
//的情况下种入 n 朵花？能则返回 true ，不能则返回 false。 
//
// 
//
// 示例 1： 
//
// 
//输入：flowerbed = [1,0,0,0,1], n = 1
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：flowerbed = [1,0,0,0,1], n = 2
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= flowerbed.length <= 2 * 10⁴ 
// flowerbed[i] 为 0 或 1 
// flowerbed 中不存在相邻的两朵花
// 0 <= n <= flowerbed.length 
// 
// Related Topics 贪心 数组 👍 425 👎 0


package leetcode.editor.cn;

public class CanPlaceFlowers {
    public static void main(String[] args) {
        Solution solution = new CanPlaceFlowers().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean canPlaceFlowers(int[] flowerbed, int n) {
            // 计算 任意两朵花之间可以种植的最大数量
            int m = flowerbed.length, count = 0, prev = -1;

            for (int i = 0; i < m; i++) {
                if (flowerbed[i] == 1) {
                    if (prev < 0) {
                        count += i / 2;
                    } else {
                        count += (i - prev - 2) / 2;
                    }
                    prev = i;
                }
            }

            if (prev < 0) {
                count += (m + 1) / 2;
            } else {
                count += (m - prev - 1) / 2;
            }

            return count >= n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}