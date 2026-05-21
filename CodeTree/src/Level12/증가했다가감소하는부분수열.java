package Level12;
import java.util.Scanner;

public class 증가했다가감소하는부분수열 {
	static int N;
	static int[] arr;
	static int[] increase;
	static int[] decrease;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
		N = sc.nextInt();
		
		arr = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		increase = new int[N];
		decrease = new int[N];
		
		for(int i = 0; i < N; i++) {
			increase[i] = 1;
			for(int j = 0; j < i; j++) {
				if(arr[j] < arr[i]) {
					increase[i] = Math.max(increase[j] + 1, increase[i]);
				}
			}
		}
		
		for(int i = N - 1; i >= 0; i--) {
			decrease[i] = 1;
			for(int j = N - 1; j > i; j--) {
				if(arr[j] < arr[i]) {
					decrease[i] = Math.max(decrease[j] + 1, decrease[i]);
				}
			}
		}
		
		int max = 0;
		for(int i = 0; i < N; i++) {
			int total = increase[i] + decrease[i] - 1;
			if(total < max) continue;
			max = Math.max(total, max);
		}
		
		System.out.println(max);
	}
}
