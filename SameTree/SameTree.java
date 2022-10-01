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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.add(p);
        q2.add(q);
        TreeNode pCurrent;
        TreeNode qCurrent;
        // null checking 
        if (p == null && q == null) return true;
        if (p == null) return false;
        if (q == null) return false;
        //
        while(!q1.isEmpty() || !q2.isEmpty()){
            pCurrent = q1.remove() ;
            qCurrent = q2.remove();
            // checking 
            if (pCurrent.val != qCurrent.val){ return false ;}
            //Checking children for null 
            if (pCurrent.left == null && qCurrent.left != null){return false ;}
            if (pCurrent.left != null && qCurrent.left == null){return false ;}
            if (pCurrent.right == null && qCurrent.right != null){return false;}
            if (pCurrent.right != null && qCurrent.right == null){return false;}
            
            // Adding to the queue the children 
            if (pCurrent.left != null){q1.add(pCurrent.left);}
            if (pCurrent.right != null){q1.add(pCurrent.right);}
            if (qCurrent.left != null){q2.add(qCurrent.left);}
            if (qCurrent.right != null){q2.add(qCurrent.right);}
            
        } 
        return true; 
    }
}