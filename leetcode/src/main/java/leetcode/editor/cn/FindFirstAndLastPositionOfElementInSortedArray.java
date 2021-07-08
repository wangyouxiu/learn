//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 105 
// -109 <= nums[i] <= 109 
// nums 是一个非递减数组 
// -109 <= target <= 109 
// 
// Related Topics 数组 二分查找 
// 👍 1095 👎 0


package leetcode.editor.cn;

public class FindFirstAndLastPositionOfElementInSortedArray {
    public static void main(String[] args) {
        Solution solution = new FindFirstAndLastPositionOfElementInSortedArray().new Solution();
        solution.searchRange(new int[]{2, 2}, 3);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * nums数组是一个非递减数组，也就是递增但是有重复
         * 可以使用一次遍历记录第一次和最后一次遇到target的位置，但是复杂度O(n)。并且没有利用到数组非递减的特性。
         * 因为数组非递减，可以使用二分查找，我们查找target和target-1，分别查找他们插入的位置，如果相等，靠右边插入。最终返回左指针
         * 之后要校验左指针是否符合要求，不符合返回[-1,-1]
         * @param nums
         * @param target
         * @return
         */
        public int[] searchRange(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return new int[]{-1, -1};
            }

            int search = search(nums, target - 1);
            int search1 = search(nums, target) - 1;

            //判断是否正常, 说明找到了target的第一个数，如果第一个数合法，则最后一个target一定存在，且合法
            if (search < nums.length && nums[search] == target) {
                return new int[]{search, search1};
            }
            return new int[]{-1, -1};

        }

        public int search(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                if (nums[mid] <= target) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            return l;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}