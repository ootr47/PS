package week3.day17_0625;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Main {
    
    static int n;
    static int m;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m];
    

        for(int i=0; i<n; i++) {
            String input = sc.next();
            for(int j=0; j<m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        System.out.println(bfs(new Position(0,0, 1, false)));

    }
    static int[] d = {-1,0,1,0};

    private static int bfs(Position start) {
        Queue<Position> queue = new ArrayDeque<>();
        queue.add(start);
        visited[start.y][start.x] = true;

        while(!queue.isEmpty()) {
            Position pos = queue.poll();

            for(int i=0; i<4; i++) {
                int nx = pos.x + d[i];
                int ny = pos.y + d[(i+1)%4];

                if(nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                if(visited[ny][nx]) continue;
                if(nx == m-1 && ny == n-1) return pos.depth;

                if(map[ny][nx] == 1 && !pos.isUsedBreak) {
                    visited[ny][nx] = true;
                    queue.offer(new Position(nx, ny, pos.depth+1, true));
                }
                visited[ny][nx] = true;
                queue.offer(new Position(nx, ny, pos.depth+1, pos.isUsedBreak));
            }
        }
        return -1;
    }

    static class Position {
        int x;
        int y;
        int depth;
        boolean isUsedBreak;

        public Position(int x, int y, int depth, boolean isUsedBreak) {
            this.x = x;
            this.y = y;
            this.depth = depth;
            this.isUsedBreak = isUsedBreak;
        }
    }
}