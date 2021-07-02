    //给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组。 
//
// 初始化 nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nu
//ms2 的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
//输出：[1,2,2,3,5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1], m = 1, nums2 = [], n = 0
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m + n 
// nums2.length == n 
// 0 <= m, n <= 200 
// 1 <= m + n <= 200 
// -109 <= nums1[i], nums2[i] <= 109 
// 
// Related Topics 数组 双指针 排序 
// 👍 984 👎 0

  
package leetcode.editor.cn;

public class MergeSortedArray{
    public static void main(String[] args) {
        Solution solution = new MergeSortedArray().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //1.合并两个数组并排序
        //2.双指针遍历两个数组，每次将较小的那个放入一个新开的数组中，然后将新开的数组复制到原数组
        //3.双指针反向遍历，每次将大的放在nums1最后
        int sum = m + n - 1, p1 = m - 1, p2 = n - 1;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                nums1[sum--] = nums2[p2--];
            }else if(p2 == -1){
                nums1[sum--] = nums1[p1--];
            }else if(nums2[p2] > nums1[p1]){
                nums1[sum--] = nums2[p2--];
            }else{
                nums1[sum--] = nums1[p1--];
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}