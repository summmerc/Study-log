import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;


public class Main {
	static int N;
	static class Point implements Comparable<Point> {
		int x, v, index;
		
		public Point(int x, int v, int index) {
			this.x = x;
			this.v = v;
			this.index = index;
		}
		
		@Override
		public int compareTo(Point p) {
			if(this.x != p.x) {
				return Integer.compare(this.x, p.x);
			}
			return Integer.compare(p.v, this.v);
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		ArrayList<Point> points = new ArrayList<>();
		
		for(int i = 0; i < N; i++) {
			int x1 = sc.nextInt();
			int x2 = sc.nextInt();
			
			points.add(new Point(x1, 1, i));
			points.add(new Point(x2, -1, i));
		}
		
		Collections.sort(points);
		
		long length = 0;
		HashSet<Integer> set = new HashSet<>();
		
		for(int i = 0; i < 2 * N; i++) {
			int x = points.get(i).x;
			int v = points.get(i).v;
			int idx = points.get(i).index;
			
			
			if(v == 1) {
				set.add(idx);
			} else {
				set.remove(idx);
			}
			
			if(i < 2 * N - 1) {
				int next = points.get(i + 1).x;
				if(next > x && set.size() > 0) {
					length += (next - x);					
				}
			}
		}
		
		System.out.println(length);
	}
}
