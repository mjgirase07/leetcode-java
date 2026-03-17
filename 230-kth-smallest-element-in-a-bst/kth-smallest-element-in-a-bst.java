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
    List<Integer> arr = new ArrayList<>();
    public int kthSmallest(TreeNode root, int k) {
        if(root==null) return 0;
        inorder(root);
        return arr.get(k-1);
    }

    void inorder(TreeNode root){
        if(root == null) return;
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }
   
}