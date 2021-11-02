//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 1170 👎 0


package leetcode.editor.cn;

public class KthLargestElementInAnArray {
    public static void main(String[] args) {
        Solution solution = new KthLargestElementInAnArray().new Solution();
        solution.findKthLargest(new int[]{3,2,1,5,6,4}, 2);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /**
         * 建立大根堆，找到第k大的数
         * 1.任意数组可以看为一个堆
         * 2.需要做的是将这个堆调整为大根堆
         * 3.每次取堆顶元素，之后重新调整堆
         * @param nums
         * @param k
         * @return
         */
        public int findKthLargest(int[] nums, int k) {
            int len = nums.length - 1;
            if (k > len + 1) {
                return -1;
            }
            //从后向前调整堆
            int beginIndex = len >> 1;
            //构建大根堆
            for (int i = beginIndex; i >= 0; i--) {
                maxHeapify(nums, i, len);
            }

            int count = 0;
            for (int i = len; i >= 0; i--) {
                if (++count == k) {
                    return nums[0];
                }
                //交换第0个与最后一个元素
                swap(nums, 0, i);
                //重新调整大根堆
                maxHeapify(nums, 0, i - 1);
            }
            return -1;
        }

        private void swap(int[] nums,int i, int i1) {
            int temp = nums[i];
            nums[i] = nums[i1];
            nums[i1] = temp;
        }

        private void maxHeapify(int[] nums, int i, int len) {
            int l = (i << 1) + 1;
            int r = l + 1;
            //最大节点，默认左节点
            int max = l;

            //如果左节点已经超出范围，直接返回
            if (l > len) {
                return;
            }
            //如果右节点在范围内，并且右节点大于左节点，则max=r
            if (r <= len && nums[r] > nums[l]) {
                max = r;
            }
            //如果左右节点的最大值，大于父节点，则需要交换，如果发生交换，还要判断换下来后的父节点是否符合大根堆的特性
            if (nums[max] > nums[i]) {
                swap(nums, max, i);
                maxHeapify(nums, max, len);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}