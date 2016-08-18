package Template;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
	
	public class DirectedGraphNode{
		int lable;
		ArrayList<DirectedGraphNode> neighbors;
		public DirectedGraphNode(int lable){
			this.lable = lable;
			neighbors = new ArrayList<DirectedGraphNode>();
		}
		
	}
	/**
	 * 把所有入度为0的点，放入队列
	 * 对这个队列开始进行BFS
	 * 每拿出一个点，再重新算一遍
	 * @param graph
	 * @return
	 */
	public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph){
		// 统计所有点的入度。
		//所有为0的点放入队列。
		//一个一个挪走。
		
		ArrayList<DirectedGraphNode> res = new ArrayList<DirectedGraphNode>();
		HashMap<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
		for(DirectedGraphNode node: graph){
			for(DirectedGraphNode neighbor: node.neighbors){
				if(map.containsKey(neighbor)){
					map.put(neighbor, map.get(neighbor) + 1);
				}else{
					map.put(neighbor, 1);
				}
			}
		}
		
		Queue<DirectedGraphNode> q = new LinkedList<DirectedGraphNode>();
		for(DirectedGraphNode node: graph){
			if(!map.containsKey(node)){
				q.offer(node);
				res.add(node);
			}
		}
		while(!q.isEmpty()){
			DirectedGraphNode node = q.poll();
			for(DirectedGraphNode n: node.neighbors){
				map.put(n, map.get(n) - 1);
				if(map.get(n) == 0){
					res.add(n);
					q.offer(n);
				}
			}
		}
		return res;
	}
}
