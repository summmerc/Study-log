package Level11;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class 뱀은사과를좋아해 {
	static int N;
	static int[][] map;
	static int M; //사과의 개수
	static int K; //뱀의 방향 변환 횟수
	static int[] dr = {-1, 1, 0, 0}; //상하좌우
	static int[] dc = {0, 0, -1, 1};
	static Queue<int[]> list;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//뱀은 길이 1
		//사과x 이동시 가장 끝 꼬리가 사라짐
		//사과o 이동시 길이+1
		//뱀이 전부 움직이거나 움직이는 도중 격자를 벗어나거나, 움직이는 도중 몸이 꼬여 서로 겹쳤을 경우 -> 종료
		
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][N];
		
		for(int i = 0; i < M; i++) {
			int r = sc.nextInt() - 1;
			int c = sc.nextInt() - 1;
			
			map[r][c] = 1; //사과
		}
		
		list = new ArrayDeque<>();
		for(int i = 0; i < K; i++) {
			int dir = findDir(sc.next().charAt(0));
			int num = sc.nextInt();
			
			list.add(new int[] {dir, num});
		}
		
		snake();
	}
	
	static int findDir(char dir) { //방향을 숫자로 표현
		if(dir == 'U') {
			return 0;
		} else if(dir == 'D') {
			return 1;
		} else if(dir == 'L') {
			return 2;
		} else {
			return 3;
		}
	}
	
	static void snake() {
		Queue<int[]> q = new ArrayDeque<>();
		map[0][0] = 2;
		
		q.add(new int[] {0, 0});
		int time = 0;
		int curR = 0;
		int curC = 0;
		
		while(!list.isEmpty()) {
			int[] curr = list.poll();
			int dir = curr[0];
			int num = curr[1];
			
			for(int i = 0; i < num; i++) {
				time++;
				int nr = curR + dr[dir];
				int nc = curC + dc[dir];
				
				if(nr < 0 || nr >= N || nc < 0 || nc >= N) {
					System.out.println(time);
					return;
				}
				boolean isApple = (map[nr][nc] == 1);
				if(!isApple) {
					int[] tail = q.poll();
					map[tail[0]][tail[1]] = 0;
				}
				
				if(map[nr][nc] == 2) {
					System.out.println(time);
					return;
				}
				
				map[nr][nc] = 2;
				q.add(new int[] {nr, nc});
				curR = nr;
				curC = nc;
			}
		}
		
		System.out.println(time);
	}
}
