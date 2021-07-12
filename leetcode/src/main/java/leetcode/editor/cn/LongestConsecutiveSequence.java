//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。
//
// 
//
// 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 哈希表 
// 👍 825 👎 0


package leetcode.editor.cn;

import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        Solution solution = new LongestConsecutiveSequence().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int longestConsecutive(int[] nums) {
            //hashSet去重
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num);
            }

            int max = 0;
            for (int num : nums) {
                //不包含之前的元素，才进行下面的判断。即保证我当前判断的元素是一个序列的起点
                if (!set.contains(num - 1)) {
                    //初始化当前节点和长度
                    int cur = num;
                    int temp = 1;
                    //遍历寻找
                    while (set.contains(cur + 1)) {
                        cur += 1;
                        temp++;
                    }
                    //统计最长序列
                    max = Math.max(max, temp);
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}