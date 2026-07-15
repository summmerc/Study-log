package Level02;

class 연속된부분수열의합 {
	static int[] result;
    public int[] solution(int[] sequence, int k) {
    	int len = 0;
    	
    	int i = 0;
    	int sum = 0;
    	
    	for(int j = 0; j < sequence.length; j++) {
    		sum += sequence[j];
    		
    		while(sum > k && i <= j) {
    			sum -= sequence[i++];
    		}
    		
    		if(sum == k) {
    			int nlen = j - i + 1;
    			
    			if(len == 0) {
    				result = new int[] {i, j};
    				len = nlen;
    			}
    			
    			else if(nlen < len) {
    				result = new int[] {i, j};
    				len = nlen;
    			}
    		} 
    	}
    	
    	
        return result;
    }
}