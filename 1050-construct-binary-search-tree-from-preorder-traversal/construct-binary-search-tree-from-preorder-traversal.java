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
    public TreeNode bstFromPreorder(int[] preorder) {
        int n = preorder.length;
        int[] inorder = new int[n];
        for(int i=0; i<n; i++){
            inorder[i] = preorder[i];
        }
        Arrays.sort(inorder);
        Map<Integer,Integer> inMap = new HashMap<>();
        for(int i=0; i<n; i++){
            inMap.put(inorder[i],i);
        }
        TreeNode root = buildTree(preorder,0,n-1,inorder,0,n-1,inMap);
        return root;
    }

    TreeNode buildTree(int[] preorder, int pStart, int pEnd,int[] inorder, int iStart, int iEnd, Map<Integer,Integer> inMap){
        
        if(pStart>pEnd || iStart>iEnd) return null;

        TreeNode root = new TreeNode(preorder[pStart]);
        int iRoot = inMap.get(preorder[pStart]);
        int left = iRoot-iStart;

        root.left = buildTree(preorder,pStart+1,pStart+left,inorder,iStart,iRoot-1,inMap);
        root.right = buildTree(preorder,pStart+1+left,pEnd,inorder,iRoot+1,iEnd,inMap);
        return root;
    }
    
}