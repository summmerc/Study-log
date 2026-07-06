package Level02;


class 전력망을둘로나누기_UnionFind {
	static int[] parent;
	static int min;
	
    public int solution(int n, int[][] wires) {
    	min = Integer.MAX_VALUE;
    	
    	for(int i = 0; i < wires.length; i++) {
    		parent = new int[n + 1];
    		for(int j = 1; j <= n; j++) {
    			parent[j] = j;
    		}
    		
    		for(int j = 0; j < wires.length; j++) {
    			if(i == j) continue;
    			union(wires[j][0], wires[j][1]);
    		}
    		
    		int cnt = 0;
    		int root = find(1);
    		for(int j = 1; j <= n; j++) {
    			if(find(j) == root) {
    				cnt++;
    			}
    		}
    		
    		int left = n - cnt;
    		min = Math.min(min, Math.abs(left - cnt));
    	}
    	
    	return min;
    }
    
    static void union(int x, int y) {
    	int rX = find(x);
    	int rY = find(y);
    	
    	if(rX != rY) {
    		parent[rY] = rX;
    	}
    }
    
    static int find(int x) {
    	if(parent[x] == x) return x;
    	return parent[x] = find(parent[x]);
    }

}