package D3;
import java.util.Scanner;

public class SWEA_1209_Sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc = 0; tc < 10; tc++) {
			int[][] arr = new int[100][100];
			
			int t = sc.nextInt();
			for(int row = 0; row < 100; row++) {
				for(int col = 0; col < 100; col++) {
					arr[row][col] = sc.nextInt();
				}
			}
			
			int max = 0;
			int sum = 0;
			for(int i = 0; i < 100; i++) {
				sum = 0;
				for(int j = 0; j < 100; j++) {
					sum += arr[i][j];
				}
				if(sum > max) max = sum;
			}
			
			for(int j = 0; j < 100; j++) {
				sum = 0;
				for(int i = 0; i < 100; i++) {
					sum += arr[i][j];
				}
				if(sum > max) max = sum;
			}
			
			sum = 0;
			for(int i = 0; i < 100; i++) {
				sum += arr[i][i];
			}
			if(sum > max) max = sum;
			
			sum = 0;
			for(int i = 0; i < 100; i++) {
				sum += arr[i][99-i];
			}
			if(sum > max) max = sum;
			
			System.out.println("#" + t + " " + max);
		}
		
		
	}
}
