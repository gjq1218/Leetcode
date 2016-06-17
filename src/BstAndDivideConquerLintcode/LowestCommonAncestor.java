package BstAndDivideConquerLintcode;
/**
 
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.
	
	The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
	
	Have you met this question in a real interview? Yes
	Example
	For the following binary tree:
	
	  4
	 / \
	3   7
	   / \
	  5   6
	LCA(3, 5) = 4
	
	LCA(5, 6) = 7
	
	LCA(6, 7) = 7
	
 * @author SirusBlack
 *
 */
public class LowestCommonAncestor {
	
	 public class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
	 }
	 
	// 在root为根的二叉树中找A,B的LCA:
    // 如果找到了就返回这个LCA
    // 如果只碰到A，就返回A
    // 如果只碰到B，就返回B
    // 如果都没有，就返回null
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        
        if(root == null || root == A || root == B){
            return root;
        }
        
        //Divide
        
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        //Conquer
        if(left != null && right !=null){
            return root;
        }
        
        if(left != null){
            return left;
        }
        if(right != null){
            return right;
        }
        
        return null;
        
    }
}
