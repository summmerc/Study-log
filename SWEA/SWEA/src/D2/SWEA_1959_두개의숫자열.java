package D2;

import java.util.Scanner;

public class SWEA_1959_두개의숫자열 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int A[] = new int[N];
			int B[] = new int[M];
			
			for(int i = 0; i < N; i++) {
				A[i] = sc.nextInt();
			}
			
			for(int i = 0; i < M; i++) {
				B[i] = sc.nextInt();
			}
			
			int result = 0;
			if(N > M) {
				for(int i = 0; i <= N - M; i++) {
					int sum = 0;
					for(int j = 0; j < M; j++) {
						sum += A[i + j] * B[j];
					}
					if(sum > result) result = sum;
				}
			}
			else {
				for(int i = 0; i <= M - N; i++) {
					int sum = 0;
					for(int j = 0; j < N; j++) {
						sum += B[i + j] * A[j];
					}
					if(sum > result) result = sum;
				}
			}
			
			System.out.println("#" + tc + " " + result);
		}
	}
}
