package Microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 *  3.  The permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1,2,3 and 4. If all of the permutation
 * are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutation of 0,1,2 are:
 * 	012 021 102 120 201 210
 * Write a function which would return Nth lexicographic permutation of the digits of 0,1,2,3,4,5,6,7,8, and 9.
 * String NthPerm(int n){....}
 * 
 * 
 * @author SirusBlack
 *
 */

public class MicrosoftOTS3 {
	public static int factorial(int n) {
        int fact = 1; // this  will be the result
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
	

   public static String nThPermutation(List<String> in, int index){
		
		if(in.size()==1)
			return in.get(0);
		
		int N = in.size();		
		int residue = index;
		int noOfPerm = factorial(N-1);
		int outputIndex = 0;
		
		if(noOfPerm < residue){
			outputIndex = residue/noOfPerm;
			if(residue%noOfPerm==0){
				outputIndex--;
			}
			residue = residue -(outputIndex * noOfPerm);			
		}
		String indexDigit = in.get(outputIndex);
		in.remove(outputIndex);
		return indexDigit + nThPermutation(in, residue);
	}
	public static String NthPerm(int n)
	{
		String[] in1={"0","1","2","3", "4", "5", "6", "7", "8", "9"};
		List<String> inp =  new ArrayList<String>(Arrays.asList(in1));
		String result = nThPermutation(inp, n);
		return result;
	}
	
	public static void main(String args[]){
		MicrosoftOTS3 test = new MicrosoftOTS3();
	
		String res = test.NthPerm(11);
		System.out.println(res);
	}
}
