import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int N;
	static int S;
	static LinkedList<Integer>[] list;
	static int[] visited;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int tc = 1; tc <= 10; tc++) {
			N = sc.nextInt();
			S = sc.nextInt();
			
			list = new LinkedList[101];
			
			for(int i = 1; i <= 100; i++) {
				list[i] = new LinkedList<>();
			}
			
			for(int i = 0; i < N / 2; i++) {
				int from =  sc.nextInt();
				int to = sc.nextInt();
				
				list[from].add(to);
			}
			
			visited = new int[101];
			call(S);
			
			int idx = 0;
			int max = 0;
			for(int i = 1; i <= 100; i++) {
				if(visited[i] > max) {
					max = visited[i];
					idx = i;
				}
			}
			
			System.out.println("#" + tc + " " + idx);
		}
	}
	
	static void call(int start) {
		Queue<Integer> q = new ArrayDeque<>();
		q.add(start);
		visited[start] = 1;
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int next : list[curr]) {
				if(visited[next] == 0) {
					visited[next] = visited[curr] + 1;
					q.add(next);
				}
			}
		}
	}
}
