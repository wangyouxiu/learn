//编写一个函数，检查输入的链表是否是回文的。
//
// 
//
// 示例 1： 
//
// 输入： 1->2
//输出： false 
// 
//
// 示例 2： 
//
// 输入： 1->2->2->1
//输出： true 
// 
//
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 👍 92 👎 0


package leetcode.editor.cn;

import leetcode.util.ListNode;

public class PalindromeLinkedListLcci {
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedListLcci().new Solution();
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
        ListNode p1;
        public boolean isPalindrome(ListNode head) {
            p1 = head;

            return isPali(head);

        }

        private boolean isPali(ListNode head) {
            if (head == null) {
                return true;
            }

            boolean pali = isPali(head.next);

            if (pali && p1.val == head.val) {
                p1 = p1.next;
                return true;
            }
            return false;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}