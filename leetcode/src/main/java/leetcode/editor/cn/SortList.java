//给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
//
// 进阶： 
//
// 
// 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [4,2,1,3]
//输出：[1,2,3,4]
// 
//
// 示例 2： 
//
// 
//输入：head = [-1,5,3,4,0]
//输出：[-1,0,3,4,5]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 5 * 104] 内 
// -105 <= Node.val <= 105 
// 
// Related Topics 链表 双指针 分治 排序 归并排序 
// 👍 1213 👎 0


package leetcode.editor.cn;

import leetcode.util.ListNode;

public class SortList {
    public static void main(String[] args) {
        Solution solution = new SortList().new Solution();

        ListNode listNode = new ListNode(4, new ListNode(2, new ListNode(1, new ListNode(3))));
        solution.sortList(listNode);
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

        /**
         * 自顶向下的归并排序
         *
         * @param head
         * @return
         */
        public ListNode sortList(ListNode head) {
            return sortList(head, null);
        }

        public ListNode sortList(ListNode head, ListNode tail) {
            if (head == null) {
                return null;
            }

            if (head.next == tail) {
                head.next = null;
                return head;
            }

            //快慢指针求中点
            ListNode fast = head, slow = head;
            while (fast != tail) {
                fast = fast.next;
                slow = slow.next;
                if (fast != tail) {
                    fast = fast.next;
                }
            }
            ListNode list1 = sortList(head, slow);
            ListNode list2 = sortList(slow, tail);
            return merge(list1, list2);
        }

        private ListNode merge(ListNode list1, ListNode list2) {
            ListNode head = new ListNode(0), p1 = head;
            while (list1 != null && list2 != null) {
                if (list1.val <= list2.val) {
                    p1.next = list1;
                    list1 = list1.next;
                }else{
                    p1.next = list2;
                    list2 = list2.next;
                }
                p1 = p1.next;
            }
            if (list1 != null) {
                p1.next = list1;
            }
            if (list2 != null) {
                p1.next = list2;
            }
            return head.next;
        }
        

        /**
         * 自底向上的归并排序
         * 1.用subLength表示需要排序的链表长度，初始化为1，之后每次翻倍
         * 2.将链表按照subLength长度进行分割，然后合并分割的两端链表
         * 3.subLength加倍，然后重复步骤2
         *
         * @param head
         * @return
         */
//        public ListNode sortList(ListNode head) {
//            if (head == null) {
//                return null;
//            }
//            int length = 0;
//            ListNode node = head;
//            while (node != null) {
//                length++;
//                node = node.next;
//            }
//
//            ListNode tempHead = new ListNode(0, head);
//            for (int i = 1; i <= length; i <<= 1) {
//                ListNode cur = tempHead.next, prev = tempHead;
//                while (cur != null) {
//                    ListNode p1 = cur;
//                    for (int j = 1; j < i && cur.next != null; j++) {
//                        cur = cur.next;
//                    }
//                    ListNode p2 = cur.next;
//                    cur.next = null;
//                    cur = p2;
//                    for (int j = 1; j < i && cur != null && cur.next != null; j++) {
//                        cur = cur.next;
//                    }
//                    ListNode temp = null;
//                    if (cur != null) {
//                        temp = cur.next;
//                        cur.next = null;
//                    }
//                    ListNode merge = merge(p1, p2);
//                    prev.next = merge;
//                    while (prev.next != null) {
//                        prev = prev.next;
//                    }
//                    cur = temp;
//                }
//            }
//            return tempHead.next;
//        }
//
//        private ListNode merge(ListNode p1, ListNode p2) {
//            ListNode h1 = p1, h2 = p2, head = new ListNode(0), p3 = head;
//            while (h1 != null && h2 != null) {
//                if (h1.val <= h2.val) {
//                    p3.next = h1;
//                    h1 = h1.next;
//                }else{
//                    p3.next = h2;
//                    h2 = h2.next;
//                }
//                p3 = p3.next;
//            }
//            if (h1 != null) {
//                p3.next = h1;
//            } else if (h2 != null) {
//                p3.next = h2;
//            }
//            return head.next;
//        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}