package D4;
import java.util.Scanner;

public class SWEA_3289_서로소집합 {
	static int n;
	static int m;
	static int[] p;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			n = sc.nextInt();
			m = sc.nextInt(); //연산의 개수
			
			p = new int[n + 1];
			for(int i = 1; i <= n; i++) {
				p[i] = i;
			}
			
			System.out.print("#" + tc + " ");
			
			for(int i = 0; i < m; i++) {
				int c = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				if(c == 0) {
					union(a, b);
				}
				else {
					if(findSet(a) == findSet(b))
						System.out.print("1");
					else {
						System.out.print("0");
					}
				}
			}
			
			System.out.println();
		}
	}
	
	static int findSet(int x) {
		if(x != p[x]) {
			p[x] = findSet(p[x]);
		}
		return p[x];
	}
	static void union(int a, int b) {
		p[findSet(b)] = findSet(a);
	}
}
