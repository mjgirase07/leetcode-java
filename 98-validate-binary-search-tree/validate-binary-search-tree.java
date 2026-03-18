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
    ArrayList<Integer> arr = new ArrayList<>();
    public boolean isValidBST(TreeNode root) {
        if(root.left == null && root.right == null) return true;
        //inorder(root);
        //return helper(arr);
        return preorder(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    void inorder(TreeNode root){
        if(root!=null){
            inorder(root.left);
            arr.add(root.val);
            inorder(root.right);
        }
    }

    boolean helper(ArrayList<Integer> arr){
        int i=0,j;
        for(j=1; j<arr.size(); j++){
            if(arr.get(j)>arr.get(i)) i++;
            else return false;
        }
        return true;
    }

    boolean preorder(TreeNode root,long min, long max){
        if(root == null) return true;
            if(root.val>=max || root.val<=min) return false;
            return preorder(root.left,min,root.val) &&
            preorder(root.right,root.val,max);
    }

}