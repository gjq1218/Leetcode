package DPI;

public class LongestIncresingContinousSubsequence {
	 public int longestIncreasingContinuousSubsequence(int[] A) {
	        if(A == null || A.length == 0){
	            return 0;
	        }
	        
	        int[] f = new int[A.length];
	        int max = 1;
	        
	        f[0] = 1;
	        
	        for(int i = 1; i < A.length; i++){
	            
	            if(A[i] < A[i -1]){
	                 f[i] = f[i - 1] + 1;
	            }else{
	                f[i] = 1;
	            }
	            
	            if(f[i] > max){
	                max = f[i];
	            }
	        }
	        
	        f[A.length - 1] = 1;
	        
	        for(int j = A.length - 2; j >= 0; j--){
	            if(A[j] < A[j + 1]){
	                f[j] = f[j + 1] + 1;
	            }else{
	                f[j] = 1;
	            }
	            
	            if(f[j] > max){
	                max = f[j];
	            }
	        }
	        
	        return max;
	    }
	   public static void main(String args[]){
		   LongestIncresingContinousSubsequence test = new LongestIncresingContinousSubsequence();
		   int[] A ={10};
		   int re = test.longestIncreasingContinuousSubsequence(A);
		   System.out.println(re);
		   
	   }
}
