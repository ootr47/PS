package week2.day13_0621;

import java.util.*;

class Solution {

    int[][] arr;
    boolean[][] visited;

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        arr = new int[102][102];
        visited = new boolean[102][102];

        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int i = x1; i <= x2; i++)
                for (int j = y1; j <= y2; j++)
                    arr[i][j] = 2;
        }
        
        for (int[] rect : rectangle) {
            int x1 = rect[0] * 2;
            int y1 = rect[1] * 2;
            int x2 = rect[2] * 2;
            int y2 = rect[3] * 2;

            for (int i = x1 + 1; i < x2; i++)
                for (int j = y1 + 1; j < y2; j++)
                    arr[i][j] = 0;
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{characterX * 2, characterY * 2, 0});
        visited[characterX * 2][characterY * 2] = true;

        int targetX = itemX * 2;
        int targetY = itemY * 2;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];

            if (x == targetX && y == targetY) return dist / 2;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx > 100 || ny > 100) continue;
                if (visited[nx][ny] || arr[nx][ny] == 0) continue;

                visited[nx][ny] = true;
                queue.offer(new int[]{nx, ny, dist + 1});
            }
        }
        
        return -1; 
    }
}