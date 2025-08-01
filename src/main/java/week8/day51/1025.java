import java.io.*;
import java.util.*;

class Main {
    static int N, M;
    static char[][] board;
    static int maxSquare = -1;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                for (int dr = -N; dr < N; dr++) {
                    for (int dc = -M; dc < M; dc++) {
                        if (dr == 0 && dc == 0) continue;
                        
                        int r = i, c = j;
                        StringBuilder sb = new StringBuilder();
                        
                        while (r >= 0 && r < N && c >= 0 && c < M) {
                            sb.append(board[r][c]);
                            
                            long num = Long.parseLong(sb.toString());
                            if (isPerfectSquare(num)) {
                                maxSquare = Math.max(maxSquare, (int)num);
                            }
                            
                            r += dr;
                            c += dc;
                        }
                    }
                }
            }
        }
        
        System.out.println(maxSquare);
    }
    
    static boolean isPerfectSquare(long n) {
        if (n < 0) return false;
        long sqrt = (long) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
}