package D3;

import java.util.Scanner;
import java.util.Stack;

public class SWEA_8931_제로 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);;
		
		Stack<Integer> stack = new Stack<>();
		
		int T = sc.nextInt();
		for(int tc = 1; tc <= T; tc++) {
			int sum = 0;
			
			int K = sc.nextInt();
			int[] arr = new int[K];
			for(int i = 0; i < K; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i = 0; i < K; i++) {
				if(arr[i] == 0) {
					stack.pop();
				}
				else {
					stack.push(arr[i]);
				}
			}
			
			while(!stack.isEmpty()) {
				sum += stack.pop();
			}
			
			System.out.println("#" + tc + " " + sum);
		}
	}
}
