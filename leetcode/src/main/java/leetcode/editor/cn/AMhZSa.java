//给定一个链表的 头节点 head ，请判断其是否为回文链表。
//
// 如果一个链表是回文，那么链表节点序列从前往后看和从后往前看是相同的。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入: head = [1,2,3,3,2,1]
//输出: true 
//
// 示例 2： 
//
// 
//
// 
//输入: head = [1,2]
//输出: false
// 
//
// 
//
// 提示： 
//
// 
// 链表 L 的长度范围为 [1, 10⁵] 
// 0 <= node.val <= 9 
// 
//
// 
//
// 进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
//
// 
//
// 注意：本题与主站 234 题相同：https://leetcode-cn.com/problems/palindrome-linked-list/ 
// Related Topics 栈 递归 链表 双指针 👍 26 👎 0


package leetcode.editor.cn;

import leetcode.util.ListNode;

public class AMhZSa {
    public static void main(String[] args) {
        Solution solution = new AMhZSa().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        ListNode p1;
        public boolean isPalindrome(ListNode head) {
            if (head == null) {
                return false;
            }
            p1 = head;

            return isPali(head);
        }

        private boolean isPali(ListNode head) {
            if (head == null) {
                return true;
            }

            boolean pali = isPali(head.next);

            if (head.val == p1.val && pali) {
                p1 = p1.next;
                return true;
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}