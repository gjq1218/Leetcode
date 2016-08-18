package GraphAndSearch;

import java.util.ArrayList;

/**
 * 
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

Example
There exist two distinct solutions to the 4-queens puzzle:

[
  // Solution 1
  [".Q..",
   "...Q",
   "Q...",
   "..Q."
  ],
  // Solution 2
  ["..Q.",
   "Q...",
   "...Q",
   ".Q.."
  ]
]


 * @author SirusBlack
 *
 */
public class NQueens {
	 /**
     * Get all distinct N-Queen solutions
     * @param n: The number of queens
     * @return: All distinct solutions
     * For example, A string '...Q' shows a queen on forth position
     */
    ArrayList<ArrayList<String>> solveNQueens(int n) {
    	ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
    	if(n <= 0){
    		return res;
    	}
    	
    	//find 1-n all the possible permutations.
    	 ArrayList<Integer> cols = new ArrayList<Integer>();
    	search(n, cols, res);
    	
    	return res;
    }
    
   public void search( int n, ArrayList<Integer> cols, ArrayList<ArrayList<String>> res){
	   if(cols.size() == n){
		   res.add(drawChessBoard(cols));
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
   
   public ArrayList<String> drawChessBoard( ArrayList<Integer> cols){
	   String[] chessboard = new String[cols.size()];
	   for(int i = 0; i < cols.size(); i++){
		   chessboard[i] = "";
		   for(int j = 0; j < cols.size(); j++){
			   if(j == cols.get(i)){
				   chessboard[i] += "Q";
			   }else{
				   chessboard[i] += ".";
			   }
		   }
		   
	   }
	   
	   ArrayList<String> finalboard = new ArrayList<String>();
	   for(int i = 0; i < chessboard.length; i++){
		   finalboard.add(chessboard[i]);
	   }
	   
	   return finalboard;
   }
	   
	 
}
