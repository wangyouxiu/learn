//编写代码，移除未排序链表中的重复节点。保留最开始出现的节点。
//
// 示例1: 
//
// 
// 输入：[1, 2, 3, 3, 2, 1]
// 输出：[1, 2, 3]
// 
//
// 示例2: 
//
// 
// 输入：[1, 1, 1, 1, 2]
// 输出：[1, 2]
// 
//
// 提示： 
//
// 
// 链表长度在[0, 20000]范围内。 
// 链表元素在[0, 20000]范围内。 
// 
//
// 进阶： 
//
// 如果不得使用临时缓冲区，该怎么解决？ 
// Related Topics 哈希表 链表 双指针 👍 140 👎 0


package leetcode.editor.cn;

import leetcode.util.ListNode;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicateNodeLcci {
    public static void main(String[] args) {
        Solution solution = new RemoveDuplicateNodeLcci().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) { val = x; }
     * }
     */
    class Solution {
        public ListNode removeDuplicateNodes(ListNode head) {
            Set<Integer> set = new HashSet<>();
            ListNode helpHead = new ListNode(0);
            helpHead.next = head;
            ListNode p1 = helpHead, p2 = head;
            while (p2 != null) {
                while (p2 != null && set.contains(p2.val)) {
                    p2 = p2.next;
                }
                p1.next = p2;
                p1 = p2;
                if (p2 != null) {
                    set.add(p2.val);
                    p2 = p2.next;
                }
            }
            return helpHead.next;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}