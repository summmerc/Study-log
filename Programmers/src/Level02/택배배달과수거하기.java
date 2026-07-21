package Level02;

public class 택배배달과수거하기 {
	static long total;
	static int deliver;
	static int pickup;
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
    	total = 0;
    	deliver = 0;
    	pickup = 0;
    	
    	for(int i = n - 1; i >= 0; i--) {
    		
    		if(deliveries[i] > 0 || pickups[i] > 0) {
    			int visited = 0;
    			
    			while(deliver < deliveries[i] || pickup < pickups[i]) {
    				visited++;
    				deliver += cap;
    				pickup += cap;
    			}
    			
    			deliver -= deliveries[i];
    			pickup -= pickups[i];
    			
    			total += (long)(i + 1) * 2 * visited;
    		}
    	}
    	
        return total;
    }
}
