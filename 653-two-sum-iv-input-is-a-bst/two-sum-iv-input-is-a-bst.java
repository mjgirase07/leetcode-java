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
    public boolean findTarget(TreeNode root, int k) {
        if(root.left == null && root.right == null) return false;
        inorder(root);
        return twoSum(arr,k);
    }

    void inorder(TreeNode root){
        if(root == null) return;

        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }

    boolean twoSum(List<Integer> arr, int target){
        int l=0, r=arr.size()-1;
        while(l<arr.size()-1){
            if(l == r){
                l++;
                r = arr.size()-1;
            }
            else if(arr.get(l)+arr.get(r) == target){
                return true;
            }else{
                r--;
            }
        }
        return false;
    }
}