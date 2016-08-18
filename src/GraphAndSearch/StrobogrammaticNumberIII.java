package GraphAndSearch;
/**
 * 
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

Write a function to count the total strobogrammatic numbers that exist in the range of low <= num <= high.

For example,
Given low = "50", high = "100", return 3. Because 69, 88, and 96 are three strobogrammatic numbers.

Note:
Because the range might be a large number, the low and high numbers are represented as string.

Show Tags
Show Similar Problems



 * @author SirusBlack
 *
 */
public class StrobogrammaticNumberIII {
	   public int strobogrammaticInRange(String low, String high) {
		   
		   if(low.equals("0") && high.equals("0")){
			   return 1;
		   }
	         int res = 0;
	         for(int i = low.length(); i <= high.length(); i++){
	        	 find(low, high, "", i, res);
	        	 find(low, high, "0", i, res);
	        	 find(low, high, "1", i, res);
	        	 find(low, high, "8", i, res);
	         }
	         return res;
	   }
	   
	   public void find( String low, String high, String path, int len, int res){
		   if(path.length() >= len){
			   if(path.length() != len || (len != 1 && path.charAt(0) == '0')) return;
			   if((len == low.length() && path.compareTo(low) < 0) || (len  == high.length() && path.compareTo(high) > 0)){
				   return;
			   }
			   ++res;
		   }
		   
		   find(low, high, "0" + path + "0", len, res);
		   find(low, high, "1" + path + "1", len, res);
		   find(low, high, "6" + path + "9", len, res);
		   find(low, high, "8" + path + "8", len, res);
		   find(low, high, "9" + path + "6", len, res);
	   }
}
