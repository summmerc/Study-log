package D4;
import java.util.Scanner;

public class SWEA_1210_Ladder1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int t = sc.nextInt();

			int[][] map = new int[100][100];
			int r = 0;
			int c = 0;

			for (int row = 0; row < 100; row++) {
				for (int col = 0; col < 100; col++) {
					map[row][col] = sc.nextInt();
					if (map[row][col] == 2) {
						r = row;
						c = col;
					}
				}
			}
			
			while(r > 0) {
				if(c > 0 && map[r][c - 1] == 1) {
					while(c > 0 && map[r][c - 1] == 1) {
						c--;
					}
				}
				else if(c < 99 && map[r][c + 1] == 1) {
					while(c < 99 && map[r][c + 1] == 1) {
						c++;
					}
				}
				r--;
			}

			int result = c;
			
			System.out.println("#" + tc + " " + result);
		}
	}
}
