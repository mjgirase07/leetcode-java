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
    int maxSum = 0;
    public int maxSumBST(TreeNode root) {
        // if(root == null) return ans;
        // if(isBST(root,Integer.MIN_VALUE,Integer.MAX_VALUE)){
        //     ans = Math.max(ans,sum(root));
        // }
        // maxSumBST(root.left);
        // maxSumBST(root.right);

        postorder(root);
        return maxSum;
    }

    boolean isBST(TreeNode root, int min, int max){
        if(root == null) return true;
        if(root.val>=max || root.val<=min) return false;
        return isBST(root.left,min,root.val) && isBST(root.right, root.val, max);
    }

    int sum(TreeNode root){
        if(root == null) return 0;
        return root.val+sum(root.left)+sum(root.right);
    }

    //returns {isBST,min,max,sum}
    int[] postorder(TreeNode root){
        if(root == null) return new int[]{1,Integer.MAX_VALUE,Integer.MIN_VALUE,0};

        int[] left = postorder(root.left);
        int[] right = postorder(root.right);

        int[] curr = new int[4];

        //if it is not a bst
        if(left[0]==0 || right[0]==0 || root.val<=left[2] || root.val>=right[1]){
            curr[0]=0;
            return curr;
        }

        //bst
        curr[0] = 1;
        curr[1] = Math.min(left[1], root.val);
        curr[2] = Math.max(right[2], root.val);
        curr[3] = left[3]+right[3]+root.val;

        maxSum = Math.max(maxSum,curr[3]);
        return curr;
    }
}