package week4.day27_0705;
import java.io.IOException;
import java.util.Scanner;

class Main {

    static int n;
    static int m;
    static int[][] arr;

    static int max = 0;

    public static void main(String[] args) throws IOException {
        // 코드 작성

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        solution();
        System.out.println(max);
    }

    private static void solution() {
        for(int k=0; k<4; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j< m; j++) {
                    tetromino1(i, j);
                    tetromino2(i, j);
                    tetromino3(i, j);
                    tetromino4(i, j);
                    tetromino5(i, j);
                }
            }
            rotate();
        }
    }

    private static void rotate() {
        int[][] rotatedArr = new int[m][n];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                rotatedArr[j][n-i-1] = arr[i][j];
            }
        }
        int temp = n;
        n = m;
        m = temp;
        arr = rotatedArr;
    }

    private static int tetromino1(int y, int x) {
        int sum = 0;
        for(int i=y; i<y+4; i++) {
            if(!isPossible(i, x)) return 0;
            sum += arr[i][x];
        }
        max = Math.max(max, sum);
        return sum;
    }

    private static int tetromino2(int y, int x) {
        int sum = 0;
        for(int i=y; i<y+2; i++) {
            for(int j=x; j<x+2; j++) {
                if(!isPossible(i, j)) return 0;
                sum += arr[i][j];
            }
        }
        max = Math.max(max, sum);
        return sum;
    }

    private static int tetromino3(int y, int x) {
        int sum = 0;
        for(int i=y; i<y+3; i++) {
            if(!isPossible(i, x)) return 0;
            sum += arr[i][x];
        }
        if(isPossible(y+2, x-1)) {
            max = Math.max(max, sum + arr[y+2][x-1]);
        }
        if(isPossible(y+2, x+1)) {
            max = Math.max(max, sum + arr[y+2][x+1]);
        }
        return sum;
    }

    private static int tetromino4(int y, int x) {
        int sum = 0;
        loop1: for(int i=y; i<y+2; i++) {
            for(int j=x; j<x+2; j++) {
                if(!isPossible(i, j+1)) break loop1;
                if(i==y+1) {
                    sum += arr[i][j+1];
                }
                else {
                    sum += arr[i][j];
                }
            }
        }

        max = Math.max(max, sum);
        sum = 0;

        loop2: for(int i=y; i<y+2; i++) {
            for(int j=x; j<x+2; j++) {
                if(i==y+1) {
                    if(!isPossible(i, j-1)) break loop2;
                    sum += arr[i][j-1];
                }
                else {
                    if(!isPossible(i, j)) break loop2;
                    sum += arr[i][j];
                }
            }
        }

        max = Math.max(max, sum);
        return sum;
    }

    private static int tetromino5(int y, int x) {
        int sum = 0;
        for(int i=y; i<y+3; i++) {
            if(!isPossible(i, x)) return 0;
            sum += arr[i][x];
        }
        if(isPossible(y+1, x-1)) {
            max = Math.max(max, sum + arr[y+1][x-1]);
        }
        if(isPossible(y+1, x+1)) {
            max = Math.max(max, sum + arr[y+1][x+1]);
        }    
        return sum;
    }

    private static boolean isPossible(int y, int x) {
        if(y < 0 || x < 0 || y >= n || x >= m) return false;
        return true;
    }
}