package D5;

import java.util.Scanner;

public class SWEA_6782_현주가좋아하는제곱근놀이 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			long N = sc.nextLong();

			int cnt = 0;
			while (N != 2) {
				long root = (long)Math.sqrt(N);
				
				if(root * root == N) {
					N = root;
					cnt++;
				}
				else {
					long nextRoot = root + 1;
					long next = nextRoot * nextRoot;
					
					cnt += (next - N);
					N = next;
				}

			}
			System.out.println("#" + tc + " " + cnt);
		}
	}
}
