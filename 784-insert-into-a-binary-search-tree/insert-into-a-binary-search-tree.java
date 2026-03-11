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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null) return new TreeNode(val);

        TreeNode cur = root;
        TreeNode prev = cur;
        while(cur!=null){
            prev = cur;
            if(val<cur.val) cur = cur.left;
            else cur = cur.right;
        }
        cur = new TreeNode(val);
        if(cur.val<prev.val) prev.left = cur;
        else prev.right = cur;
        return root;
    }
}