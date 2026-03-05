package 모의SW테스트;

import java.util.Scanner;

public class SWEA_4123_숫자만들기 {
	static int[] op;
	static int[] nums;
	static int N, max, min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			
			op = new int[4];
			nums = new int[N];
			for(int i = 0; i < 4; i++) {
				op[i] = sc.nextInt();
			}
			
			for(int i = 0; i < N; i++) {
				nums[i] = sc.nextInt();
			}
			
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			
			find(1, nums[0]);
			
			System.out.println("#" + tc + " " + (max - min));
			
			
		}
	}
	
	static void find(int depth, int cResult) {
		if(depth == N) {
			max = Math.max(max, cResult);
			min = Math.min(min, cResult);
			return;
		}
		
		for(int i = 0; i < 4; i++) {
			if(op[i] > 0) {
				op[i]--;
				
				if(i == 0) find(depth + 1, cResult + nums[depth]);
				else if(i == 1) find(depth + 1, cResult - nums[depth]);
				else if(i == 2) find(depth + 1, cResult * nums[depth]);
				else if(i == 3) find(depth + 1, cResult / nums[depth]);
				
				op[i]++;
			}
			
		}
	}
}
