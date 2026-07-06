package Level02;

class 타겟넘버 {
	static int cnt;
    public int solution(int[] numbers, int target) {
    	
    	dfs(numbers, target, 0, 0);
    	
        return cnt;
    }
    
    static void dfs(int[] numbers, int target, int idx, int total) {
    	if(idx == numbers.length) {
    		if(total == target) {
    			cnt++;
    		}
    		return;
    	}
    	
    	
    	dfs(numbers, target, idx + 1, total + numbers[idx]);
    	dfs(numbers, target, idx + 1, total - numbers[idx]);
    }
}