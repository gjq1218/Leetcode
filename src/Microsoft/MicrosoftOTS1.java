package Microsoft;
/**
 * 1. Reverse a string iteratively and recursively.
 * 2. Given a doubly linkedList which contains only 0 and 1(any number of 0 and 1). Write a algorithm to sort them. Solution can be done with
 * O(n) complexity.
 * 3.  The permutation is an ordered arrangement of objects. For example, 3124 is one possible permutation of the digits 1,2,3 and 4. If all of the permutation
 * are listed numerically or alphabetically, we call it lexicographic order. The lexicographic permutation of 0,1,2 are:
 * 	012 021 102 120 201 210
 * Write a function which would return Nth lexicographic permutation of the digits of 0,1,2,3,4,5,6,7,8, and 9.
 * String NthPerm(int n){....}
 * 
 * 
 * @author SirusBlack
 *
 */
public class MicrosoftOTS1 {
	public String reverse(String s){
		StringBuilder str = new StringBuilder();
		char[] strChar = s.toCharArray();
		
		for(int i = strChar.length - 1; i >= 0; i--){
			str.append(strChar[i]);
		}
		return str.toString();
	}
	
	public String reverseRec(String s){
		if(s.length() < 2){
			return s;
		}

		return reverseRec(s.substring(1)) + s.charAt(0);
		
//		 int index = s.length() - 1;
//	     return s.charAt(index) + reverse(s.substring(0, index));
	        
	        

	}
	
	public static void main(String args[]){
		MicrosoftOTS1 test = new MicrosoftOTS1();
		System.out.println(test.reverse("abcd"));
		System.out.println(test.reverseRec("abcd"));
		
	}
}
