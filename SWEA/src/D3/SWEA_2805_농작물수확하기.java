package D3;

import java.util.Scanner;

public class SWEA_2805_농작물수확하기 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			String[] line = new String[N];
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i++) {
				line[i] = sc.next();
			}
			
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = line[i].charAt(j) - '0';
				}
			}
			
			int sum = 0;
			int mid = N / 2;
			int start = mid;
			int end = mid;
			
			for(int i = 0; i < N; i++) {
				for(int j = start; j <= end; j++) {
					sum += map[i][j];
				}
				if(i < mid) {
					start--;
					end++;					
				}
				else{
					start++;
					end--;
				}
				
			}
			System.out.println("#" + tc + " " + sum);
		}
	}
}
