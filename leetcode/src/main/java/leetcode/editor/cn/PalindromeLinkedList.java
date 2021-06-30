    //请判断一个链表是否为回文链表。 
//
// 示例 1: 
//
// 输入: 1->2
//输出: false 
//
// 示例 2: 
//
// 输入: 1->2->2->1
//输出: true
// 
//
// 进阶： 
//你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？ 
// Related Topics 栈 递归 链表 双指针 
// 👍 1033 👎 0

  
package leetcode.editor.cn;

    import leetcode.util.ListNode;

    public class PalindromeLinkedList{
    public static void main(String[] args) {
        Solution solution = new PalindromeLinkedList().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    private ListNode p1;

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        p1 = head;
        //使用递归
        return doPalindrome(head);
    }

    private boolean doPalindrome(ListNode head) {
        if (head != null) {
            //可以使链表压栈直到最后
            if (!doPalindrome(head.next)) {
                return false;
            }
            //对比是否相等
            if (head.val != p1.val) {
                return false;
            }
            p1 = p1.next;
        }
        return true;
    }

    //使用快慢指针翻转链表后半部分，对比比较之后再恢复链表
//    public boolean isPalindrome(ListNode head) {
//        if (head == null || head.next == null) {
//            return true;
//        }
//
//        //快慢指针找中点
//        ListNode midNode = getMid(head);
//        //反转链表
//        ListNode reverseNode = reverse(midNode.next);
//
//        //同时遍历
//        ListNode l1 = head;
//        ListNode l2 = reverseNode;
//        boolean result = true;
//        while (result && l2 != null) {
//            if (l1.val != l2.val) {
//                result = false;
//            }
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//
//        //复原链表
//        midNode.next = reverse(reverseNode);
//
//        return result;
//    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public ListNode getMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}