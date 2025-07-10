import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	static int n;
	static int m;
	static int k;
	
	static int[][] board;
	static boolean[][][] visited;
	
	static int[] dx = {-1, 1, 0, 0, 2, 2, -2, -2, 1, 1, -1, -1};
	static int[] dy = {0, 0, -1, 1, 1, -1, -1, 1, 2, -2, 2, -2};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		k = Integer.parseInt(in.readLine());
		
		String[] _input = in.readLine().split(" ");
		m = Integer.parseInt(_input[0]);
		n = Integer.parseInt(_input[1]);

		board = new int[n][m];
		visited = new boolean[n][m][k+1];
		
		
		
		for(int i=0; i<n; i++) {
			String[] input = in.readLine().split(" ");
			for(int j=0; j<m; j++) {
				board[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		System.out.println(bfs(0,0));
	}

	private static int bfs (int startX, int startY) {
		Queue<int[]> q = new ArrayDeque<>();
		visited[startY][startX][k] = true;
		q.offer(new int[] {startX, startY, 0, k});
		
		while(!q.isEmpty()) {
			int[] p = q.poll();
			int x = p[0];
			int y = p[1];
			int depth = p[2];
			int jumpCnt = p[3];
			
			if(x == m-1 && y == n-1) {
				return depth;
			}
			
			for(int i=0; i<12; i++) {
				int xx = x+dx[i];
				int yy = y+dy[i];
				
				if(i>=4) {
					
					if(jumpCnt == 0) break;
					if(!check(xx,yy,jumpCnt-1)) continue;
					visited[yy][xx][jumpCnt-1] = true;
					q.offer(new int[] {xx,yy,depth+1, jumpCnt-1});
				}
				else {
					if(!check(xx,yy,jumpCnt)) continue;
					visited[yy][xx][jumpCnt] = true;
					q.offer(new int[] {xx,yy,depth+1, jumpCnt});	
				}
				
			}
		}
		
		return -1;
	}
	
	private static boolean check(int x, int y, int j) {
		if(x<0 || y<0 || x>=m || y>=n) return false;
		if(visited[y][x][j]) return false;
		if(board[y][x] == 1) return false;
		return true;
	}
}
