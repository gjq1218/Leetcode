package Template;

import java.util.HashMap;

public class UnionFind {
	HashMap<Integer, Integer> father = new HashMap<Integer, Integer>();
	UnionFind(int n){
		for(int i = 0; i < n; i++){
			father.put(i, i);
		}
	}
	
	public int compressed_find(int x){
		if(father.get(x) != father.get(father.get(x))){
			father.put(x, compressed_find(father.get(x)));
		}
		
		return father.get(x);
	}
	
	public void union(int x, int y){
		int fa_x = compressed_find(x);
		int fa_y = compressed_find(y);
		if(fa_x != fa_y){
			father.put(fa_x, fa_y);
		}
	}

}
