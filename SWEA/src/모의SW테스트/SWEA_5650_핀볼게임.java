package 모의SW테스트;
import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_5650_핀볼게임 {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] map;
	static int ans;
	static int[][] block = { {}, { 1, 3, 0, 2 }, { 3, 0, 1, 2 }, { 2, 0, 3, 1 }, { 1, 2, 3, 0 }, { 1, 0, 3, 2 } };

	static class Node {
		int r, c;

		Node(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();

			map = new int[N + 2][N + 2];
			int ans = 0;
			ArrayList<Node>[] hole = new ArrayList[11];

			for (int i = 6; i <= 10; i++) {
				hole[i] = new ArrayList<>();
			}

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					map[0][j] = map[N + 1][j] = 5;
					map[i][0] = map[i][N + 1] = 5;
					map[i][j] = sc.nextInt();
					if (map[i][j] >= 6) {
						hole[map[i][j]].add(new Node(i, j));
					}
				}
			} //입력
			
			for(int r = 1; r <= N; r++) {
				for(int c = 1; c <= N; c++) {
					if(map[r][c] == 0) {
						for(int d = 0; d < 4; d++) {
							int currR = r;
							int currC = c;
							int currD = d;
							int score = 0;
							
							while(true) {
								currR += dr[currD];
								currC += dc[currD];
								if((currR == r && currC == c) || map[currR][currC] == -1) {
									ans = Math.max(ans, score);
									break;
								}
								if(map[currR][currC] >= 1 && map[currR][currC] <= 5) {
									int check = map[currR][currC];
									currD = block[check][currD];
									score++;
									continue;
									}
								
								if(map[currR][currC] >= 6 && map[currR][currC] <= 10) {
									int num = map[currR][currC];
									
									Node n1 = hole[num].get(0);
									Node n2 = hole[num].get(1);
									
									if(currR == n1.r && currC == n1.c) {
										currR = n2.r;
										currC = n2.c;
									}
									else {
										currR = n1.r;
										currC = n1.c;
									}
									continue;
								} //if hole
							}//while
							
						}//for direction
					}
					
				}
			}
			
			System.out.println("#" + tc + " " + ans);
		} //tc

	}
}
