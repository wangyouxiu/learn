//给你二叉搜索树的根节点 root ，该树中的两个节点被错误地交换。请在不改变其结构的情况下，恢复这棵树。 
//
// 进阶：使用 O(n) 空间复杂度的解法很容易实现。你能想出一个只使用常数空间的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,3,null,null,2]
//输出：[3,1,null,null,2]
//解释：3 不能是 1 左孩子，因为 3 > 1 。交换 1 和 3 使二叉搜索树有效。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,1,4,null,null,2]
//输出：[2,1,4,null,null,3]
//解释：2 不能在 3 的右子树中，因为 2 < 3 。交换 2 和 3 使二叉搜索树有效。 
//
// 
//
// 提示： 
//
// 
// 树上节点的数目在范围 [2, 1000] 内 
// -231 <= Node.val <= 231 - 1 
// 
// Related Topics 树 深度优先搜索 
// 👍 425 👎 0

  
package leetcode.editor.cn;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RecoverBinarySearchTree{
  public static void main(String[] args) {
       Solution solution = new RecoverBinarySearchTree().new Solution();
  }
  
  //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    //判断当前节点、左子节点、右子节点
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }


        //方法1:
//        //中序遍历获得一个递增数组
//        List<Integer> nums = new ArrayList<>();
//        inOrder(root, nums);
//        //线性遍历，找到位置错误的节点的val值
//        //要么就是i,i+1   要么就是i,j+1
//        int[] two = findTwo(nums);
//        //前序遍历，找到对应节点，然后交换
//        recoverTree(root, 2, two[0], two[1]);

        //方法2: 在中序遍历过程中找到那两个错误的节点,使用栈进行
        TreeNode x, y, pre;


    }

    public void inOrder(TreeNode root, TreeNode x, TreeNode y, TreeNode pre) {

    }




    public void inOrder(TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inOrder(root.left, nums);
        nums.add(root.val);
        inOrder(root.right, nums);
    }

    public int[] findTwo(List<Integer> nums) {
        int x = -1, y = -1;
        for (int i = 0; i < nums.size() - 1; i++) {
            if (nums.get(i) > nums.get(i + 1)) {
                y = nums.get(i + 1);
                if (x == -1) {
                    x = nums.get(i);
                }else{
                    break;
                }
            }
        }
        return new int[]{x, y};
    }

    public void recoverTree(TreeNode root, int count, int x, int y) {
        if (root == null) {
            return;
        }
        if (root.val == x || root.val == y) {
            root.val = root.val == x ? y : x;
            if (--count == 0) {
                return;
            }
        }
        recoverTree(root.left, count, x, y);
        recoverTree(root.right, count, x, y);

    }
}
//leetcode submit region end(Prohibit modification and deletion)

}

