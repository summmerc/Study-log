package Level02;

import java.util.ArrayList;
import java.util.List;

class N_Queen {
	static int[][] map;
	static int result;
	
	
    public int solution(int n) {
    	map = new int[n][n];
    	result = 0;
        
    	dfs(0, n, new ArrayList<>());
    	
        return result;
    }
    
    private void dfs(int cnt, int N, List<int[]> list) {
    	if(cnt == N) {
    		result++;
    		return;
    	}
    	
    	
    	for(int i=0; i<N; i++) {
    		boolean flag = false;
    		for(int j = 0; j < cnt; j++) {
        		// 기울기랑 , x 좌표 비교해서 같거나 1, -1 이면
        		if(list.get(j)[1] == i || Math.abs((i - list.get(j)[1])) == Math.abs(cnt - list.get(j)[0])) {
        			flag = true;
        			break;
        		}
        	}
    		if(flag) continue;
    		else {
    			list.add(new int[] {cnt, i});
    			dfs(cnt + 1, N, list);
    			list.remove(cnt);
    		}
    		
    	}
    }
}
