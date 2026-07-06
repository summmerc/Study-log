import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Stack;

class Solution {
	static PriorityQueue<String[]> pq;
	static Stack<String[]> st;
    public String[] solution(String[][] plans) {
    	Arrays.sort(plans, (o1, o2) -> o1[1].compareTo(o2[1]));
    	
    	st = new Stack<>();
    	String[] answer = new String[plans.length];
    	
    	
    	int now = 0; //시간
    	int done = 0; //끝난거 answer넣을거
    	int idx = 0; //지금 진행중인
    	
    	while(idx < plans.length - 1) {
    		String[] curr = plans[idx];
    		
    		String[] time = curr[1].split(":");
    		int s = Integer.parseInt(time[0]) * 60 + Integer.parseInt(time[1]);
    		int du = Integer.parseInt(curr[2]);
    		
    		String[] next = plans[idx + 1];
    		String[] time2 = next[1].split(":");
    		int s2 = Integer.parseInt(time2[0]) * 60 + Integer.parseInt(time2[1]);
    		int du2 = Integer.parseInt(next[2]);
    		
    		now = s2 - s - du;
    		if(s + du <= s2) { //만약에 ~ 시간이 남을 때
    			answer[done++] = curr[0];
//    			int diff = s2 - now;
    			
    			while(!st.isEmpty()) {
    				String[] spop = st.pop();
    				now -= Integer.parseInt(spop[2]);
    				
    				if(now < 0) {
    					spop[2] = Math.abs(now) + "";
    					st.add(spop);
    					break;
    				}
    				
    				answer[done++] = spop[0];
    			}
    			
    		}
    		else { 
    			curr[2] = Math.abs(now) + "";
    			st.add(curr);
    		}
    		idx++;
    		
    	}
    	
    	st.push(plans[idx]);
    	while(!st.isEmpty()) {
    		answer[done++] = st.pop()[0]; 
    	}
        
        return answer;
    }
}