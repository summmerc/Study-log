package Level03;

import java.util.TreeSet;

class 이중우선순위큐 {
	static TreeSet<Integer> ts;
    public int[] solution(String[] operations) {
    	
    	ts = new TreeSet<Integer>();
    	for(int i = 0; i < operations.length; i++) {
    		String[] div = operations[i].split(" ");
    		int num = Integer.parseInt(div[1]);
    		
    		if(div[0].equals("I")) {
    			ts.add(num);
    		}
    		else if(div[0].equals("D")) {
    			if(ts.isEmpty()) continue;
    			
    			if(num == -1) {
    				ts.pollFirst();
    			}
    			else if(num == 1) {
    				ts.pollLast();
    			}
    		}
    	}
        
    	if(ts.isEmpty()) {
    		return new int[] {0,0};
    	}
    	int min = ts.first();
    	int max = ts.last();
    	
        return new int[] {max, min};
    }
}