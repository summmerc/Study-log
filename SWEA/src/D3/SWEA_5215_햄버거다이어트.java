package D3;

import java.util.Scanner;

public class SWEA_5215_햄버거다이어트 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int L = sc.nextInt();
			
			int[] S = new int[N];
			int[] C = new int[N];
			
			for(int i = 0; i < N; i++) {
				S[i] = sc.nextInt();
				C[i] = sc.nextInt();
			}
			
			int max = 0;
			
			for(int i = 0; i < (1 << N); i++) {
				int sumS = 0;
				int sumC = 0;
				for(int j = 0; j < N; j++) {
					if((i & (1 << j)) != 0) {
						sumS += S[j];
						sumC += C[j];
						
						if(sumC > L) break;	
					}
				}
				if(sumC <= L) {
					if(sumS > max)
						max = sumS;
				}
			}
			
			System.out.println("#" + tc + " " + max);
			
		}
	}
}
