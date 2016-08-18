package GraphAndSearch;

import java.util.ArrayList;

/**
 * Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.

Example
For n=4, there are 2 distinct solutions.


 * @author SirusBlack
 *
 */
public class NQueenII {
	 /**
     * Calculate the total number of distinct N-Queen solutions.
     * @param n: The number of queens.
     * @return: The total number of distinct solutions.
     */
	public int totalNQueens(int n) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    	if(n <= 0){
    		return 0;
    	}
    	
    	//find 1-n all the possible permutations.
    	 ArrayList<Integer> cols = new ArrayList<Integer>();
    	search(n, cols, res);
    	
    	return res.size();
    }
    
      public void search( int n, ArrayList<Integer> cols, ArrayList<ArrayList<Integer>> res){
	   if(cols.size() == n){
		   res.add(cols);
		   return;
	   }
	   
	   for(int col = 0; col < n; col++){
		   if(!isValid(col, cols)){
			   continue;
		   }
		   
		   cols.add(col);
		   search(n, cols, res);
		   cols.remove(cols.size() - 1); 
	   }
   }
   
   public boolean isValid(int col, ArrayList<Integer> cols){
	   int row = cols.size();
	   // see if the coming col is the same columns added into the cols
	   for(int i = 0; i < row; i++){
		   if( cols.get(i) == col){
			   return false;
		   }
		   // see if left-top to right - bottom
		  if(i - cols.get(i) ==  row - col){
			  return false;
		  }
		  // see if from right-top to left bottom  
		  if(i + cols.get(i) ==  row + col){
			  return false;
		  }
	   }
	   return true;
   }
}
