import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	static int K;
	static int[][] m;
	static int[] moveD;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++) {
			K = sc.nextInt();
			m = new int[4][8];
			//자석 서로 닿는 부분 2, 6
			
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < 8; j++) {
					m[i][j] = sc.nextInt();
				}
			}
			
			for(int i = 0; i < K; i++) {
				int s = sc.nextInt();
				int dir = sc.nextInt();
				moveD = new int[4];
				
				//while문 전파로 다시 풀어보기
				for(int j = 0; j < 3; j++) {
					if(m[j][2] != m[j + 1][6]) {
						moveD[j + 1] = -1;
					}
				}
				
				if(moveD[s - 1] == dir) {
					move();
				}
				else {
					for(int j = 0; j < 4; j++) {
						moveD[j] = moveD[j] * -1;
						move();
					}
				}
			}
		}
	}
	
	static void move() {
		for(int i = 0; i < 4; i++) {
			if(moveD[i] == 1) {
				//시계방향 i + 1 % 7
				Queue<Integer> q = new ArrayDeque<>();
				q.add(m[i][7]);
				for(int j = 0; j < 7; j++) {
					q.add(m[i][j]);
				}
			}
			else if(moveD[i] == -1) {
				//반시계방향 i + 7 % 8
				
			}
			
		}
	}
}
