import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	static int r;
	static int c;
	static int[][] arr;
	static boolean[][] visited;
	
	static int result;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	
		String[] input_ = in.readLine().split(" ");
		
		r = Integer.parseInt(input_[0]);
		c = Integer.parseInt(input_[1]);
		
		arr = new int [r][c];
		visited = new boolean[r][c];
		
		result = 0;
		
		for(int i=0; i<r; i++) {
			String input = in.readLine();
		 	for(int j=0; j<c; j++) {
		 		if(input.charAt(j) == '.') arr[i][j] = 1;
		 		else arr[i][j]=0;
		 	}
		}
		
		for(int i=0; i<r; i++) dfs(0, i);
		
		System.out.println(result);
	}
	
	private static void dfs(int x, int y) {
		if(y<0 || x<0 || y>=r || x>=c) return;
		if(visited[y][x]) return;
		if(arr[y][x]==0) return;
		
		visited[y][x] = true;
		
		if(x==c-1) {
			result++;
			return;
		}
		
		int temp = result;
		
		for(int i=-1; i<=1; i++) {
			dfs(x+1, y+i);
			if(temp!=result) break;
		}
	
	}
	
}