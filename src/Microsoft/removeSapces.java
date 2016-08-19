package Microsoft;
/**
 * string remove the space in head and rear, make sure only one space between words
using s.Trim(); and remove inside one by one
 * @author SirusBlack
 *
 */
public class removeSapces {
	public String removeSpace(String s){
		s = s.trim();

		StringBuilder result = new StringBuilder();
		
		
		String[] array = s.split("\\s+");
		
		for(int i = 0; i < array.length; i++){
			result = result.append(array[i]).append(" ");
		}
		result.deleteCharAt(result.length() - 1);
		return new String(result);
	}
	
	public static void main(String args[]){
		removeSapces test = new removeSapces();
		String res = test.removeSpace(" I   love you, hello baby!   ");
		System.out.println(res);
	}
}
