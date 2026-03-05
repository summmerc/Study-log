package D2;

import java.util.Scanner;

public class SWEA_1984_mean {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		int[][] arr = new int[N][10];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < 10; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < N; i++) {
			int total = 0;
			int max = arr[i][1];
			int min = arr[i][1];
			for(int j = 0; j < 10; j++) {
				if(arr[i][j] > max) {
					max = arr[i][j];
				}
				if(arr[i][j] < min) {
					min = arr[i][j];
				}
				total += arr[i][j];
			}
			total = total - max - min;
			int mean = (int)Math.round(total / 8.0);
			System.out.println("#" + (i + 1) + " " + mean);
		}

	}
}
