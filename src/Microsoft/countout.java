package Microsoft;

import java.util.ArrayList;

/**
 *  一群小朋友围坐在一圈，从某人开始报数，报到n出局，然后下一个人接着报数，最后剩下一个人, 问这个人
 * @author SirusBlack
 *
 */
public class countout {
	public ArrayList<Integer> countOut(int n, int k){
		ArrayList<Integer> winner = new ArrayList<Integer>();
		int[] order = new int[n];
		int p = 0;
		for(int i = 0; i < n; i++){
			order[i] = i + 1;
		}
		int cur = 0;
		int count = 0;
		while(count < n - k - 1){
			while(order[p] == 0){
				p = (p + 1) % n;
			}
			cur++;
			if(cur == k){
				order[p] = 0;
				cur = 0;
				count++;
			}
			p = (p + 1)%n;
			for(int i = 0; i < n; i++){
				if(order[i] != 0){
					winner.add(order[i]);
				}
			}
			return winner;
		}
		return winner;
	}
	
	public static void main(String[] args){
		countout test = new countout();
		ArrayList<Integer>  res = test.countOut(3, 5);
		for(Integer in: res){
			System.out.println(in);
		}
	}
}
