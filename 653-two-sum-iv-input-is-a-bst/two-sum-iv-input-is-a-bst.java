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

public class BSTiterator{
    Stack<TreeNode> stack = new Stack<TreeNode>();
    boolean reverse = true;

    BSTiterator(TreeNode root,boolean isReverse){
        reverse = isReverse;
        pushAll(root);
    }

    public int next(){
        TreeNode root = stack.pop();
        if(reverse){
            pushAll(root.left);
        } else pushAll(root.right);
        return root.val;
    }

    public void pushAll(TreeNode root){
        while(root != null){
            stack.push(root);
            if(reverse){
                root = root.right;
            } else root = root.left;
        }
    }

}

class Solution {
    
    public boolean findTarget(TreeNode root, int k) {
        if(root == null) return false;
        BSTiterator l = new BSTiterator(root, false);
        BSTiterator r = new BSTiterator(root, true);

        int i = l.next();
        int j = r.next();
        while(i<j){
            if(i+j==k) return true;
            else if(i+j<k) i=l.next();
            else j=r.next();
        }
        return false;
    }


}