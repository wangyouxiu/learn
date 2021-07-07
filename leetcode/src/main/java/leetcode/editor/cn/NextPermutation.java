//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 双指针 
// 👍 1209 👎 0


package leetcode.editor.cn;

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        Solution solution = new NextPermutation().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * 1.从右向左找到一个降序的节点
     *      1.1如果找不到，说明当前数组是倒序排列的，使用交换进行排序
     *      1.2如果找到了（i），从右向左找到比i位置大的最小值(j)，其实就是第一个比i大的值，因为i右边是降序排列的
     *      1.3交换i,j位置的值，此时我们得到了一个更大的排列，但并不一定是下一个更大的排列。
     *      1.4将i位置之后的元素进行正序排序，还是可以使用交换的方式，因为i之后的元素是逆序的。排序完成就得到了下一个更大的排序
     */
    class Solution {

        public void nextPermutation(int[] nums) {
            if (nums == null || nums.length < 2) {
                return;
            }
            int i = nums.length - 2;
            //原数组从右往左应该是升序的，这里要找到一个降序的节点。
            //如果找不到，则翻转整个数组
            while (i >= 0 && nums[i] >= nums[i + 1]) {
                i--;
            }
            if (i >= 0) {
                //找到了一个降序的节点
                //从左向右找到一个大于 nums[i] 的最小值，也就是第一个
                int j = nums.length - 1;
                for (; j > i; j--) {
                    if (nums[j] > nums[i]) {
                        break;
                    }
                }
                //i,j位置交换
                swap(nums, i, j);
            }
            resver(nums, i + 1);
        }

        public void resver(int[] nums, int start) {
            int i = start, j = nums.length - 1;
            while (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        public void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}