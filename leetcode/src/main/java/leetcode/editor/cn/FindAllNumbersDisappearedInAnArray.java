    //给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数
//字，并以数组的形式返回结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1]
//输出：[2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 105 
// 1 <= nums[i] <= n 
// 
//
// 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。 
// Related Topics 数组 哈希表 
// 👍 767 👎 0

  
package leetcode.editor.cn;

    import java.util.ArrayList;
    import java.util.List;

    public class FindAllNumbersDisappearedInAnArray{
    public static void main(String[] args) {
        Solution solution = new FindAllNumbersDisappearedInAnArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> findDisappearedNumbers(int[] nums) {
            //用nums数组做记录，省去hash表
            int n = nums.length;
            for (int num : nums) {
                //因为num范围是[1,n]因此，需要减1。又因为我们会在后面进行加n，所以需要取余
                int x = (num - 1) % n;
                nums[x] += n;
            }
            //上述循环完成之后，访问过的数字(下标)值都会大于n，再次遍历，找到那些值小于n的下标，加1就是没有遇到过的值
            List<Integer> result = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                if (nums[i] <= n) {
                    result.add(i + 1);
                }
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}