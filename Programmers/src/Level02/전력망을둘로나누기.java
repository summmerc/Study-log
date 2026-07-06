package Level02;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

class 전력망을둘로나누기 {
	static List<Integer>[] gp;
	static int min;
	static boolean[] visited;
    public int solution(int n, int[][] wires) {
    	gp = new ArrayList[n + 1];
    	
    	for(int i = 0; i < n + 1; i++) {
    		gp[i] = new ArrayList<>();
    	}
    	
        min = Integer.MAX_VALUE;
        
        for(int i = 0; i < wires.length; i++) {
        	gp[wires[i][0]].add(wires[i][1]);
        	gp[wires[i][1]].add(wires[i][0]);
        }
        
        for(int i = 0; i < wires.length; i++) {
        	visited = new boolean[n + 1];
        	bfs(i, n, wires);
        }
        
        return min;
    }
   
    static void bfs(int i, int n, int[][] wires) {
    	Queue<Integer> q = new ArrayDeque<>();
    	
    	q.add(wires[i][1]);
    	visited[wires[i][0]] = true;
    	visited[wires[i][1]] = true;
    	int cnt = 1;
    	while(!q.isEmpty()) {
    		int cur = q.poll();
    		
    		for(int j = 0; j < gp[cur].size(); j++) {
    			if(!visited[gp[cur].get(j)]) {
    				visited[gp[cur].get(j)] = true;
    				q.add(gp[cur].get(j));
    				cnt++;
    			}    			
    		}
    	}
    	
    	int left = n - cnt;
    	int diff = left - cnt;
    	min = Math.min(min, Math.abs(diff));
    }
}