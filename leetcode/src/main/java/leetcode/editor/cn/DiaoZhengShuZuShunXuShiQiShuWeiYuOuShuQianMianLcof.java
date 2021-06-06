//输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。 
//
// 
//
// 示例： 
//
// 
//输入：nums = [1,2,3,4]
//输出：[1,3,2,4] 
//注：[3,1,2,4] 也是正确的答案之一。 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 50000 
// 1 <= nums[i] <= 10000 
// 
// 👍 127 👎 0

  
package leetcode.editor.cn;
public class DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof{
    public static void main(String[] args) {
        Solution solution = new DiaoZhengShuZuShunXuShiQiShuWeiYuOuShuQianMianLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] exchange(int[] nums) {
            int p1 = -1;
            int p2 = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] % 2 == 1) {
                    p1++;
                    swap(nums, p1, p2);
                    p2++;
                }else{
                    p2++;
                }
            }
            return nums;
        }

        public void swap(int[] arr, int p1, int p2) {
            int t = arr[p1];
            arr[p1] = arr[p2];
            arr[p2] = t;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}