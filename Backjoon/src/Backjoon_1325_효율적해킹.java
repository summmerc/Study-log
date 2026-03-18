import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Backjoon_1325_효율적해킹 {
	static int N, M;
	static int[] count;
	static int max;
	static ArrayList<Integer>[] trust;
	static boolean[] hacked;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		trust = new ArrayList[N + 1];
		for(int i = 0; i <= N; i++) {
			trust[i] = new ArrayList<>();
		}
		max = Integer.MIN_VALUE;
		count = new int[N + 1];
		
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt(); //A
			int b = sc.nextInt(); //B를 신뢰한다
			
			trust[b].add(a);
			
		}
		
		for(int i = 1; i <= N; i++) {
			hacked = new boolean[N + 1];
			hacking(i);
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= N; i++) {
			if(count[i] == max)
				sb.append(i).append(" ");
		}
		
		System.out.println(sb.toString());
		
		
	}
	
	static void hacking(int start) {
		Queue<Integer> check = new ArrayDeque<>();
		check.offer(start);
		hacked[start] = true;

		int cnt = 0;
		
		while(!check.isEmpty()) {
			int curr = check.poll();
			for(int next : trust[curr]) {
				if(hacked[next]) continue;
				hacked[next] = true;
				check.offer(next);
				cnt++;
			}
			
		}
		count[start] = cnt;
		max = Math.max(max, cnt);
	}
}
