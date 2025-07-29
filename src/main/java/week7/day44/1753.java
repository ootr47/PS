package week7.day44;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

	static class Edge {
		int no;
		int weight;

		public Edge(int no, int weight) {
			super();
			this.no = no;
			this.weight = weight;
		}

	}

	static int V;
	static int E;
	static int start;

	static int[] distance;
	static List<Edge>[] adjList;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		V = Integer.parseInt(st.nextToken()) + 1;
		E = Integer.parseInt(st.nextToken());

		adjList = new ArrayList[V];
		distance = new int[V];
		visited = new boolean[V];

		start = Integer.parseInt(br.readLine());

		for (int i = 0; i < V; i++) {
			adjList[i] = new ArrayList<>();
			distance[i] = 9999999;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());

			adjList[from].add(new Edge(to, weight));
		}

		distance[start] = 0;

		int current = start;

		for (int cnt = 1; cnt < V; cnt++) {
			int min = distance[0];
			current = -1;

			for (int i = 1; i < V; i++) {
				if (!visited[i] && distance[i] < min) {
					min = distance[i];
					current = i;
				}
			}
			
			if(current == -1) break;
			visited[current] = true;

			for (Edge next : adjList[current]) {
				if (visited[next.no])
					continue;

				if (distance[current] + next.weight < distance[next.no]) {
					distance[next.no] = distance[current] + next.weight;
				}
			}
		}

		for (int i = 1; i < V; i++) {
			int dist = distance[i];

			if (dist == 9999999) {
				System.out.println("INF");
			} else {
				System.out.println(dist);
			}
		}
	}

}