package Level03;

import java.util.Arrays;
import java.util.PriorityQueue;

class 디스크컨트롤러 {
	static PriorityQueue<int[]> pq;
    public int solution(int[][] jobs) {
    	Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);
    	
    	pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
    	
    	
    	int total = 0;
    	int now = 0;
    	int idx = 0;
    	int done = 0;
    	
    	while(done < jobs.length) {
    		while(idx < jobs.length && jobs[idx][0] <= now) {
    			pq.add(jobs[idx]);
    			idx++;
    		}
    		
    		if(!pq.isEmpty()) {
    			int[] curr = pq.poll();
    			total += (now + curr[1]) - curr[0];
    			
    			now += curr[1];
    			done++;
    		}
    		
    		else {
    			now = jobs[idx][0];
    		}
    	}
        
    	
    	return total / jobs.length;
    }
}