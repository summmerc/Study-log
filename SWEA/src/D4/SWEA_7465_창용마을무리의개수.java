package D4;
import java.util.Scanner;

public class SWEA_7465_창용마을무리의개수 {
	static int N;
	static int M;
	static int[] p;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			M = sc.nextInt();
			
			p = new int[N + 1];
			for(int i = 1; i <= N; i++) {
				p[i] = i;
			}
			
			for(int i = 0; i < M; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				union(a, b);
			}
			
			int[] count = new int[N + 1];
			for(int i = 1; i <= N; i++) {
				findSet(i);
				count[p[i]]++;
			}
			
			int total = 0;
			for(int i = 1; i <= N; i++) {
				if(count[i] != 0) total++;
			}
			
			System.out.println("#" + tc + " " + total);
		}
	}
	
	static int findSet(int x) {
		if(p[x] != x) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}
	
	static void union(int a, int b) {
		p[findSet(b)] = findSet(a);
	}
}
