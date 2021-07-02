    //给定一个二叉树的根节点 root ，返回它的 中序 遍历。 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 示例 4： 
//
// 
//输入：root = [1,2]
//输出：[2,1]
// 
//
// 示例 5： 
//
// 
//输入：root = [1,null,2]
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
// Related Topics 栈 树 深度优先搜索 二叉树 
// 👍 1008 👎 0

  
package leetcode.editor.cn;

    import leetcode.util.TreeNode;
    import sun.reflect.generics.tree.Tree;

    import java.util.ArrayList;
    import java.util.List;
    import java.util.Stack;

    public class BinaryTreeInorderTraversal{
    public static void main(String[] args) {
        Solution solution = new BinaryTreeInorderTraversal().new Solution();
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
    public List<Integer> inorderTraversal(TreeNode root) {
        //迭代
        if (root == null) {
            return new ArrayList<Integer>();
        }
        //递归转迭代，主要是自己实现压栈，参考递归序进行压栈
        //1.从root开始，将左子树一致压栈
        //2.弹出栈顶
        //3.存储栈顶元素的val
        //4.root指向栈顶元素的右子树 (重复1~4)
        ArrayList<Integer> integers = new ArrayList<Integer>();
        Stack<TreeNode> treeNodes = new Stack<TreeNode>();
        while (root != null || !treeNodes.isEmpty()) {
            while (root != null) {
                treeNodes.push(root);
                root = root.left;
            }
            TreeNode pop = treeNodes.pop();
            integers.add(pop.val);
            root = pop.right;
        }

        return integers;
    }


//    public List<Integer> inorderTraversal(TreeNode root) {
//        //递归
//        if (root == null) {
//            return new ArrayList<Integer>();
//        }
//        ArrayList<Integer> integers = new ArrayList<Integer>();
//        doInorderTraversal(root, integers);
//        return integers;
//    }

    private void doInorderTraversal(TreeNode root, ArrayList<Integer> integers) {
        if (root == null) {
            return;
        }
        doInorderTraversal(root.left, integers);
        integers.add(root.val);
        doInorderTraversal(root.right, integers);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}