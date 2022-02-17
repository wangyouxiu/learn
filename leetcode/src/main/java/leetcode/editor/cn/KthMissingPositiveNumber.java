//给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。
//
// 请你找到这个数组里第 k 个缺失的正整数。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [2,3,4,7,11], k = 5
//输出：9
//解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
// 
//
// 示例 2： 
//
// 输入：arr = [1,2,3,4], k = 2
//输出：6
//解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 1000 
// 1 <= arr[i] <= 1000 
// 1 <= k <= 1000 
// 对于所有 1 <= i < j <= arr.length 的 i 和 j 满足 arr[i] < arr[j] 
// 
// Related Topics 数组 二分查找 👍 71 👎 0


package leetcode.editor.cn;

public class KthMissingPositiveNumber {
    public static void main(String[] args) {
        Solution solution = new KthMissingPositiveNumber().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthPositive(int[] arr, int k) {
            if (arr[0] > k) {
                return k;
            }
            int l = 0, r = arr.length - 1;
            while (l <= r) {
                int mid = l + (r - l >> 1);
                if (arr[mid] - mid - 1 >= k) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            l--;
            return k + l + 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}