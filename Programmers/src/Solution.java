import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class Solution {
	static boolean[] visited;
	static int cnt;
	static List<Integer>[] network;
	
    public int solution(int n, int[][] computers) {
    	network = new ArrayList[n];
    	
    	for(int i = 0; i < n; i++) {
    		network[i] = new ArrayList<>();
    	}
    	
    	for(int i = 0; i < n; i++) {
    		for(int j = 0; j < n; j++) {
    			if(i == j) continue;
    			if(computers[i][j] == 1) {
    				network[i].add(j);
    			}
    		}
    	}
    	
    	cnt = 0;
    	visited = new boolean[n];
    	for(int i = 0; i < n; i++) {
    		if(!visited[i]) {
    			bfs(i, n);
    		}
    	}
    	
        return cnt;
    }
    
    static void bfs(int start, int n) {
    	visited[start] = true;
    	Queue<Integer> q = new ArrayDeque<>();
    	
    	q.add(start);
    	
    	while(!q.isEmpty()) {
    		int cur = q.poll();
    		for(int i = 0; i < network[cur].size(); i++) {
    			if(!visited[network[cur].get(i)]) {
    				q.add(network[cur].get(i));
    				visited[network[cur].get(i)] = true;
    			}
    		}
    	}
    	
    	cnt++;
    }
}