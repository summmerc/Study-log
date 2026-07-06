import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class Practice {
	static int N;
	static int K;
	static TreeSet<Integer> ts;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			String s = sc.next();
			
			ts = new TreeSet<>(Collections.reverseOrder());
			
			int size = N / 4;
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < N; j += size) {
					String tmp = s.substring(j, j + size);
					ts.add(Integer.parseInt(tmp, 16));
				}
			}
			
			int pass = 0;
			int cnt = 1;
			for(int find : ts) {
				if(cnt == K) {
					pass = find;
					break;
				}
				cnt++;
			}
			
			System.out.println("#" + tc + " " + pass);
		}
	}
}
