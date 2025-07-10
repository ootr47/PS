import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	static class Position {
		int x;
		int y;
		public Position(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
		
		public int getDist(Position p) {
			return Math.abs(p.x - this.x) + Math.abs(p.y-this.y);
		}
	}
	
	static int N;
	static boolean[] visited;
	static Position[] stores;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <=T; test_case++) {
			
			N = Integer.parseInt(br.readLine());
			stores = new Position[N+2];
			visited = new boolean[N+2];
			
			for(int i=0; i<N+2; i++) {
				String[] input = br.readLine().split(" ");
				stores[i]=new Position(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
			}
			
			if(bfs()) System.out.println("happy");
			else System.out.println("sad");
					}
		System.out.println(sb);
	}		
	
	private static boolean bfs() {
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(0);
		
		while(!q.isEmpty()) {
			int curIdx = q.poll();
			Position cur = stores[curIdx];
			
			visited[curIdx] = true;
			
			for(int i=1; i<N+2; i++) {
				Position next = stores[i];
				if(cur.getDist(next) <= 1000 && !visited[i]) {
					if(i==N+1) return true;
					q.offer(i);
				}
			}
		}
		return false;
	}
}
