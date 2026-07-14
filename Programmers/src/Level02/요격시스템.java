package Level02;

import java.util.Arrays;

class 요격시스 {
	static int cnt;
	static boolean[] visited;
    public int solution(int[][] targets) {
    	cnt = 0;
    	visited = new boolean[targets.length];
    	Arrays.sort(targets, (o1, o2) -> o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0]);
    	
    	for(int i = 0; i < targets.length; i++) {
    		if(visited[i] == true) continue;
    		
    		int idx = i + 1;
    		int end = targets[i][1];
    		while(idx < targets.length) {
    			if(targets[idx][0] < targets[i][1] && end > targets[idx][0]) {
    				visited[idx] = true;
    				end = Math.min(end, targets[idx][1]);
    				idx++;
    			}
    			else {
    				break;
    			}
    		}
    		
    		visited[i] = true;
    		cnt++;
    	}
    	
        return cnt;
    }
}