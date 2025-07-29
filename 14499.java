import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class Main {

    static int n;
    static int m;
    static int x;
    static int y;
    static int k;

    public static void main(String[] args) throws IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);
        x = Integer.parseInt(input[2]);
        y = Integer.parseInt(input[3]);
        k = Integer.parseInt(input[4]);

        int[][] map = new int [n][m];
        int[] cmd = new int[k];

        for(int i=0; i<n; i++) {
            input = br.readLine().split(" ");
            for(int j=0; j<m; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        input = br.readLine().split(" ");
        for(int i=0; i<k; i++) {
            cmd[i] = Integer.parseInt(input[i]);
        }

        // 1 : 동, 2: 서, 3: 북, 4: 남
        

    }
}