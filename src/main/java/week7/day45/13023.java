package week7.day45;
import java.util.ArrayList;
import java.util.Scanner;

class Main {
	static ArrayList<Integer>[] arr;
	static boolean[] visited;
	static int v, e;
	static int answer = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		v = sc.nextInt();
		e = sc.nextInt();
		arr = new ArrayList[v];
		visited = new boolean[v];
		
		for(int i=0; i<v; i++) {
			arr[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<e; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			arr[x].add(y);
			arr[y].add(x);
		}
		for(int i=0; i<v; i++) {
			visited[i] = true;
			dfs(i, 1);
			visited[i] = false;
		}
		
		System.out.println(answer);
	}
	
	private static void dfs(int n, int depth) {
		if(depth >= 5 || answer==1) {
			answer = 1;
			return;
		}
		
		
		for(int next: arr[n]) {
			
			if(!visited[next]) {
				visited[next] = true;
				dfs(next, depth+1);
				visited[next] = false;	
			}
		}
		
	}
}