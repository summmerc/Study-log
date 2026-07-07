import java.util.Arrays;
import java.util.HashSet;

class Solution {
	static boolean[] visited;
	static HashSet<String> set;
	static int[] picked;

	public int solution(String[] user_id, String[] banned_id) {
		visited = new boolean[user_id.length];
		set = new HashSet<>();
		picked = new int[banned_id.length];

		dfs(0, user_id, banned_id);

		return set.size();
	}

	static void dfs(int idx, String[] user_id, String[] banned_id) {
    	
    	if(idx == banned_id.length) {
    		int[] copy = picked.clone();
    		Arrays.sort(copy);
    		set.add(Arrays.toString(copy));
    		return;
    	}
    	
    	for(int i = 0; i < user_id.length; i++) {
    		if(visited[i]) continue;
    		if(isMatch(user_id[i], banned_id[idx])) {
    			visited[i] = true;
    			picked[idx] = i;
    			
    			dfs(idx + 1, user_id, banned_id);
    			
    			visited[i] = false;
    		}
    	}
    }

	static boolean isMatch(String user, String banned) {
		if(user.length() != banned.length()) return false;
		for(int i = 0; i < banned.length(); i++) {
			if(banned.charAt(i) == '*') continue;
			if(user.charAt(i) != banned.charAt(i)) return false;
		}
		return true;
	}

}