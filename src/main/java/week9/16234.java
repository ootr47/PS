package week9;
import java.io.*;
import java.util.*;

class Main {
   static int n, l, r;
   static int[][] map;
   static boolean[][] visited;
   static int[] dx = {-1, 1, 0, 0};
   static int[] dy = {0, 0, -1, 1};
   
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       StringTokenizer st = new StringTokenizer(br.readLine());
       
       n = Integer.parseInt(st.nextToken());
       l = Integer.parseInt(st.nextToken());
       r = Integer.parseInt(st.nextToken());
       
       map = new int[n][n];
       for (int i = 0; i < n; i++) {
           st = new StringTokenizer(br.readLine());
           for (int j = 0; j < n; j++) {
               map[i][j] = Integer.parseInt(st.nextToken());
           }
       }
       
       int days = 0;
       while (true) {
           visited = new boolean[n][n];
           boolean moved = false;
           
           for (int i = 0; i < n; i++) {
               for (int j = 0; j < n; j++) {
                   if (!visited[i][j]) {
                       if (bfs(i, j)) {
                           moved = true;
                       }
                   }
               }
           }
           
           if (!moved) break;
           days++;
       }
       
       System.out.println(days);
   }
   
   static boolean bfs(int x, int y) {
       Queue<int[]> queue = new ArrayDeque<>();
       List<int[]> union = new ArrayList<>();
       
       queue.offer(new int[]{x, y});
       union.add(new int[]{x, y});
       visited[x][y] = true;
       
       int sum = map[x][y];
       
       while (!queue.isEmpty()) {
           int[] cur = queue.poll();
           
           for (int i = 0; i < 4; i++) {
               int nx = cur[0] + dx[i];
               int ny = cur[1] + dy[i];
               
               if (nx >= 0 && nx < n && ny >= 0 && ny < n && !visited[nx][ny]) {
                   int diff = Math.abs(map[cur[0]][cur[1]] - map[nx][ny]);
                   if (diff >= l && diff <= r) {
                       visited[nx][ny] = true;
                       queue.offer(new int[]{nx, ny});
                       union.add(new int[]{nx, ny});
                       sum += map[nx][ny];
                   }
               }
           }
       }
       
       if (union.size() == 1) return false;
       
       int avg = sum / union.size();
       for (int[] pos : union) {
           map[pos[0]][pos[1]] = avg;
       }
       
       return true;
   }
}