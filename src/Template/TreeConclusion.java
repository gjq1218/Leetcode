package Template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
	* REFS:
	* http://blog.sina.com.cn/s/blog_eb52001d0102v1si.html
	* http://zisong.me/post/suan-fa/geng-jian-dan-de-bian-li-er-cha-shu-de-fang-fa
	* http://www.nowamagic.net/librarys/veda/detail/2314
	* http://zisong.me/post/suan-fa/ren-nao-li-jie-di-gui
	* https://github.com/yuzhangcmu/LeetCode/blob/master/tree/TreeDemo.java
	
	1.非递归遍历：前序遍历 preorderTraversal， 中序遍历 inorderTraversal， 后序遍历 2个方法：a) 正着想 postorderTraversal b)利用从右到左前序遍历的逆序。postorderTraversal2
	  分层遍历 迭代法 levelTraversal
	  递归遍历：前序遍历 preorderTraversalRec，中序遍历 inorderTraversalRec， 后序遍历 postorderTraversalRec。
	
	2.求二叉树中的结点个数 - 递归 getNodeNumRec
	
	3.求二叉树的最大/最小深度
		a) divide and conquer - 分治法 -  getDepthRec， 
		b) Traverse - 求二叉树的最大深度  - getDepth
	
	4.判断是否为二叉平衡树 isBalanced 
		a) 递归 左右子树的高度不能相差1 利用depth方法 
		b) 可以将depth和balanced写在一个constructor里面，一起构建
	
	5. 求二叉树路径最大和  
		a) maxPathSum - Any to Any node. 
		b) maxPathSum2 - Root to Any node
	
	6.有效二叉搜索树 Validate Binary Search Tree - Divide and Conquer
	
	7.求二叉树中 LCA 最近公共祖先 - lowestCommonAncestor
		a) 没有父亲节点的信息 lowestCommonAncestor
		b) 求二叉树中 LCA 最近公共祖先 - 有父亲节点的信息 Lowest Common Ancestor II
		c) 求BST中 LCA 最近公共祖先
	
	8.求两棵树是不是same Tree/identical Tree
	  求两棵树是不是扭转后等价的二叉树 - TweakedIdenticalBinaryTree. 跟9）对称树非常相像。
	
	
	9.判断一棵树是不是对称树Symmetric，（即root的两个子树互为镜像。） 参看same tree的思路来做。 Symmetric Binary Tree - Recursion
	 9.1 a)判断两棵树是不是互为镜像。Recursively。 跟 9.Symmetric Tree 想法一模一样。直接使用其第二个函数即可。
	 	 b)判断两棵树是不是互为镜像。Iteratively。
	
	10. 求一颗二叉树的镜像：（破坏与不破坏两种情况。）
		破坏原来的树: mirrorRec, mirror 
		创建一颗新数：mirrorCopyRec， mirrorCopy 
		 
	11.求是不是完全二叉树 - isComplete
		a) 非递归解法 Complete Binary Tree 
		b) 递归解法 Complete Binary Tree 及复习重要概念
 	
 	12. a)由前序遍历序列和中序遍历序列重建二叉树 Recursion buildTreeFromInPre
 	    b) 由后序遍历序列和中序遍历序列重建二叉树 Recursion buildTreeFromInPos
		
 * @author SirusBlack

 *
 */

public class TreeConclusion {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	
	/**
	 *  1.前序遍历 非递归
	 * 	Pre-Order - non recursively.
	 *  DFS 的思想,访问根节点，右边先入栈，左边后入栈。 DFS uses stack， BFS uses Queue
	 *   5
	   3   7
	  2 4 5 9	
	  output sequence:  5324769
	 * **/
	public ArrayList<Integer> preorderTraversal(TreeNode root){
		ArrayList<Integer> res = new ArrayList<Integer>();
		
		if(root == null){
			return res;
		}
		
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		
		while(!stack.isEmpty()){
			TreeNode node = stack.pop();
			//visit the root.
			res.add(node.val);
			// add right node firstly.
			if(node.right != null){
				stack.push(node.right);
			}
			// add left node secondly.
			if(node.left != null){
				stack.push(node.left);
			}
		}
		
		return res;
	}
	
	
	/**
	 * 中序遍历 非递归
	 * In-Order - non recursively
	 * 先用栈把根节点的以及它所有左孩子都添加到站内，然后输出栈顶元素，再处理栈顶元素的右子树
	 * output sequence:
	 * 	 5
	   3   7
	  2 4 8 9         
	  output sequence: 2345879
	 * **/
  	public ArrayList<Integer> inorderTraversal(TreeNode root){
		ArrayList<Integer> res = new ArrayList<Integer>();
		if(root == null){
			return res;
		}
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode cur = root;
		while(true){
			//把当前节点的所有左节点push到栈中。
			while(cur != null){
				stack.push(cur);
				cur = cur.left;
			}			
			if(stack.isEmpty()){
				break;
			}			
			//此时已经没有左孩子，开始输出栈顶元素。
			cur = stack.pop();
			res.add(cur.val);
			cur = cur.right;
		}
		return res;
	}  	

  	
	/**
	 * 后序遍历 非递归 方法一（不太好想）
	 * Post-Order non-recursively
	 * 正着想不好想：参见下面另一个方法。
	 * 把所有的做孩子相继入栈（是一个循环的过程）
	 * 这是P指向最左边的孩子
	 * 重复：若p没有右孩子（或者p的右孩子节点已经输出），则输出p，同时出栈，将值赋给p
	 * 若p有右孩子节点，则将p入栈，同时p指向其右孩子节点。
	 * 重复以上步骤，直到p为空。
	 * 	 5
	   3   7
	  2 4 8 9
  	output sequence: 2438975
	 *  
	 **/	  
  	public ArrayList<Integer> postorderTraversal(TreeNode root){
  		ArrayList<Integer> res = new ArrayList<Integer>();
  		if(root == null){
			return res;
		}
  		
  		TreeNode pnode = root;
  		Stack<TreeNode> stack = new Stack<TreeNode>();
  		TreeNode LastVisit = null;
  		
  		while(pnode != null || !stack.isEmpty()){
  			while(pnode != null){
  				stack.push(pnode);
  				pnode = pnode.left;
  			}
  			
  			pnode = stack.peek();
  			
  			if(pnode.right == null || pnode.right == LastVisit){
  				res.add(pnode.val);
  				LastVisit = pnode;
  				stack.pop();
  				pnode = null;
  			}else{
  				pnode = pnode.right;
  			}  			
  		}
  		return res;
  	}

  	
	/**
	 * 后序遍历 非递归 方法二（很好想！）
	 * Post-Order non-recursively
	 * 从左到右的后序， 相当于 从右到左的前序遍历的逆序，只需要另外一个栈进行翻转即可。
	 * 	 5
	   3   7
	  2 4 8 9
  	output sequence: 2438975
	 * 
	 **/
  	public ArrayList<Integer> postorderTraversal2(TreeNode root){
  		ArrayList<Integer> res = new ArrayList<Integer>();
  		if(root == null){
  			return res;
  		}
  		Stack<TreeNode> stack = new Stack<TreeNode>();
  		Stack<TreeNode> out = new Stack<TreeNode>();
  		
  		stack.push(root);
  		// after the first while, the sequence will be 5798342.
  		while(!stack.isEmpty()){
  			TreeNode cur = stack.pop();
  			out.push(cur);
  			
  			if(cur.left != null){
  				stack.push(cur.left);
  			}
  			
  			if(cur.right != null){
  				stack.push(cur.right);
  			}
  		}
  		// reverse the sequence.
  		while(!out.isEmpty()){
  			res.add(out.pop().val);
  		}
  		return res;
  	}
  
  	
  	/**
  	 * 分层遍历二叉树（按层次从上到下，从左往右）迭代
  	 * Level-Order - which is actually BFS - use queue.
  	 * 宽度优先搜索，使用队列。队列初始化，将根节点压入栈，当队列不为空时：
  	 * 弹出一个节点，访问，若子节点或者右节点不为空，压入栈。
  	 */  	
  	public ArrayList<Integer> levelTraversal(TreeNode root){
  		ArrayList<Integer> res = new ArrayList<Integer>();
  		if(root == null){
  			return res;
  		}
  		
  		Queue<TreeNode> queue = new LinkedList<TreeNode>();
  		queue.offer(root);
  		
  		while(!queue.isEmpty()){
  			TreeNode cur = queue.poll();
  			res.add(cur.val);
  			if(cur.left != null){
  				queue.offer(cur.left);
  			}
  			if(cur.right != null){
  				queue.offer(cur.right);
  			}
  		}
  		return res;
  	}
  
  	/**
  	 * 前序递归遍历
  	 * **/
  	public static void preorderTraversalRec(TreeNode root){
  		if(root == null){
  			return;
  		}
  		System.out.println(root.val + " ");
  		preorderTraversalRec(root.left);
  		preorderTraversalRec(root.right);
  	}
  	
  	/**
  	 * 中序递归遍历
  	 * **/
  	public static void inorderTraversalRec(TreeNode root){
  		if(root == null){
  			return;
  		}
  	
  		inorderTraversalRec(root.left);
  		System.out.println(root.val + " ");
  		inorderTraversalRec(root.right);
  	}
  	
  	/**
  	 * 后序递归遍历
  	 * **/
  	public static void postorderTraversalRec(TreeNode root){
  		if(root == null){
  			return;
  		} 	
  		postorderTraversalRec(root.left); 		
  		postorderTraversalRec(root.right);
  		System.out.println(root.val + " ");
  	}
  	
  	
	/**
	 * 2. 求二叉树中的节点个数:递归方法 getNodeNumRec Get the size of left tree node and right
	 * tree node.
	 * 
	 * @param args
	 */

	public static int getNodeNumRec(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return getNodeNumRec(root.left) + getNodeNumRec(root.right) + 1;
	}

	/**
	 * 3.求二叉树的最大/最小深度： 分治方法 Maximum Depth of Binary Tree Divide and Conquer -
	 * 主函数有返回值，不需要重新写新的方法，老大哥各派两个小弟进行收集。直接返回结果。
	 * 
	 * @param root
	 * @return
	 */
	public static int getDepthRec(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int left = getDepthRec(root.left);
		int right = getDepthRec(root.right);
		return Math.max(left + 1, right + 1);
	}

	/**
	 * 求二叉树的深度：Traverse Maximum Depth of Binary Tree getDepth Traverse -
	 * Traverse的方法： 主函数有返回值，一般要调用一个新的无返回值的函数，老大哥自己亲力亲为，拿着小篮子去收集结果。
	 * 
	 * @param root
	 * @return
	 */
	private int max;

	public int getDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		this.max = -1;
		traverse(root, 1);
		return this.max;
	}

	public void traverse(TreeNode root, int depth) {
		if (root == null) {
			return;
		}
		if (depth > this.max) {
			this.max = depth;
		}

		traverse(root.left, depth + 1);
		traverse(root.right, depth + 1);
	}

	/**
	 * 4.判断是否为二叉平衡树 方法1 Balanced Binary Tree Judge if Binary Tree is a Balanced
	 * Binary Tree. Balanced binary Tree Definition: A height-balanced binary
	 * tree is defined as a binary tree in which the depth of the two subtrees
	 * of every node never differ by more than 1. An AVL tree is a
	 * self-balancing binary "search" tree! 左右子树的高度不能相差1 利用depth方法。 左右子树都是平衡二叉树
	 * 
	 * @param args
	 */
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		if (!isBalanced(root.left) || isBalanced(root.right)) {
			return false;
		}

		int dif = Math.abs(getDepth(root.left) - getDepth(root.right));
		if (dif > 1) {
			return false;
		}
		return true;
	}

	/**
	 * 判断是否为二叉平衡树 方法2 Balanced Binary Tree
	 * 可以将depth和balanced写在一个constructor里面，一起构建
	 * 
	 * @param args
	 */
	class ResultTypeBbt {
		public boolean isBalanced;
		public int maxDepth;

		public ResultTypeBbt(boolean isBalanced, int maxDepth) {
			this.isBalanced = isBalanced;
			this.maxDepth = maxDepth;
		}
	}

	public boolean isBalanced2(TreeNode root) {
		return helperBbt(root).isBalanced;
	}

	public ResultTypeBbt helperBbt(TreeNode root) {
		if (root == null) {
			return new ResultTypeBbt(true, 0);
		}
		ResultTypeBbt left = helperBbt(root.left);
		ResultTypeBbt right = helperBbt(root.right);

		// subtree not balance
		if (!left.isBalanced || !right.isBalanced) {
			return new ResultTypeBbt(false, -1);
		}
		// root not balance
		if (Math.abs(left.maxDepth - right.maxDepth) > 1) {
			return new ResultTypeBbt(false, -1);
		}
		return new ResultTypeBbt(true,
				Math.max(left.maxDepth, right.maxDepth) + 1);
	}

	/**
	 * 5.求二叉树路径最大和。Any to Any node. Binary Tree Maximum Path Sum Important
	 * question to understand divide and conquer!!!!!!!!!! Given a binary tree,
	 * find the maximum path sum. The path may start and end at any node in the
	 * tree.
	 * 
	 * @param args
	 */
	public class ResultTypeBTMPS {
		int singlePath, maxPath;

		ResultTypeBTMPS(int singlePath, int maxPath) {
			// singlePath is from root node to any node, the maximum path sum.
			this.singlePath = singlePath;
			// maxPath is from any node to any node, the maximum path sum.
			this.maxPath = maxPath;
		}
	}

	public int maxPathSum(TreeNode root) {
		ResultTypeBTMPS result = helperBTMS(root.left);
		return result.maxPath;
	}

	public ResultTypeBTMPS helperBTMS(TreeNode root) {
		if (root == null) {
			return new ResultTypeBTMPS(Integer.MIN_VALUE, Integer.MIN_VALUE);
		}

		// Divide
		ResultTypeBTMPS left = helperBTMS(root.left);
		ResultTypeBTMPS right = helperBTMS(root.right);

		// Conquer ==> root to any
		int singlePath = Math.max(0,
				Math.max(left.singlePath, right.singlePath))
				+ root.val;

		// Conquer ==> any to any ==> get the largest maxpath sum of left or
		// right node.
		int maxPath = Math.max(left.maxPath, right.maxPath);

		// Conquer => Any to Any
		maxPath = Math.max(maxPath,
				Math.max(left.singlePath, 0) + Math.max(right.singlePath, 0)
						+ root.val);

		return new ResultTypeBTMPS(singlePath, maxPath);
	}

	/**
	 * 求二叉树路径最大和。Root to Any node. Binary Tree Maximum Path Sum II Given a
	 * binary tree, find the maximum path sum from root.
	 * 
	 * @param args
	 */
	public int maxPathSum2(TreeNode root) {
		if (root == null) {
			return Integer.MIN_VALUE;
		}
		int left = maxPathSum2(root.left);
		int right = maxPathSum2(root.right);

		if (left < 0 && right < 0) {
			return root.val;
		} else {
			return Math.max(left, right) + root.val;
		}
	}

	/**
	 * 6.有效二叉搜索树 Validate Binary Search Tree Divide and Conquer
	 * 
	 * @param args
	 */
	public class ResultTypeVBST {
		boolean is_bst;
		int maxValue;
		int minValue;

		public ResultTypeVBST(boolean is_bst, int maxValue, int minValue) {
			this.is_bst = is_bst;
			this.maxValue = maxValue;
			this.minValue = minValue;
		}
	}

	public boolean isValidBST(TreeNode root) {
		ResultTypeVBST res = validatehelper(root);
		return res.is_bst;
	}

	public ResultTypeVBST validatehelper(TreeNode root) {
		if (root == null) {
			return new ResultTypeVBST(true, Integer.MIN_VALUE,
					Integer.MAX_VALUE);
		}

		ResultTypeVBST left = validatehelper(root.left);
		ResultTypeVBST right = validatehelper(root.right);

		if (!left.is_bst || !right.is_bst) {
			// left and right tree should be balanced at first.
			return new ResultTypeVBST(false, 0, 0);
		}

		if (root.left != null && left.maxValue >= root.val
				|| root.right != null && right.minValue <= root.val) {
			return new ResultTypeVBST(false, 0, 0);
		}

		return new ResultTypeVBST(true, Math.max(root.val, right.maxValue),
				Math.min(root.val, left.minValue));

	}

	/**
	 * 7.求二叉树中 LCA 最近公共祖先 - 没有父亲节点的信息 Lowest Common Ancestor 求二叉树中的两个节点的最近公共祖先 The
	 * lowest common ancestor is the node with largest depth which is the
	 * ancestor of both nodes. 在root为根的二叉树中找A,B的LCA: 如果找到了就返回这个LCA 如果只碰到A，就返回A
	 * 如果只碰到B，就返回B 如果都没有，就返回null 时间 O(h) 空间 O(h) 递归栈空间 ??????
	 * https://segmentfault.com/a/1190000003509399
	 * 
	 * @param args
	 */
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
		// 发现目标节点则通过返回值标记该子树发现了某个目标结点
		if (root == null || A == root || B == root) {
			return root;
		}

		// Divide
		// 查看左子树中是否有目标结点，没有为null
		TreeNode left = lowestCommonAncestor(root.left, A, B);
		// 查看右子树是否有目标节点，没有为null
		TreeNode right = lowestCommonAncestor(root.right, A, B);

		// Conquer
		// 都不为空，说明做右子树都有目标结点，则公共祖先就是本身
		if (left != null && right != null) {
			return root;
		}

		// 如果发现了目标节点，则继续向上标记为该目标节点
		if (left != null) {
			return left;
		}

		if (right != null) {
			return right;
		}

		return null;
	}

	/**
	 * 求二叉树中 LCA 最近公共祖先 - 有父亲节点的信息 Lowest Common Ancestor II
	 * 那么只需要记录A到root的path和B到root的path， 然后逐一进行比较
	 */
	class ParentTreeNode {
		public ParentTreeNode parent, left, right;
	}

	public ArrayList<ParentTreeNode> getPath2Root(ParentTreeNode node) {
		ArrayList<ParentTreeNode> list = new ArrayList<ParentTreeNode>();
		while (node != null) {
			list.add(node);
			node = node.parent;
		}
		return list;
	}

	public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root,
			ParentTreeNode A, ParentTreeNode B) {
		ArrayList<ParentTreeNode> list1 = getPath2Root(A);
		ArrayList<ParentTreeNode> list2 = getPath2Root(B);

		int i, j;
		for (i = list1.size() - 1, j = list2.size() - 1; i >= 0 && j >= 0; i--, j--) {
			if (list1.get(i) != list2.get(j)) {
				return list1.get(i).parent;
			}
		}
		return list1.get(i + 1);
	}

	/**
	 * 求BST中 LCA 最近公共祖先
	 * 遍历树的时候，如果当前结点大于两个节点，则结果在当前结点的左子树里，如果当前结点小于两个节点，则结果在当前节点的右子树里。
	 * 
	 * @param args
	 */
	public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p,
			TreeNode q) {
		if (root.val > p.val && root.val > q.val) {
			return lowestCommonAncestorBST(root.left, p, q);
		}
		if (root.val < p.val && root.val < q.val) {
			return lowestCommonAncestorBST(root.right, p, q);
		}
		return root;
	}

	/**
	 * 8.求两棵树是不是same Tree/identical Tree
	 * 样例
	    1             1
	   / \           / \
	  2   2   and   2   2
	 /             /
	4             4

	 * @param args
	 */
	public boolean isIdentical(TreeNode a, TreeNode b) {
		if (a == null && b == null) {
			return true;
		} else if (a != null && b != null) {
			if (a.val == b.val) {
				return isIdentical(a.left, b.left)
						&& isIdentical(a.right, b.right);
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	
	/**
	 * 求两棵树是不是扭转后等价的二叉树 - TweakedIdenticalBinaryTree.
	 * Check two given binary trees are identical or not. 
	 * Assuming any number of tweaks are allowed. 
	 * A tweak is defined as a swap of the children of one node in the tree.
	 * 样例
	    1             1
	   / \           / \
	  2   3   and   3   2
	 /                   \
	  * 
	 */
	 public boolean isTweakedIdentical(TreeNode a, TreeNode b) {
	      if(a ==  null && b == null){
	    	  return true;
	      }else if( a != null && b != null){
	    	 if(a.val == b.val){
	    		return isTweakedIdentical(a.left, b.left) && isTweakedIdentical(a.right, b.right) || isTweakedIdentical(a.left, b.right) && isTweakedIdentical(a.right, b.left);
	    	 }else{
	    		 return false;
	    	 }
	      }else{
	    	  return false;
	      }
	 }
	 

	/**
	 * 9.判断一棵树是不是对称树 Symmetric， 参看same tree的思路来做。 Symmetric Binary Tree - Recursion
	 * 另一个想法是：从左到右preorder和从右到左preorder得到的sequence应该一样。但是这个想法不能用在两棵树上，因为会有反例。
	 * 样例
	    1
	   / \
	  2   2
	 / \ / \
	3  4 4  3

	 * 
	 * @param args
	 */

	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}
		return isSymmetricRec(root.left, root.right);
	}

	public boolean isSymmetricRec(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		} else {
			if (p.val == q.val) {
				return isSymmetricRec(p.left, q.right)
						&& isSymmetricRec(p.right, q.left);
			} else {
				return false;
			}
		}
	}

	/**
	 *9.1
	 * 判断两棵树是不是互为镜像。Recursively。 跟 9.Symmetric Tree 想法一模一样。直接使用其第二个函数即可。
	 * 1) 根必须同时为空或者是同时不为空。
	 * 如果根不为空，
	 * 1）根值一样。
	 * 2）r1的左树是r2的右树的镜像。
	 * 3）r2的左树是r1的右树的镜像。
	 * 
	 */
	
	public boolean isMirrorRec(TreeNode p, TreeNode q) {
		if (p == null && q == null) {
			return true;
		}
		if (p == null || q == null) {
			return false;
		} else {
			if (p.val == q.val) {
				return isSymmetricRec(p.left, q.right)
						&& isSymmetricRec(p.right, q.left);
			} else {
				return false;
			}
		}
	}
	
	/**
	 * 9.1
	 * 判断两棵树是不是互为镜像。	Iteratively。
	 * 1） 根必须同时为空，或是同时不为空
     * 
     * 如果根不为空:
     * traversal 整个树，判断它们是不是镜像，每次都按照反向来traversal  
     * 1）当前节点的值相等
     * 2）当前节点的左右节点要镜像，
     *   无论是左节点，还是右节点，对应另外一棵树的镜像位置，可以同时为空，或是同时不为空，但是不可以一个为空，一个不为空。      
     * */

	  public static boolean isMirror(TreeNode r1, TreeNode r2){  
	        // 如果2个树都是空树
	        if (r1 == null && r2 == null) {
	            return true;
	        }
	        
	        // 如果其中一个为空，则返回false.
	        if (r1 == null || r2 == null) {
	            return false;
	        }
	        
	        Stack<TreeNode> s1 = new Stack<TreeNode>();
	        Stack<TreeNode> s2 = new Stack<TreeNode>();
	        
	        s1.push(r1);
	        s2.push(r2);
	        
	        while (!s1.isEmpty() && !s2.isEmpty()) {
	            TreeNode cur1 = s1.pop();
	            TreeNode cur2 = s2.pop();
	            
	            // 弹出的节点的值必须相等 
	            if (cur1.val != cur2.val) {
	                return false;
	            }
	            
	            // tree1的左节点，tree2的右节点，可以同时不为空，也可以同时为空，否则返回false.
	            TreeNode left1 = cur1.left;
	            TreeNode right1 = cur1.right;
	            TreeNode left2 = cur2.left;
	            TreeNode right2 = cur2.right;
	            
	            if (left1 != null && right2 != null) {
	                s1.push(left1);
	                s2.push(right2);
	            } else if (!(left1 == null && right2 == null)) {
	                return false;
	            }
	            
	            // tree1的左节点，tree2的右节点，可以同时不为空，也可以同时为空，否则返回false.
	            if (right1 != null && left2 != null) {
	                s1.push(right1);
	                s2.push(left2);
	            } else if (!(right1 == null && left2 == null)) {
	                return false;
	            }
	        }
	        
	        return true;
	    }  
	    

	/**
	 * 10. 求一颗二叉树的镜像 递归解法 破坏原来的树 binary tree mirror。 Recursively.
	 * Invert a binary tree.破坏原来的树。 
	 * Example
	  1         1
	 / \       / \
	2   3  => 3   2
	   /       \
	  4         4
	 * @param args
	 */
	
    public void invertBinaryTree(TreeNode root) {
        // write your code here
    	if(root == null){
    		return ;
    	}
    	mirrorRec(root);
    	
    }
  
    public TreeNode mirrorRec(TreeNode root){
    	
    	if(root == null){
    		return root;
    	}
    	
    	TreeNode tmp = root.right;
    	root.right = mirrorRec(root.left);
    	root.left = mirrorRec(tmp);
    	return root;
    }
    
	/**
	 * 求一颗二叉树的镜像 非递归解法 破坏原来的树。binary tree mirror。 Iteratively
	 * Invert a binary tree.破坏原来的树。 
	 *  应该可以使用任何一种Traversal 方法。 用什么顺序访问树不重要，重要的是让每一个节点的左右节点互换即可达到mirror效果。
     *  现在可以试看看使用最简单的前序遍历。
	 * Example
	  1         1
	 / \       / \
	2   3  => 3   2
	   /       \
	  4         4
	 * @param args
	 */
	public TreeNode mirror(TreeNode root){
		if(root == null){
			return null;
		}
		
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		
		while(!s.isEmpty()){
			TreeNode cur = s.pop();
			
			TreeNode tmp = cur.left;
			cur.left = cur.right;
			cur.right = tmp;
			
			if(cur.right != null){
				s.push(cur.right);
			}
			
			if(cur.left != null){
				s.push(cur.left);
			}

		}
		return root;
	}
	/**
	 * 求一颗二叉树的镜像 递归解法 创建一颗新的数，不破坏原来的树。 binary tree mirror。 Recursively.
	 * 
	 */
	public  TreeNode mirrorCopyRec(TreeNode root){
		if(root == null){
			return null;
		}
        // 先把左右子树分别镜像,并且把它们连接到新建的root节点。
		TreeNode Copyroot = new TreeNode(root.val);
		Copyroot.left = mirrorCopyRec(root.right);
		Copyroot.right = mirrorCopyRec(root.left);		
		return Copyroot;
			
	}
    /**
     * 求一颗二叉树的镜像 不破坏原来的树，创建一颗新的树。  binary tree mirror。 Iteratively.
     *  应该可以使用任何一种Traversal 方法。 用什么顺序访问树不重要，重要的是让每一个节点的左右节点互换即可达到mirror效果。
     *  现在可以试看看使用最简单的前序遍历。
     * 
     */
	public  TreeNode mirrorCopy(TreeNode root){
		if(root == null){
			return null;
		}
		
		Stack<TreeNode> s = new Stack<TreeNode>();
		Stack<TreeNode> sCopy = new Stack<TreeNode>();
		
		TreeNode rootCopy = new TreeNode(root.val);
		s.push(root);
		sCopy.push(rootCopy);
		
		while(!s.isEmpty()){
			TreeNode cur = s.pop();
			TreeNode curCopy = sCopy.pop();
			
			if(cur.right != null){
				TreeNode leftCopy = new TreeNode(cur.right.val);
				curCopy.left = leftCopy;
				s.push(cur.right);
				sCopy.push(curCopy.left);
			}
			
			if(cur.left != null){
				TreeNode rightCopy = new TreeNode(cur.left.val);
				curCopy.right = rightCopy;
				s.push(cur.left);
				sCopy.push(curCopy.right);
			}
			
		}
		return root;

	}
	

	/**
	 * 11.求是不是完全二叉树 - 非递归解法 Complete Binary Tree - Check a binary tree is completed
	 * or not. Definition: A complete binary tree is a binary tree that every
	 * level is completed filled except the deepest level. In the deepest level,
	 * all nodes must be as left as possible. 思路： 进行level traversal,
	 * 一旦遇到一个节点的左节点为空，后面的节点的子节点都必须为空。而且不应该有下一行，其实就是队列中所有的元素都不应该再有子元素。
	 * 
	 * @param root
	 * @return
	 */
	public boolean isComplete(TreeNode root) {
		if (root == null) {
			return false;
		}

		TreeNode dummyNode = new TreeNode(0);
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		q.offer(root);
		q.offer(dummyNode);

		// If this is true, no node should have any child.
		boolean noChirld = false;
		while (!q.isEmpty()) {
			TreeNode cur = q.poll();
			if (cur == dummyNode) {
				if (!q.isEmpty()) {
					q.offer(dummyNode);
				}
				// Dummy node不需要处理。
				continue;
			}

			if (cur.left != null) {
				// 如果标记被设置，则Queue中任何元素不应再有子元素。
				if (noChirld) {
					return false;
				}
				q.offer(cur.left);
			} else {
				// 一旦某元素没有左节点或是右节点，则之后所有的元素都不应有子元素。
				// 并且该元素不可以有右节点.

				noChirld = true;
			}

			if (cur.right != null) {
				// 如果标记被设置，则Queue中任何元素不应再有子元素。
				if (noChirld) {
					return false;
				}
				q.offer(cur.right);
			} else {
				// 一旦某元素没有左节点或是右节点，则之后所有的元素都不应有子元素。
				noChirld = true;
			}
		}
		return true;
	}

	/**
	 * 求是不是完全二叉树 - 递归解法 Complete Binary Tree - Check a binary tree is completed
	 * or not.
	 * 
	 * Important Definition: - 完全二叉树： A complete binary tree is a binary tree
	 * that every level is completed filled except the deepest level. In the
	 * deepest level, all nodes must be as left as possible. -
	 * 具有n个节点的完全二叉树深度为log2(N) + 1. 深度为k的完全二叉树，至少有2^（k-1）个节点。至多有2^k -1个节点。 -
	 * 满二叉树： A full binary tree (sometimes proper binary tree or 2-tree) is a
	 * tree in which every node other than the leaves has two children. -
	 * 一颗深度为k，且有2^k - 1个节点的二叉树，为满二叉树。 - 树高：Height of node – The height of a node
	 * is the number of edges on the longest downward path between that node and
	 * a leaf.从结点x向下到某个叶结点最长简单路径中边的条数。 - 树深 Depth of node - The depth of a node
	 * is the number of edges from the node to the tree's root node.
	 * 
	 * 思路： Complete Binary Tree条件是： 1. 左右子树均为full binary tree,并且两者height相同 2.
	 * 左子树是complete tree 右子树是full tree且高度相同 3. 右子树是full tree 左子树是complete tree
	 * 高度相差1。
	 * 
	 * @param root
	 * @return
	 */
	public class ResultTypeCBT {
		public int depth;
		public boolean isFull, isComplete;

		ResultTypeCBT(int depth, boolean isFull, boolean isComplete) {
			this.depth = depth;
			this.isFull = isFull;
			this.isComplete = isComplete;
		}
	}

	public boolean isCompleteBST(TreeNode root) {
		ResultTypeCBT result = helperCBT(root);
		return result.isComplete;
	}

	public ResultTypeCBT helperCBT(TreeNode root) {
		if (root == null) {
			return new ResultTypeCBT(0, true, true);
		}
		ResultTypeCBT left = helperCBT(root.left);
		ResultTypeCBT right = helperCBT(root.right);

		if (!left.isComplete) {
			return new ResultTypeCBT(-1, false, false);
		}

		// if depth is the same, left should be full and right should be
		// complete
		if (left.depth == right.depth) {
			if (!left.isFull || !right.isComplete) {
				return new ResultTypeCBT(-1, false, false);
			}
			return new ResultTypeCBT(left.depth + 1, right.isFull, true);
		}

		// if left.depth = right.depth + 1. left should be complete and right
		// should be full.
		if (left.depth == right.depth + 1) {
			if (!left.isComplete || !right.isFull) {
				return new ResultTypeCBT(-1, false, false);
			}
			return new ResultTypeCBT(left.depth + 1, false, true);
		}
		return new ResultTypeCBT(-1, false, false);
	}
	/**
	 * 12. a)由前序遍历序列和中序遍历序列重建二叉树
	 * Given preorder and inorder traversal of a tree, construct the binary tree.
	 * We assume that there is no duplicate in the trees.
     *  For example:
     *          1
     *         / \
     *        2   3
     *       /\    \
     *      4  5    6
     *              /\
     *             7  8  
     *             
     *  PreOrder should be: 1   2 4 5   3 6 7 8
     *                      根   左子树    右子树  
     *  InOrder should be:  4 2 5   1   3 7 6 8
     *                       左子树  根  右子树
	 * 从PreOrder来确定根，再从中序遍历来将序列分成左右子树。进行递归。算法最终相当于一次树的遍历，每个结点只会被访问一次，所以时间复杂度是O(n)。
		http://blog.csdn.net/linhuanmars/article/details/24389549	
	 */
	 public TreeNode buildTreeFromInPre(int[] preorder, int[] inorder) {
	        if(preorder == null || inorder == null){
	        	return null;
	        }
	        //Hashmap 用于中序数组中，根据根找到对应的下标。用来区分左右子树所在位置。
	        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	        for(int i = 0; i < inorder.length; i++){
	        	map.put(inorder[i], i);
	        }
	        
	        return helperFromInPre(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);
	   }
	 
	 public TreeNode helperFromInPre(int[] preorder, int preL, int preR, int[] inorder, int inL, int inR, HashMap<Integer, Integer> map){
		 if(preL > preR || inL > inR){
			 return null;
		 }
		 TreeNode root = new TreeNode(preorder[preL]);	 
		 int index = map.get(root.val);
		 root.left = helperFromInPre(preorder, preL + 1, preL + index - inL, inorder, inL, index - 1, map);
		 root.right = helperFromInPre(preorder, preL + index - inL + 1,preR, inorder, index + 1, inR, map);
		 return root;
		 
	 }
	 
	 /**
		 * 12. b) 由后序遍历序列和中序遍历序列重建二叉树
		 * Given postorder and  traversal of a tree, construct the binary tree.
		 * We assume that there is no duplicate in the trees.
	      * We assume that there is no duplicate in the trees.
	     *  For example:
	     *          1
	     *         / \
	     *        2   3
	     *       /\    \
	     *      4  5    6
	     *              /\
	     *             7  8  
	     *             
	     *  PostOrder should be: 4 5 2   7 8 6 3    1
	     *                      左子树    右子树      根   
	     *  InOrder should be:  4 2 5   1   3 7 6 8
	     *                       左子树  根  右子树
	     *                       
	     *                       
	     *思路根由中序和前序遍历得到二叉树很相像。注意递归时候下标的计算容易出错。
		 * 从 PostOrder来确定根，再从中序遍历来将序列分成左右子树。进行递归。算法最终相当于一次树的遍历，每个结点只会被访问一次，所以时间复杂度是O(n)。
			http://blog.csdn.net/linhuanmars/article/details/24389549	
		 */
	 public TreeNode buildTreeFromInPos(int[] inorder, int[] postorder) {
	       if(inorder == null || postorder == null){
	    	   return null;
	       }
	       HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
	       
	       for(int i = 0; i < inorder.length; i++){
	    	   map.put(inorder[i], i);
	       }
	       return helperFromInPos(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1, map);
	   }
	  public TreeNode helperFromInPos(int[] inorder,int inL, int inR, int[] postorder, int posL, int posR, HashMap<Integer, Integer> map){
		  if(inL > inR || posL > posR){
			  return null;
		  }
		  
		  TreeNode root = new TreeNode(postorder[posR]);
		  
		  int index = map.get(root.val);  
		  root.left = helperFromInPos(inorder, inL, index - 1, postorder, posL, posL + index - inL - 1, map);
		  root.right = helperFromInPos(inorder, index + 1, inR, postorder, posL + index - inL, posR - 1, map);
		  
		  return root;
		  
	  }
}
