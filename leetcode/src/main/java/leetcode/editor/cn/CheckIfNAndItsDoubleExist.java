//给你一个整数数组 arr，请你检查是否存在两个整数 N 和 M，满足 N 是 M 的两倍（即，N = 2 * M）。
//
// 更正式地，检查是否存在两个下标 i 和 j 满足： 
//
// 
// i != j 
// 0 <= i, j < arr.length 
// arr[i] == 2 * arr[j] 
// 
//
// 
//
// 示例 1： 
//
// 输入：arr = [10,2,5,3]
//输出：true
//解释：N = 10 是 M = 5 的两倍，即 10 = 2 * 5 。
// 
//
// 示例 2： 
//
// 输入：arr = [7,1,14,11]
//输出：true
//解释：N = 14 是 M = 7 的两倍，即 14 = 2 * 7 。
// 
//
// 示例 3： 
//
// 输入：arr = [3,1,7,11]
//输出：false
//解释：在该情况下不存在 N 和 M 满足 N = 2 * M 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= arr.length <= 500 
// -10^3 <= arr[i] <= 10^3 
// 
// Related Topics 数组 哈希表 双指针 二分查找 排序 👍 47 👎 0


package leetcode.editor.cn;

import java.util.*;

public class CheckIfNAndItsDoubleExist {
    public static void main(String[] args) {
        Solution solution = new CheckIfNAndItsDoubleExist().new Solution();
        solution.checkIfExist(new int[]{-10, 12, -20, -8, 15});
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkIfExist(int[] arr) {
            // hash 一次迭代
            Set<Integer> set = new HashSet<>();
            for (int a : arr) {
                if (set.contains(2 * a) || (a % 2 == 0 && set.contains(a / 2))) {
                    return true;
                }
                set.add(a);
            }
            return false;

            // hash
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int i = 0; i < arr.length; i++) {
//                map.put(arr[i], i);
//            }
//            for (int i = 0; i < arr.length; i++) {
//                if (map.containsKey(arr[i] * 2) && map.get(arr[i] * 2) != i) {
//                    return true;
//                }
//            }
//            return false;


            // 二分查找
//            Arrays.sort(arr);
//            int n = arr.length;
//            for (int i = n - 1; i >= 0; i--) {
//                int target = 2 * arr[i], l = 0, r = n - 1;
//                while (l <= r) {
//                    int mid = l + (r - l >> 1);
//                    if (arr[mid] >= target) {
//                        r = mid - 1;
//                    } else {
//                        l = mid + 1;
//                    }
//                }
//                if (l < n && i != l && arr[l] == target) {
//                    return true;
//                }
//            }
//            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}