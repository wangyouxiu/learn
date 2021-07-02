//输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。 
//
// 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。 
//
// 
//
// 示例： 
//
// 
//给定一个链表: 1->2->3->4->5, 和 k = 2.
//
//返回链表 4->5. 
// Related Topics 链表 双指针 
// 👍 199 👎 0

  
package leetcode.editor.cn;

import leetcode.util.ListNode;

public class LianBiaoZhongDaoShuDiKgeJieDianLcof{
    public static void main(String[] args) {
        Solution solution = new LianBiaoZhongDaoShuDiKgeJieDianLcof().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        //双指针法，初始化两指针都在head
        //p2先走k步
        //p1,p2同时移动，当p2走到最后时，p1正好在第k个节点
        //返回p1
        ListNode p1 = head;
        ListNode p2 = head;

        for (int i = 0; i < k; i++) {
            if (p2 == null) {
                return null;
            }
            p2 = p2.next;
        }

        while (p2 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }


    //1.遍历链表，进行计数
    //2.判断k是否大于长度，是，直接返回head
    //3.计算差值n
    //4.重新冲head走n步，返回即可
    /*public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        int length = 0;
        while (p1 != null) {
            length++;
            p1 = p1.next;
        }
        if (k >= length) {
            return head;
        }
        int n = length - k;
        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        return head;

    }*/
}
//leetcode submit region end(Prohibit modification and deletion)

}