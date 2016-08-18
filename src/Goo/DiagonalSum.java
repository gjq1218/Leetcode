package Goo;

import java.util.ArrayList;
import java.util.List;

public class DiagonalSum {
	public static List<Integer> diagonalSum(int[][] matrix) {
		List<Integer> result = new ArrayList<Integer>();
		if (matrix.length == 0 || matrix[0].length == 0) {
			return result;
		}
		
		int m = matrix.length;
		int n = matrix[0].length;
		for (int i = 0; i < m + n - 1; i++) {
			int x = Math.max(0, m - 1 - i);
			int y = Math.max(0, i - m + 1);
			
			int sum = 0;
			while (x < m && y < n) {
				sum += matrix[x++][y++];
			}
			
			result.add(sum);
		}
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] matrix = { {1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12} };
		List<Integer> result = diagonalSum(matrix);
		
		for (int num : result) {
			System.out.print(num + " ");
		}
	}
}
