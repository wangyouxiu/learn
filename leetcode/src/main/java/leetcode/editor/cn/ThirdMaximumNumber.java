//给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。
//
// 
//
// 示例 1： 
//
// 
//输入：[3, 2, 1]
//输出：1
//解释：第三大的数是 1 。 
//
// 示例 2： 
//
// 
//输入：[1, 2]
//输出：2
//解释：第三大的数不存在, 所以返回最大的数 2 。
// 
//
// 示例 3： 
//
// 
//输入：[2, 2, 3, 1]
//输出：1
//解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
//此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁴ 
// -2³¹ <= nums[i] <= 2³¹ - 1 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度 O(n) 的解决方案吗？ 
// Related Topics 数组 排序 👍 336 👎 0


package leetcode.editor.cn;

import java.util.Arrays;
import java.util.TreeSet;

public class ThirdMaximumNumber {
    public static void main(String[] args) {
        Solution solution = new ThirdMaximumNumber().new Solution();
        solution.thirdMax(new int[]{3, 2, 1});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int thirdMax(int[] nums) {
            // 时间复杂度 O(n)
            // 借助有序集合
            TreeSet<Integer> set = new TreeSet<>();
            for (int num : nums) {
                set.add(num);
                if (set.size() > 3) {
                    set.remove(set.first());
                }
            }
            return set.size() == 3 ? set.first() : set.last();

            // 用 a,b,c 分别表示 最大、第二大、第三大 的数
//            long a = Long.MIN_VALUE, b = Long.MIN_VALUE, c = Long.MIN_VALUE;
//            for (int num : nums) {
//                if (num > a) {
//                    c = b;
//                    b = a;
//                    a = num;
//                } else if (num > b && num < a) {
//                    c = b;
//                    b = num;
//                } else if (num > c && num < b) {
//                    c = num;
//                }
//            }
//            if (c == Long.MIN_VALUE) {
//                return (int) a;
//            }
//            return (int)c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}