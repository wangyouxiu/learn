//把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2
//] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。 
//
// 示例 1： 
//
// 输入：[3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 输入：[2,2,2,0,1]
//输出：0
// 
//
// 注意：本题与主站 154 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sor
//ted-array-ii/ 
// Related Topics 二分查找 
// 👍 327 👎 0

  
package leetcode.editor.cn;
public class XuanZhuanShuZuDeZuiXiaoShuZiLcof{
    public static void main(String[] args) {
        Solution solution = new XuanZhuanShuZuDeZuiXiaoShuZiLcof().new Solution();
        int[] arr = new int[]{2, 2, 2, 0, 1};
        solution.minArray(arr);
    }
        //leetcode submit region begin(Prohibit modification and deletion)
        class Solution {
            public int minArray(int[] numbers) {
                if (numbers == null) {
                    return -1;
                }
                if (numbers.length < 2){
                    return numbers[0];
                }
                int l = 0;
                int r = numbers.length - 1;
                while (l < r) {
                    int mid = l + ((r - l) >> 1);
                    if (numbers[mid] < numbers[r]) {
                        r = mid;
                    }else if (numbers[mid] > numbers[r]){
                        l = mid + 1;
                    }else{
                        r -= 1;
                    }
                }
                return numbers[l];
            }
        }
//leetcode submit region end(Prohibit modification and deletion)


//  递归解法
//    class Solution {
//        public int minArray(int[] numbers) {
//            if (numbers == null) {
//                return -1;
//            }
//            if (numbers.length < 2){
//                return numbers[0];
//            }
//
//            return min(numbers, 0, numbers.length - 1);
//        }
//
//        public int min(int[] arr,int l ,int r) {
//            if (l >= r) {
//                return arr[l];
//            }
//            int mid = l + ((r - l) >> 1);
//            int left = min(arr, l, mid);
//            int right = min(arr, mid + 1, r);
//            return Math.min(left, right);
//        }
//    }
}