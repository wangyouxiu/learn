//整数数组 nums 按升序排列，数组中的值 互不相同 。
//
// 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[
//k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2
//,4,5,6,7] 在下标 3 处经旋转后可能变为 [4,5,6,7,0,1,2] 。 
//
// 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 0
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2], target = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：nums = [1], target = 0
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -10^4 <= nums[i] <= 10^4 
// nums 中的每个值都 独一无二 
// 题目数据保证 nums 在预先未知的某个下标上进行了旋转 
// -10^4 <= target <= 10^4 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(log n) 的解决方案吗？ 
// Related Topics 数组 二分查找 
// 👍 1432 👎 0


package leetcode.editor.cn;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        Solution solution = new SearchInRotatedSortedArray().new Solution();
        solution.search(new int[]{1}, 1);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * 二分法查找目标
         * 二分法适合在有序数组中查找目标。本题目中数组并非有序，但是是由两个有序数组组成的，我们可以再局部使用二分法
         * 循环条件while（l<=r）{}
         * 1.判断mid是否是target，是，直接返回，否则继续判断
         * 2.使用二分，在使用的时候，先要判断mid在哪一段上。如果num[mid] >= nums[0] 则在第一段，否则在第二段。
         *      2.1第一段
         *          mid在第一段，这时候会出现两种情况，
         *              1：target大于nums[mid]，此时target的范围很好确定，l = mid + 1
         *              2：target小于nums[mid]，此时target可能分布于两端数组上，因此要加上 target >= nums[0]的条件，此时target在第一段的mid右边，因此，r = mid - 1;
         *          如果target在第二段，则 l = mid + 1.因此我们先判断条件2，当条件2不满足时，将 l = mid + 1
         *      2.2第二段
         *          mid在第二段，两种情况
         *              1：target小于nums[mid]，此时target会在第二段的mid左边，因此，r = mid - 1
         *              2；target大于nums[mid]，此时target肯定出现在两段上，因此，加上 target <= nums[nums.length-1]的条件，此时target在第二段的mid右边，因此，l = mid + 1;
         *          如果target在第一段，则 r = mid - 1,所以，先判断条件2，当条件2不满足时，将 r = mid - 1
         * 3.如果l>r，则说明找不到target，返回-1
         * @param nums
         * @param target
         * @return
         */
        public int search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return -1;
            }
            if (nums.length == 1) {
                return nums[0] == target ? 0 : -1;
            }

            int l = 0, r = nums.length - 1;
            while (l <= r) {
                int mid = l + ((r - l) >> 1);
                if (target == nums[mid]) {
                    return mid;
                }
                //确认mid在哪一段
                if (nums[mid] >= nums[0]) {
                    //mid在前半段
                    if (target < nums[mid] && target >= nums[0]) {
                        r = mid - 1;
                    }else{
                        l = mid + 1;
                    }
                }else{
                    //mid在后半段
                    if (target > nums[mid] && target <= nums[nums.length - 1]) {
                        l = mid + 1;
                    }else{
                        r = mid - 1;
                    }
                }
            }
            return -1;
        }


        /**
         * 一次遍历，复杂度O(logN)
         * @param nums
         * @param target
         * @return
         */
/*        public int search(int[] nums, int target) {
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    return i;
                }
            }
            return -1;
        }*/
    }
//leetcode submit region end(Prohibit modification and deletion)

}