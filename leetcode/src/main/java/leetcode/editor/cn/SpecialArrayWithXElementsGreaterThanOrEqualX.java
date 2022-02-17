//给你一个非负整数数组 nums 。如果存在一个数 x ，使得 nums 中恰好有 x 个元素 大于或者等于 x ，那么就称 nums 是一个 特殊数组 ，而
// x 是该数组的 特征值 。 
//
// 注意： x 不必 是 nums 的中的元素。 
//
// 如果数组 nums 是一个 特殊数组 ，请返回它的特征值 x 。否则，返回 -1 。可以证明的是，如果 nums 是特殊数组，那么其特征值 x 是 唯一的
// 。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,5]
//输出：2
//解释：有 2 个元素（3 和 5）大于或等于 2 。
// 
//
// 示例 2： 
//
// 输入：nums = [0,0]
//输出：-1
//解释：没有满足题目要求的特殊数组，故而也不存在特征值 x 。
//如果 x = 0，应该有 0 个元素 >= x，但实际有 2 个。
//如果 x = 1，应该有 1 个元素 >= x，但实际有 0 个。
//如果 x = 2，应该有 2 个元素 >= x，但实际有 0 个。
//x 不能取更大的值，因为 nums 中只有两个元素。 
//
// 示例 3： 
//
// 输入：nums = [0,4,3,0,4]
//输出：3
//解释：有 3 个元素大于或等于 3 。
// 
//
// 示例 4： 
//
// 输入：nums = [3,6,7,7,0]
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 数组 二分查找 排序 👍 34 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class SpecialArrayWithXElementsGreaterThanOrEqualX {
    public static void main(String[] args) {
        Solution solution = new SpecialArrayWithXElementsGreaterThanOrEqualX().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int specialArray(int[] nums) {
            // 利用数组进行计数
            int maxNum = 0;
            for (int num : nums) {
                maxNum = Math.max(maxNum, num);
            }
            int[] count = new int[maxNum + 1];
            for (int num : nums) {
                count[num]++;
            }

            int countNum = 0;
            for (int i = maxNum; i > 0; i--) {
                countNum += count[i];
                if (i > nums.length) {
                    continue;
                }
                if (countNum > i) {
                    break;
                }
                if (countNum == i) {
                    return i;
                }
            }
            return -1;


            // 排序 + 二分
//            Arrays.sort(nums);
//            // nums 数组中 有 i 个元素 大于等于 i
//            for (int i = 1; i <= nums.length; i++) {
//                // 二分，找第一个大于等于i的数，然后判断这样的数是不是i个
//                int l = 0, r = nums.length - 1;
//                while (l <= r) {
//                    int mid = l + (r - l >> 1);
//                    if (nums[mid] >= i) {
//                        r = mid - 1;
//                    }else{
//                        l = mid + 1;
//                    }
//                }
//                if (nums.length - l == i) {
//                    return i;
//                }
//            }
//            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}