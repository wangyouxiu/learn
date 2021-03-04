package leetcode.util;

import lombok.Data;

/**
 * @ClassName TreeNode
 * @Description TODO
 * @Author Wang Yue
 * @Date 2021/3/4 16:31
 */

@Data
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
