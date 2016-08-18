package Microsoft;

import java.util.LinkedList;

/**
 * 2. Given a doubly linkedList which contains only 0 and 1(any number of 0 and 1). Write a algorithm to sort them. Solution can be done with
 * O(n) complexity.
 * @author SirusBlack
 *
 */
public class MicrosoftOTS2 {
	public static LinkedList<Integer> sortZeroOneList(LinkedList<Integer> input)
	{
		int[] count = new int[2];
		for(Integer element:input)
		{
			count[element]++;
		}
		LinkedList<Integer> result = new LinkedList<Integer>();
	    int count0 = count[0];
	    int count1 = count[1];
	    while(count0 > 0)
	    {
	    	result.add(0);
	    	count0--;
	    }
	    while(count1 > 0)
	    {
	    	result.add(1);
	    	count1--;
	    }
	    return result;
	}
	
	public static void main(String args[]){
		MicrosoftOTS2 test = new MicrosoftOTS2();
		LinkedList<Integer> input = new LinkedList<Integer>();
		input.add(0);
		input.add(1);
		input.add(0);
		input.add(1);
		LinkedList<Integer> res = test.sortZeroOneList(input);
		for(Integer tmp: res){
			System.out.println(tmp);;
		}
	}
}
