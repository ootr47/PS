package week5.day35_0713;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

class Main {
    
    static int n;
    static int m;
    static int[][] map;
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        map = new int[n][m];
        visited = new boolean[n][m][2];
    

        for(int i=0; i<n; i++) {
            String input = sc.next();
            for(int j=0; j<m; j++) {
                map[i][j] = input.charAt(j) - '0';
            }
        }

        System.out.println(bfs());

    }
    static int[] d = {-1,0,1,0};

    private static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        Queue<Integer> depthQ = new ArrayDeque<>();
        queue.add(new int[]{0, 0, 0});
        depthQ.add(1);
        visited[0][0][0] = true;

        while(!queue.isEmpty()) {
            int[] cur = queue.poll();
            int depth = depthQ.poll();


            if(cur[0] == n-1 && cur[1] == m-1) return depth;
            // System.out.println(cur[0] + " / " + cur[1] + " / " + cur[2]);

            for(int i=0; i<4; i++) {
                int nx = cur[0] + d[i];
                int ny = cur[1] + d[(i+1)%4];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m) continue;
                if(visited[nx][ny][cur[2]] == true) continue;

                if(map[nx][ny] == 1) {
                    if(cur[2] == 0) {
                        queue.offer(new int[]{nx, ny, cur[2]+1});
                        depthQ.offer(depth+1);
                        visited[nx][ny][cur[2]+1] = true;
                    }
                }
                else {
                    queue.offer(new int[]{nx, ny, cur[2]});
                    depthQ.offer(depth+1);
                    visited[nx][ny][cur[2]] = true;
                }

                
            }
        }
        return -1;
    }

}