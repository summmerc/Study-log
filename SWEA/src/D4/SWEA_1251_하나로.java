package D4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class SWEA_1251_하나로 {
	static long[] x;
	static long[] y;
	static int[] p;
	static List<Edge> edges;
	
	static class Edge implements Comparable<Edge> {
		int from, to;
		long dis;

		public Edge(int from, int to, long dis) {
			super();
			this.from = from;
			this.to = to;
			this.dis = dis;
		}

		@Override
		public int compareTo(Edge o) {
			return Long.compare(this.dis, o.dis);
		}
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			
			x = new long[N];
			y = new long[N];
			
			for(int i = 0; i < N; i++) {
				x[i] = sc.nextLong();
			}
			for(int i = 0; i < N; i++) {
				y[i] = sc.nextLong();
			}
			double E = sc.nextDouble();
			
			edges = new ArrayList<>();
			
			for(int i = 0; i < N; i++) {
				for(int j = i + 1; j < N; j++) {
					long dx = x[i] - x[j];
					long dy = y[i] - y[j];
					long L = (dx * dx) + (dy * dy);
					edges.add(new Edge(i, j, L));
				}
			}
			
			Collections.sort(edges);
			
			
			p = new int[N];
			for(int i = 0; i < N; i++) {
				p[i] = i;
			}
			
			double total = 0.0;
			
			for(int i = 0, pick = 0; i < edges.size() && pick < N - 1; i++) {
				int from = edges.get(i).from;
				int to = edges.get(i).to;
				
				if(findSet(from) != findSet(to)) {
					union(from, to);
					pick++;
					total += (double)edges.get(i).dis;
				}
			}
			
			long result = Math.round(total * E);
			System.out.println("#" + tc + " " + result);
		}
	}
	
	static int findSet(int x) {
		if(x == p[x]) return x;
		return p[x] = findSet(p[x]);
	}
	
	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}
}
