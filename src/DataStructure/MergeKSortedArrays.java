package DataStructure;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Given k sorted integer arrays, merge them into one sorted array.

Example
Given 3 sorted arrays:

[
  [1, 3, 5, 7],
  [2, 4, 6],
  [0, 8, 9, 10, 11]
]
return [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11].
 * @author SirusBlack
 *
 */
public class MergeKSortedArrays {
	 /**
     * @param arrays k sorted integer arrays
     * @return a sorted array
     */
	class Element{
		int col;
		int row;
		int val;
		public Element(int val, int row, int col){
			this.val = val;
			this.row = row;
			this.col = col;
		}
	}
	
	public class MyComparator implements Comparator<Element>{
		@Override
		public int compare(Element o1, Element o2) {
			
			return o1.val - o2.val;
		}
		
	}
    public List<Integer> mergekSortedArrays(int[][] arrays) {
    	List<Integer> res = new ArrayList<Integer>();
        if(arrays == null || arrays.length == 0 ){
        	return res;
        }
        
        Queue<Element> heap = new PriorityQueue<Element>(arrays.length,new MyComparator ());
        
       // int total_size = 0;
        for(int i = 0; i < arrays.length; i++){
        	if(arrays[i].length > 0){
        		Element ele = new Element(arrays[i][0], i, 0);
        		heap.add(ele);
        		//total_size += arrays[i].length;	
        	}
        }
       // int  index = 0;
        
        while(!heap.isEmpty()){
        	Element curt = heap.poll();
        	res.add(curt.val);
        	if( curt.col + 1 < arrays[curt.row].length){
        		curt.col = curt.col + 1;
        		curt.val = arrays[curt.row][curt.col];
        		heap.add(curt);
        	}
        }
        
        return res;
        
        
    }
}
