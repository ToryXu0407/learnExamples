package leetcode;

/**
 * @author toryxu
 * @version 1.0
 * @date 2021/4/25 9:46 下午
 */

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
public class Tree {
    class Solution {
        public TreeNode increasingBST(TreeNode root) {
            List<Integer> vals = new ArrayList<>();
            getNode(root, vals);

            TreeNode result = new TreeNode(-1);
            TreeNode currNode = result;

            for (Integer val : vals) {
                currNode.val = val;
                currNode.right = new TreeNode();
                currNode = currNode.right;
            }
            return currNode;
        }

        //遍历的真谛
        private void getNode(TreeNode root, List<Integer> vals) {
            if (root == null) {
                return;
            }
            getNode(root.left, vals);
            vals.add(root.val);
            getNode(root.right, vals);
        }
    }


    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
