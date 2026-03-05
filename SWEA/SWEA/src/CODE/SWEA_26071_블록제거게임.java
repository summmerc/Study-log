package CODE;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SWEA_26071_블록제거게임 {
	static int max;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			List<Integer> blocks = new ArrayList<>();
			for(int i = 0; i < N; i++) {
				blocks.add(sc.nextInt());
			}
			
			max = Integer.MIN_VALUE;
			solve(blocks, 0);
			
			System.out.println("#" + tc + " " + max);
		}
	}
	
	public static void solve(List<Integer> blocks, int Sum) {
		if(blocks.isEmpty()) {
			max = Math.max(max, Sum);
			return;
		}
		
		int n = blocks.size();
		
		for(int i = 0; i < n; i++) {
			int score = 0;
			int removed = blocks.get(i);
			
			if(n == 1) {
				score = removed;
			} else if(i == 0) {
				score = blocks.get(1);
			} else if(i == n - 1) {
				score = blocks.get(i - 1);
			} else {
				score = blocks.get(i - 1) * blocks.get(i + 1);
			}
			
			blocks.remove(i);
			solve(blocks, Sum + score);
			blocks.add(i, removed);
		}
	}
}
