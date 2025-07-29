package week7.day46;
import java.io.IOException;
import java.util.Scanner;

class Main {

	static int N;
	static int start;
	static int end;
	static int MAX_WEIGHT = 9999999;

	static int[][] distance;
	static int[][] adjMatrix;
	static boolean[][] visited;

	static int[] d = { -1, 0, 1, 0 };

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int cnt = 1;

		while ((N = sc.nextInt()) != 0) {
			adjMatrix = new int[N][N];
			distance = new int[N][N];
			visited = new boolean[N][N];

			start = 0;
			end = N * N - 1;

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adjMatrix[i][j] = sc.nextInt();
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					distance[i][j] = MAX_WEIGHT;
				}
			}

			distance[start][start] = 0;

			int cx = 0;
			int cy = 0;

			while (true) {
				int min = Integer.MAX_VALUE;

				for (int i = 0; i < N; i++) {
					for (int j = 0; j < N; j++) {
						if (!visited[i][j] && distance[i][j] < min) {
							cx = j;
							cy = i;
							min = distance[cy][cx];
						}
					}
				}

				visited[cy][cx] = true;
				if (cx == N - 1 && cy == N - 1)
					break;

				for (int i = 0; i < 4; i++) {
					int xx = cx + d[i];
					int yy = cy + d[(i + 1) % 4];

					if (xx < 0 || yy < 0 || xx >= N || yy >= N)
						continue;
					if (visited[yy][xx])
						continue;

					int dist = distance[yy][xx];
					if (distance[cy][cx] + adjMatrix[yy][xx] < dist) {
						distance[yy][xx] = distance[cy][cx] + adjMatrix[yy][xx];
					}
				}
			}

			System.out.println("Problem " + cnt++ + ": " + (distance[N - 1][N - 1] + adjMatrix[0][0]));

		}

	}

}