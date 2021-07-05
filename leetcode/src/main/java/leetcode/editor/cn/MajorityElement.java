    //给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。 
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 
// Related Topics 数组 哈希表 分治 计数 排序 
// 👍 1046 👎 0

  
package leetcode.editor.cn;

    import java.util.Arrays;

    public class MajorityElement{
    public static void main(String[] args) {
        Solution solution = new MajorityElement().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        //使用hashMap统计个数，略


        //排序，之后取中间的数，如果是偶数，取偏左或者偏右都可以。
        public int majorityElement(int[] nums) {
            Arrays.sort(nums);
            return nums[nums.length / 2];
        }


        //随机化，因为众数占了n/2以上个位置，因此随机找一个数，判断它是否是众数，如果不是，再随机找下一个，直到找到为止。


        //分治思想
        //如果一个数n是数组nums的众数，那么将nums分割为两部分后。n至少是某一部分的众数。因此采用分治思想， 将nums数组层层拆分
        //直到剩下一个数，那么这个数就是众数
        //再考虑合并，如果左半边的众数和右半边的众数相等，则合并后众数不变。如果二者不相等，则分别计算两个众数出现的次数，次数多的那个就是合并后的众数。
    }
//leetcode submit region end(Prohibit modification and deletion)

}