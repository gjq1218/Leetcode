package BstAndDivideConquerLintcode;

public class FlatternBinaryTreeToLinkeList {
	public class TreeNode {
	     public int val;
	     public TreeNode left, right;
	     public TreeNode(int val) {
	         this.val = val;
	         this.left = this.right = null;
	     }
	}
	private TreeNode lastNode = null;

	public void flatten(TreeNode root) {
	    if (root == null) {
	        return;
	    }
	
	    if (lastNode != null) {
	        lastNode.left = null;
	        lastNode.right = root;
	    }
	
	    lastNode = root;
	    TreeNode right = root.right;
	    flatten(root.left);
	    flatten(right);
	}
	    
    public static void main(String args[]){
    	FlatternBinaryTreeToLinkeList test = new FlatternBinaryTreeToLinkeList();
    	TreeNode n1 = test.new TreeNode(1);
    	TreeNode n2 = test.new TreeNode(2);
    	TreeNode n3 = test.new TreeNode(3);
    	TreeNode n4 = test.new TreeNode(4);
    	TreeNode n5 = test.new TreeNode(5);
    	TreeNode n6 = test.new TreeNode(6);
    	
    	n1.left = n2;
    	n2.left = n3;
    	n2.right = n4;
    	n1.right = n5;
    	n5.right = n6;
    	
    	test.flatten(n1);
    	
    }
	    
	    
}
