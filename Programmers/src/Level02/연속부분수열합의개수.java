package Level02;

import java.util.HashSet;
import java.util.Set;

class 연속부분수열합의개수 {
	static Set<Integer> result;
    public int solution(int[] elements) {
    	result = new HashSet<>();
    	
    	int[] big = new int[elements.length * 2];
    	for(int i = 0; i < big.length; i++) {
    		big[i] = elements[i % elements.length];
    	}
    	
    	for(int i = 1; i <= elements.length; i++) { //배열길이
    		for(int j = 0; j < elements.length; j++) { //시작점 위치
    			int sum = 0;
    			for(int k = 0; k < i; k++) {
    				sum += big[j + k];
    			}
    			result.add(sum);
    		}
    	}
    	
        return result.size();
    }
    
}