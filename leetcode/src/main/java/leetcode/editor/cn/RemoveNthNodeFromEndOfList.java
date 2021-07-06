    //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。 
//
// 进阶：你能尝试使用一趟扫描实现吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5], n = 2
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1], n = 1
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1,2], n = 1
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中结点的数目为 sz 
// 1 <= sz <= 30 
// 0 <= Node.val <= 100 
// 1 <= n <= sz 
// 
// Related Topics 链表 双指针 
// 👍 1439 👎 0

  
package leetcode.editor.cn;

    import leetcode.util.ListNode;

    public class RemoveNthNodeFromEndOfList{
    public static void main(String[] args) {
        Solution solution = new RemoveNthNodeFromEndOfList().new Solution();
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
    public ListNode removeNthFromEnd(ListNode head, int n) {

        /**
         * 双指针解决
         * 1.快指针先走n步
         * 2.快慢指针同时走，当快指针走到链表尾部，慢指针正好在倒数第n个位置上
         * 由于需要删除第n个位置的节点，所以我们如果能够获得倒数第n个位置的前导节点会更方便。
         * 因此，在初始化时，快指针从head开始，慢指针从一个虚节点开始，这样，慢指针最终会指向倒数第n个节点的前导节点
         * 这样的好处还可以避免当链表长度为1，要删除倒数第1个节点的情况。也正是因为这种情况，链表删除完之后就为Null了。
         * 所以返回的时候不能返回head,而是返回虚节点的next。而next在上述情况下是为null的
         */

        ListNode listNode = new ListNode(0, head);

        ListNode p1 = head;
        ListNode p2 = listNode;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }

        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p2.next = p2.next.next;

        return listNode.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}