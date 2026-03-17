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
    private int result;
    private int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        this.result = -1;
        
        inorder(root);
        
        return result;
    }

    void inorder(TreeNode root){
        if(root != null){
            inorder(root.left);
            if(--k==0){
                result = root.val;
                return;
            }
            inorder(root.right);
        }
        
    }
   
}