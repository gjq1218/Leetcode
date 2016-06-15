package Template;

import java.util.ArrayList;
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
   前序遍历，后序遍历，中序遍历。（非递归写法 与递归写法。）按层遍历。

 * 
 * @author ginagao
 *
 */
public class TraversalTree {
	public class TreeNode{
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x){
			val = x;
		}
	}
	
	/**
	 *  前序遍历 非递归
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
  	
}
