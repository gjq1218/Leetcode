package leetcode;

import java.util.HashMap;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

	If the fractional part is repeating, enclose the repeating part in parentheses.
	
	For example,
	
	Given numerator = 1, denominator = 2, return "0.5".
	Given numerator = 2, denominator = 1, return "2".
	Given numerator = 2, denominator = 3, return "0.(6)".
 * @author SirusBlack
 *
 */

public class FractiontoRecurringDecimal {
	// http://blog.csdn.net/ljiabin/article/details/42025037
   public String fractionToDecimal(int numerator, int denominator) {
	   if(numerator == 0) return "0";
	   if(denominator == 0) return "";
	   
	   String ans = "";
	   // if the result is negative
	   if((numerator < 0) ^ (denominator < 0)){
		   ans += "-";
	   }
	   
	   //transfer them into an integer. in case of over flow. int transfer to long
	   long num = numerator, den = denominator;
	   num = Math.abs(num);
	   den = Math.abs(den);
	   
	   // below are the result
	   long res = num/den;
	   ans += String.valueOf(res);
	   
	   // if it can exact division，return result
	   long rem = (num % den) * 10;
	   if(rem == 0) return ans;
	   
	   // the result's fractional part
	   HashMap<Long, Integer> map = new HashMap<Long, Integer>();
	   ans += ".";
	   
	   while( rem != 0){
		   // if we see this reminder before, then the repeat start.
		   if(map.containsKey(rem)){
			   int beg = map.get(rem);
			   String part1 = ans.substring(0, beg);
			   String part2 = ans.substring(beg, ans.length());
			   ans = part1 + "(" + part2 + ")";
			   return ans;
		   }
		   // continue to divide
		   map.put(rem, ans.length());
		   res = rem/den;
		   ans += String.valueOf(res);
		   rem = (rem % den) * 10;
	   }
	   
	   return ans;	   
    }
}
