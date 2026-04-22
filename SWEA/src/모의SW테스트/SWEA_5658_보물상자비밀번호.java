package 모의SW테스트;
import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

public class SWEA_5658_보물상자비밀번호 {
	static int N, K;
	static TreeSet<Integer> ts;
	static int[] num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			K = sc.nextInt();
			
			ts = new TreeSet<>(Collections.reverseOrder());
			num = new int[N];
			
			String s = sc.next();
			
			int size = N / 4;
			for(int i = 0; i < size; i++) {
				for(int j = 0; j < N; j += size) {
					String tmp = s.substring(j, j + size);
					ts.add(Integer.parseInt(tmp, 16));
				}
				s = s.charAt(s.length() - 1) + s.substring(0, s.length() - 1);
			}
			int ans = 0;
			int cnt = 1;
			for(int find : ts) {
				if(cnt == K) {
					ans = find;
					break;
				}
				cnt++;
			}
			
			System.out.println("#" + tc + " " + ans);
		}
		
	}
}
