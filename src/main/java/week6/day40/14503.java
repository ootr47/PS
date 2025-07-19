package week6.day40;
import java.io.*;
import java.util.*;

class Main {

    static int N, M;
    static int[][] room;
    static int ans = 0;

    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        room = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve(r, c, dir);

        System.out.println(ans);
    }

    public static void solve(int r, int c, int dir) {
        if (room[r][c] == 0) {
            room[r][c] = 2;
            ans++;
        }

        boolean moved = false;
        int originalDir = dir;

        for (int i = 0; i < 4; i++) {
            dir = (dir + 3) % 4;

            int nextR = r + dr[dir];
            int nextC = c + dc[dir];

            if (nextR >= 0 && nextR < N && nextC >= 0 && nextC < M && room[nextR][nextC] == 0) {
                solve(nextR, nextC, dir);
                moved = true;
                break;
            }
        }

        if (!moved) {
            int backDir = (originalDir + 2) % 4;
            int backR = r + dr[backDir];
            int backC = c + dc[backDir];

            if (backR >= 0 && backR < N && backC >= 0 && backC < M && room[backR][backC] != 1) {
                solve(backR, backC, originalDir);
            } else {
                return;
            }
        }
    }
}