package Level12;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class 네가지연산을이용하여1만들기 {
	static int N;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		
		if(N == 1) {
			System.out.println(0);
			return;
		}
		
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N + 3];
		
		q.add(N);
		visited[N] = true;
		
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			
			for(int i = 0; i < size; i++) {
				int curr = q.poll();
				
				if(curr == 1) {
					System.out.println(cnt);
					return;
				}
				
				if(curr - 1 >= 1 && !visited[curr - 1]) {
					q.add(curr - 1);
					visited[curr - 1] = true;
				}
				
				if(curr + 1 <= N + 2 && !visited[curr + 1]) {
					q.add(curr + 1);
					visited[curr + 1] = true;
				}
				
				if(curr % 2 == 0 && !visited[curr / 2]) {
					q.add(curr / 2);
					visited[curr/2] = true;
				}
				
				if(curr % 3 == 0 && !visited[curr / 3]) {
					q.add(curr / 3);
					visited[curr/3] = true;
				}
			}
			
			cnt++;
		}
	}
}
