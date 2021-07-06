    //给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 排序 
// 👍 3473 👎 0

  
package leetcode.editor.cn;

    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;

    public class ThreeSum{
    public static void main(String[] args) {
        Solution solution = new ThreeSum().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            /**
             * 1.先对数组排序
             * 2.先固定第一个数字，遍历数组(下标i)。
             *     2.1 如果当前数字大于0，则整个迭代结束。因为数组升序排列，a+b+c不可能等于0
             *     2.2 迭代过程中，为了避免重复，需要与前一个进行比较，如果相等则跳过本次迭代
             * 3.定义左指针 l = i+1 ,右指针 r = len - 1。
             *     3.1 当l<r时，进行循环
             *     3.2 计算当前的和，判断其与0的关系
             *         3.2.1 如果大于0，那么r指针应该向左移动，移动过程中，注意 l < r。并且要注意重复，一定要跳过所有重复的项
             *         3.2.2 如果小于0，那么l指针应该向右移动，同上，需要注意 l < r 并且要跳过所有重复项
             *         3.2.3 如果等于0，则首先要将当前结果记入总的结果中，同时，l,r指针都要移动，并且要保证l<r且跳过重复项
             *
             */

            //先排序
            Arrays.sort(nums);
            List<List<Integer>> result = new ArrayList<>();

            int len = nums.length;
            for (int i = 0; i < len - 2; i++) {
                if (nums[i] > 0) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i-1]) {
                    continue;
                }
                //定义双指针
                int l = i + 1, r = len - 1;
                while (l < r) {
                    int temp = nums[i] + nums[l] + nums[r];
                    if (temp > 0) {
                        while (l < r && nums[r] == nums[--r]) {};
                    } else if (temp < 0) {
                        while (l < r && nums[l] == nums[++l]) {};
                    } else {
                        result.add(new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r])));
                        while (l < r && nums[r] == nums[--r]) {};
                        while (l < r && nums[l] == nums[++l]) {};
                    }
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}