package Goo;
/**
 * Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:
Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
update(3, 2, 2)
sumRegion(2, 1, 4, 3) -> 10
Note:
The matrix is only modifiable by the update function.
You may assume the number of calls to update and sumRegion function is distributed evenly.
You may assume that row1 ≤ row2 and col1 ≤ col2.
 * @author SirusBlack
 *
 */
public class RangeSumQuery2DMutable {
	int[][] rowSums;
	
 	public RangeSumQuery2DMutable(int[][] matrix) {
        if(matrix.length == 0){
        	return;
        }
        rowSums = new int[matrix.length][matrix[0].length];
        
        // build up rowSums matrix
        for(int i = 0; i < matrix.length; i++){
        	for(int j = 0; j < matrix[0].length; j++){
        		rowSums[i][j] = matrix[i][j] + (j == 0 ? 0 : rowSums[i][j-1]);
        	}
        }
    }

    public void update(int row, int col, int val) {
        // get the difference of old and new values
    	int diff = val - (rowSums[row][col] - (col == 0 ? 0 : rowSums[row][col - 1]));
    	// update this new line's sum
    	for(int j = col; j < rowSums[0].length; j++){
    		rowSums[row][j] +=diff;
    	}
    }

	    public int sumRegion(int row1, int col1, int row2, int col2) {
	        int res = 0;
	        
	        for(int i = row1; i <= row2; i++){
	        	res += rowSums[i][col2] - (col1 == 0 ? 0 : rowSums[i][col1 - 1]);
	        }	        
	        return res;
	    }
	}

	// Your NumMatrix object will be instantiated and called as such:
	// NumMatrix numMatrix = new NumMatrix(matrix);
	// numMatrix.sumRegion(0, 1, 2, 3);
	// numMatrix.update(1, 1, 10);
	// numMatrix.sumRegion(1, 2, 3, 4);
