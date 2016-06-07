package Goo;
/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.

	The update(i, val) function modifies nums by updating the element at index i to val.
	Example:
	Given nums = [1, 3, 5]
	
	sumRange(0, 2) -> 9
	update(1, 2)
	sumRange(0, 2) -> 8
	Note:
	The array is only modifiable by the update function.
	You may assume the number of calls to update and sumRange function is distributed evenly.
	Show Tags
	Show Similar Problems

 * @author ginagao
 *
 */

public class RangeSumQuery {
	
	class SegmentTreeNode{
		int low = 0;
		int high = 0;
		int val = 0;
		SegmentTreeNode left = null;
		SegmentTreeNode right = null;
		
		SegmentTreeNode(int l, int h, int v){
			low = l;
			high = h;
			val = v;
		}
	}
	
	private SegmentTreeNode root = null;
	private int size = 0;
	
	public RangeSumQuery(int[] nums) {
        root = buildSegmentTree(nums, 0, nums.length - 1);
        size = nums.length;
    }

    void update(int i, int val) {
      if(i < 0 || i >= size){
    	  return;
      }
      
      update(root, i, val);
    }

    public int sumRange(int i, int j) {
        if(i < 0 || j >= size || i > j){
        	return -1;
        }
        return sumRange(root, i, j);
    }
    
    // build the segment tree
    private SegmentTreeNode buildSegmentTree(int[] nums, int start, int end){
    	if(start > end){
    		return null;
    	}
    	if(start == end){
    		SegmentTreeNode leaf = new SegmentTreeNode(start, end, nums[start]);
    		return leaf;
    	}
    	SegmentTreeNode root = new SegmentTreeNode(start, end, 0);
    	int mid = (start + end)/2;
    	root.left = buildSegmentTree(nums, start, mid);
    	root.right = buildSegmentTree(nums, mid + 1, end);
    	root.val = root.left.val + root.right.val;
    	return root;
    }
    // update the segment tree
    private int update(SegmentTreeNode root, int i, int val){
    	if(root.low == root.high && root.low == i){
    		int old = root.val;
    		root.val = val;
    		return old;
    	}
    	
    	int mid = (root.low + root.high)/2;
    	int old = 0;
    	if(i>= root.low && i <=mid){
    		old = update(root.left, i, val);
    	}else{
    		old = update(root.right, i, val);
    	}
    	
    	root.val = root.val - old + val;
    	return old;
    }
    
    private int sumRange(SegmentTreeNode root, int i, int j){
    	if(root.low == i && root.high == j){
    		return root.val;
    	}
    	
    	int mid = (root.low + root.high)/2;
    	if(i <= mid && j <= mid){
    		return sumRange(root.left, i, j);
    	}else if(i > mid && j > mid){
    		return sumRange(root.right, i, j);
    	}else{
    		return sumRange(root.left, i, mid) + sumRange(root.right, mid + 1, j);
    	}
    	
    }
    
}

//Your NumArray object will be instantiated and called as such:
//NumArray numArray = new NumArray(nums);
//numArray.sumRange(0, 1);
//numArray.update(1, 10);
//numArray.sumRange(1, 2);
