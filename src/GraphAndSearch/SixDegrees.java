package GraphAndSearch;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 * Six degrees of separation is the theory that everyone and everything is six or fewer steps away, by way of introduction, from any other person in the world, so that a chain of "a friend of a friend" statements can be made to connect any two people in a maximum of six steps.

Given a friendship relations, find the degrees of two people, return -1 if they can not been connected by friends of friends.

Have you met this question in a real interview? Yes
Example
Gien a graph:

1------2-----4
 \          /
  \        /
   \--3--/
{1,2,3#2,1,4#3,1,4#4,2,3} and s = 1, t = 4 return 2

Gien a graph:

1      2-----4
             /
           /
          3
{1#2,4#3,4#4,2,3} and s = 1, t = 4 return -1


 * @author SirusBlack
 *
 */
public class SixDegrees {
	public class UndirectedGraphNode{
		int label;
		List<UndirectedGraphNode> neighbors;
		public UndirectedGraphNode(int x){
			label = x;
			this.neighbors = new ArrayList<UndirectedGraphNode>();
		}
	}
	
	
	public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t){
		 if(graph == null || s == null || t == null){
				return 0;
			}
			
			Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
			HashSet<UndirectedGraphNode> set = new HashSet<>();
			
			
			queue.offer(s);
			int level = 0;
			while(!queue.isEmpty()){
				
				int size = queue.size();
 				// level Traversal 的关键就是拿出queue的size， 写一个for循环。
				for(int i = 0; i < size; i++){
					UndirectedGraphNode cur = queue.poll();
					if(cur == t){
						return level - 1;
					}
					for(UndirectedGraphNode neighbor: cur.neighbors){
						if(!set.contains(neighbor)){
							set.add(neighbor);
							queue.offer(neighbor);
						}
					}
				}
			}
			
			return -1;
	    }
		
}
