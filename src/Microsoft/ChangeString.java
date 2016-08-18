package Microsoft;

/**
 * 
 * 
 * 
 * @author SirusBlack
 *
 */
public class ChangeString {
	public String Change(String input){
		
		if(input == null || input.length() == 0 || input.length() == 1){
			return input;
		}
		
		int length = input.length();
		
		int start = 0;
		int end = start + 1;
		
		char[] array = input.toCharArray();
		// two pointer
		while(start < end && start < length && end < length){
			
			if(array[start] != array[end]){
				start = start + 1;
				end = end + 1;
			}else{
				int next = end;
				while(next < length){
					if(array[next] == array[start]){
						next = next + 1;
					}else{
						char tmp = array[next];
						array[next] = array[end];
						array[end]  = tmp;
						break;
					}
				}
				// check if next is already go to the end but didn't find a difference.
				if(next == length){
					return "This is not valid input.";
				}
				start = end;
				end = end + 1;
			}
		}
		
		String res = new String(array);
		return res;
	}
	
	public static void main(String args[]){
		ChangeString test = new ChangeString();
		String input = "abcabcc";
		String res = test.Change(input);
		System.out.println(res);
	}
}
