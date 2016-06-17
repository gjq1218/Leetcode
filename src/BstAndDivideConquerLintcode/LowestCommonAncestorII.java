package BstAndDivideConquerLintcode;

import java.util.ArrayList;

/**
 * 
 * Given the root and two nodes in a Binary Tree. Find the lowest common ancestor(LCA) of the two nodes.

	The lowest common ancestor is the node with largest depth which is the ancestor of both nodes.
	
	The node has an extra attribute parent which point to the father of itself. The root's parent is null.
	
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
public class LowestCommonAncestorII {
	 class ParentTreeNode {
		 public ParentTreeNode parent, left, right;
	 }
	 public ArrayList<ParentTreeNode> getPath2Root(ParentTreeNode node){
			ArrayList<ParentTreeNode> list = new ArrayList<ParentTreeNode>();
			while(node != null){
				list.add(node);
				node = node.parent;
			}
			return list;
		}
		
	    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
	                                                 ParentTreeNode A,
	                                                 ParentTreeNode B) {
	        ArrayList<ParentTreeNode> list1 =   getPath2Root(A);
	        ArrayList<ParentTreeNode> list2 = getPath2Root(B);
	        
	        int i, j;
	        for( i = list1.size() - 1, j = list2.size() -1; i >= 0 && j >= 0; i--,j-- ){
	        	if(list1.get(i) != list2.get(j)){
	        		return list1.get(i).parent;
	        	}
	        }
	        
	        return list1.get(i + 1);
	    }
}
