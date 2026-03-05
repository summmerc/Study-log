package D3;
import java.util.Scanner;

public class SWEA_1206_BuildingView {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 0 ; i < 10; i++) {
			int N = sc.nextInt();
			int[] b = new int[N];
			
			for(int j = 0; j < N; j++) {
				b[j] = sc.nextInt();
			}
			
			
			int total = 0;
			for(int h = 2; h < N - 2; h++) {
				int max = b[h - 1];
				if(b[h - 2] > max) max = b[h - 2];
				if(b[h + 1] > max) max = b[h + 1];
				if(b[h + 2] > max) max = b[h + 2];
				
				if(b[h] > max) {
					total += b[h] - max;
				}
			}
			System.out.println("#" + (i + 1) + " " + total);
		}
		
	}
}
