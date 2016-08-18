package DataStructure;

import java.util.Stack;

/**
 * 单调栈
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

	histogram
	
	Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].
	
	histogram
	
	The largest rectangle is shown in the shaded area, which has area = 10 unit.
	
	Given height = [2,1,5,6,2,3],
	return 10.
 * 
 * @author SirusBlack
 *
 */
public class LargestRectangleInHistogram {
	 public int largestRectangleArea(int[] height) {
	       
	       if(height == null || height.length == 0){
	           return 0;
	       }
	       
	       Stack<Integer> stack = new Stack<Integer>();
	       
	       int max = 0;
	       for(int i = 0; i <= height.length; i++){
	           int curt = (i == height.length) ? -1 : height[i];
	           while(!stack.isEmpty() && curt <= height[stack.peek()] ){
	               int h = height[stack.pop()];
	               int w = stack.isEmpty() ? i : i - stack.peek() - 1;
	               max = Math.max(max, h*w);
	           }
	           stack.push(i);
	       }
	       return max;
	       
	    }
	 
	 public static void main(String args[]){
		 LargestRectangleInHistogram test = new LargestRectangleInHistogram();
		 int[] height = {0};
		 test.largestRectangleArea(height);
	 }
}
