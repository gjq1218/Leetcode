package Goo;
/**
 * 
 * 给一个two D garden , 每一个slot可以是flower或者Wall. 找一个合适的位置，让游客可以看到最多的flower.可以站在flower上，不能站在墙上
	如果被墙挡了，就看不到墙后面的花。然后游客只能竖直或者水瓶看，不能看对角线。。比如
	[ [f, x, x, w, f],
	[f, f, x ,x ,x],
	[x, x, f, w, f],
	[f, f, x, w, x]]
	这样，{3, 0} 和 {1,4}都能看到四朵花。
	
	
	思路： 横着走一次看到f就加1，看到wall就回退，然后从start到wall的地方把刚才看到的花朵数目填满。
		  竖着走一次看到f就加1，看到wall就回退，然后从start到wall的地方把刚才看到的花朵数目填满。
		  这样每一个格子如果是花朵的话，横着加了一次竖着加了一次，所以要对每一个是f的格子减掉1，最后找到最大值。

		  
 * http://www.1point3acres.com/bbs/thread-177167-1-1.html
 * @author SirusBlack
 *
 */
public class Mianjing_Flower {
    public static void main(String[] args) {
        char[][] matrix = {{'f', 'x', 'x', 'w', 'f'},
                             {'f', 'f', 'x' ,'x' ,'x'},
                             {'x', 'x', 'f', 'w', 'f'},
                             {'f', 'f', 'x', 'w', 'x'}};
       int res = maxFlowersInGarden(matrix);
       System.out.println(res);
       
}

public static int maxFlowersInGarden(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
                return 0;
        }
        int m = matrix.length;
        int n = matrix[0].length;
       
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
                int count = 0;
                int j = 0;
                int start = 0;
                while (j < n) {
                        if (matrix[i][j] == 'f') {
                                count++;
                        } else if (matrix[i][j] == 'w') {
                                for (int k = start; k < j; k++) {
                                        res[i][k] = count;
                                }
                                start = j + 1;
                                count = 0;
                        }
                        j++;
                }
                for (int k = start; k < j; k++) {
                        res[i][k] = count;
                }
        }
        for (int j = 0; j < n; j++) {
                int count = 0;
                int i = 0;
                int start = 0;
                while (i < m) {
                        if (matrix[i][j] == 'f') {
                                count++;
                        } else if (matrix[i][j] == 'w') {
                                for (int k = start; k < i; k++) {
                                        res[k][j] += count;
                                }
                                start = i + 1;
                                count = 0;
                        }
                        i++;
                }
                for (int k = start; k < i; k++) {
                        res[k][j] += count;
                }
        }
        for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                        if (matrix[i][j] == 'f') {
                                res[i][j] -= 1;
                        }
                }
        }
        int max = 0;
        for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                        System.out.print(res[i][j] + " ");
                        max = Math.max(max, res[i][j]);
                }
                System.out.println();
        }
     
        
        return max;
}

}
