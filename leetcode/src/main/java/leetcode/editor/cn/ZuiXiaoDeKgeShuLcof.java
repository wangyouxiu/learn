//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 247 👎 0

  
package leetcode.editor.cn;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ZuiXiaoDeKgeShuLcof{
    public static void main(String[] args) {
        Solution solution = new ZuiXiaoDeKgeShuLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            if (arr.length == 0 || k == 0) {
                return new int[0];
            }
            //默认是小根堆，实现大根堆需要自定义比较器
            PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((v1, v2) -> v2 - v1);
            for (int num : arr) {
                if (priorityQueue.size() < k) {
                    priorityQueue.offer(num);
                } else if (num < priorityQueue.peek()) {
                    priorityQueue.poll();
                    priorityQueue.offer(num);
                }
            }
            int[] res = new int[priorityQueue.size()];
            int index = 0;
            for (int num : priorityQueue) {
                res[index++] = num;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}