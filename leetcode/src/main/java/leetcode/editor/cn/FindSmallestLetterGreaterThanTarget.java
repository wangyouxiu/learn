//给你一个排序后的字符列表 letters ，列表中只包含小写英文字母。另给出一个目标字母 target，请你寻找在这一有序列表里比目标字母大的最小字母。
//
// 在比较时，字母是依序循环出现的。举个例子： 
//
// 
// 如果目标字母 target = 'z' 并且字符列表为 letters = ['a', 'b']，则答案返回 'a' 
// 
//
// 
//
// 示例 1： 
//
// 
//输入: letters = ["c", "f", "j"]，target = "a"
//输出: "c"
// 
//
// 示例 2: 
//
// 
//输入: letters = ["c","f","j"], target = "c"
//输出: "f"
// 
//
// 示例 3: 
//
// 
//输入: letters = ["c","f","j"], target = "d"
//输出: "f"
// 
//
// 
//
// 提示： 
//
// 
// 2 <= letters.length <= 10⁴ 
// letters[i] 是一个小写字母 
// letters 按非递减顺序排序 
// letters 最少包含两个不同的字母 
// target 是一个小写字母 
// 
// Related Topics 数组 二分查找 👍 142 👎 0


package leetcode.editor.cn;

public class FindSmallestLetterGreaterThanTarget {
    public static void main(String[] args) {
        Solution solution = new FindSmallestLetterGreaterThanTarget().new Solution();
        solution.nextGreatestLetter(new char[]{'e', 'e', 'e', 'e', 'e', 'e', 'n', 'n', 'n', 'n'}, 'e');
//        solution.alsearch(new int[]{1, 3, 4, 5, 6, 8, 8, 8, 11, 18}, 7);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public char nextGreatestLetter(char[] letters, char target) {
            // 根据题设,相当于 需要查找,第一个大于 target 的字符的下标
            // 转换为  查找最后一个 小于等于 target 的字符下标 . 该下标后移一位,就是题设寻找的
            // 又因为题中说数组是循环的, 若 target 刚好在数组最后,则返回 index = 0 的字符
            int left = 0, right = letters.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (letters[mid] <= target) {
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            if (right + 1 < letters.length) {
                return letters[right + 1];
            }
            return letters[0];
        }


        // 找到数组中第一个值等于给定值的下标
        public int bsearch(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (nums[mid] >= target) {
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            if (left < nums.length && nums[left] == target) {
                return left;
            }else{
                return -1;
            }
        }


        // 找到数组中最后一个值等于给定值的下标
        public int asearch(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (nums[mid] <= target) {
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            if (right >= 0 && nums[right] == target) {
                return right;
            }else{
                return -1;
            }
        }


        // 查找第一个大于等于给定值的元素
        public int bbsearch(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left <= right) {
                int mid = left + ((right - left) >> 1);
                if (nums[mid] >= target) {
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
            if (left < nums.length && nums[left] > target) {
                return left;
            }else {
                return -1;
            }

        }


        // 查找最后一个小于等于给定值的元素
        public int alsearch(int[] nums, int target) {
            int left = 0, right = nums.length - 1;
            while (left < right) {
                int mid = left + ((right - left) >> 1);
                if (nums[mid] <= target) {
                    left = mid + 1;
                }else{
                    right = mid - 1;
                }
            }
            if (right > 0 && nums[right] < target) {
                return right;
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}