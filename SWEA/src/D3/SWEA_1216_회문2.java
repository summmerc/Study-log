package D3;
import java.util.Scanner;

public class SWEA_1216_회문2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = 100;
		for(int tc = 1; tc <= 10; tc++) {
			int t = sc.nextInt();
			
			char[][] map = new char[N][N];
			
			for(int i = 0; i < N; i++) {
				String line = sc.next();
				for(int j = 0; j < N; j++) {
					map[i][j] = line.charAt(j);
				}
			}
			int max = 1;
			
			for(int len = N; len >= 1; len--) {
				boolean found = false;
				for(int i = 0; i < N && !found; i++) {
					for(int start = 0; start <= N - len; start++) {
						int left = start;
						int right = start + len - 1;
						boolean ok = true;
						
						while(left < right) {
							if(map[i][left] != map[i][right]) {
								ok = false;
								break;
							}
							left++;
							right--;
						}
						if(ok) {
							max = len;
							found = true;
							break;
						}
						
						left = start;
						right = start + len - 1;
						ok = true;
						
						while(left < right) {
							if(map[left][i] != map[right][i]) {
								ok = false;
								break;
							}
							left++;
							right--;
						}
						
						if(ok) {
							max = len;
							found = true;
							break;
						}
					}
				}
				if(found) break;
			}			
			
			System.out.println("#" + t + " " + max);
		}
	}
}
