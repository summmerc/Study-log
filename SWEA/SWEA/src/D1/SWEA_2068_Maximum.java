package D1;

import java.util.Scanner;

public class SWEA_2068_Maximum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int [][] arr = new int[N][10];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < 10; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < N; i++) {
			int max = arr[i][1];
			for(int j = 0; j < 10; j++) {
				if(max < arr[i][j]) {
					max = arr[i][j];
				}
			}
			System.out.println("#" + (i + 1) + " " + max);
		}
	}	
	
}
