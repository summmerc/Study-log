package Level02;

class 양궁대회 {
	static int[] lion;
	static int max;
	static int[] result;
    public int[] solution(int n, int[] info) {
    	lion = new int[11];
    	result = new int[] {-1};
    	max = 0;
    	
    	dfs(0, 0, n, info);
    	
        return result;
    }
    
    static void dfs(int cnt, int idx, int n, int[] info) {
    	if(cnt == n) {
    		int diff = lionwin(info, lion);
    		if(diff > 0 && diff > max) {
    			max = diff;
    			result = lion.clone();
    			return;
    		}
    		else if(diff > 0 && diff == max) {
    			result = choose(lion, result).clone();
    		}
    		return;
    	}
    	    	
    	for(int i = idx; i < 11; i++) {
    		lion[i]++;
    		dfs(cnt + 1, i, n, info);
    		lion[i]--;
    	}
    }
    
    static int lionwin(int[] info, int[] lion) {
    	int pScore = 0;
    	int lScore = 0;
    	for(int i = 0; i < 11; i++) {
    		if(info[i] == 0 && lion[i] == 0) continue;
    		if(info[i] >= lion[i]) {
    			pScore += 10-i;
    		} else {
    			lScore += 10-i;
    		}
    	}
    	
    	return lScore - pScore;
    }
    
    static int[] choose(int[] lion, int[] result) {
    		if(result.length == 1) {
    			return lion;
    		}
    		
    		for(int i = 10; i >= 0; i--) {
    			if(lion[i] > result[i]) {
    				return lion;
    			}
    			else if(lion[i] == result[i]) {
    				continue;
    			}
    			else {
    				return result;
    			}
    		}
    		return result;
    }
}