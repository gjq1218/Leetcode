package Goo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class TheSkylineProblem {
	class Edge{
		int pos;
		int height;
		boolean isStart;
		public Edge(int pos, int height, boolean isStart){
			this.pos = pos;
			this.height = height;
			this.isStart = isStart;
		}
	}
	
	 class EdgeComparator implements Comparator<Edge>{
		
		public int compare(Edge e1, Edge e2) {
			
			if(e1.pos != e2.pos){
				return e1.pos - e2.pos;
			}
			// 起点一样，边高的在前面。
			if(e1.isStart && e2.isStart){
				return e2.height - e1.height <= 0  ? -1: 1;
			}
			//终点一样，边矮的排在前面。
			if(!e1.isStart && !e2.isStart){
				return e1.height - e2.height <= 0 ? -1 : 1;
			}
			
			return e1.isStart ? -1 : 1;
		} 
		
	}
	
	
	public List<int[]> getSkyline(int[][] buildings) {
		List<int[]>  res = new ArrayList<int[]>();
		if(buildings == null || buildings.length == 0 || buildings[0].length == 0){
			return res;
		}
		
		// create the edges list using the given out buildings
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for(int[] building: buildings){
			Edge startEdge = new Edge(building[0], building[2], true);
			edges.add(startEdge);
			Edge endEdge = new Edge(building[1], building[2], false);
			edges.add(endEdge);
			
		}
		
		//Sort the buildings used new comparator
		Collections.sort(edges, new EdgeComparator());
		
		// Initialize a max heap
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
			
			public int compare(Integer h1, Integer h2){
				return h2 - h1;
			}
		});
		
		// utilize the maxheap -  Then scan across the critical points from left to right. When we encounter the left edge of a rectangle, we add that rectangle to the heap with its height as the key. 
		//When we encounter the right edge of a rectangle, we remove that rectangle from the heap. (This requires keeping external pointers into the heap.) 
		//Finally, any time we encounter a critical point, after updating the heap we set the height of that critical point to the value peeked from the top of the heap.
		
		for(Edge edge: edges){
			if(edge.isStart){
			 
				if(heap.isEmpty() || edge.height > heap.peek()){
					int[] now = new int[]{edge.pos, edge.height};
					res.add(now);
					
				}
				heap.add(edge.height);
			}else{
				
				heap.remove(edge.height);
				if(heap.isEmpty() || edge.height > heap.peek()){
					if(heap.isEmpty()){
						int[] now = new int[]{edge.pos, 0};
						res.add(now);
					}else{
						int[] now = new int[]{edge.pos, heap.peek()};
						res.add(now);
					}
				}				
			}
		}
		
		return res;
	}

/*
	 public static void main(String args[]){
		 TheSkylineProblem test = new TheSkylineProblem();
		 int[][] buildings = {{1,2,1,},{1,2,2},{1,2,3}};
		 List<int[]>  res = test.getSkyline(buildings);
		 
	 }*/
	
}
