import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

class Main {

    static int n;
    static int m;
    static int k;

    static int result = 0;

    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        int[][] arr = new int[n][m];
        int[] countArr = new int[n];

        for(int i=0; i<n; i++) {
            String input = sc.next();

            for(int j=0; j<m; j++) {
                arr[i][j] = input.charAt(j) - '0';
            }
        }
        k = sc.nextInt();

        for(int i=0; i<n; i++) {
            int count = 0;
            for(int j=0; j<m; j++) {
                if(arr[i][j] == 0) {
                    count++;
                }
            }
            countArr[i] = count;
            count = 0;
        }

        test(arr, countArr, 0, 0);

        System.out.println(result);
    }

    private static void test(int[][] arr, int[] countArr, int switchedCount, int cur) {

        if(cur == m) {
            int sum = 0;
            for(int i=0; i<n; i++) {
                if(countArr[i] == 0) sum++;
            }
            
            if(switchedCount > k) return;  
            if(result < sum && (k-switchedCount) % 2 == 0) result = sum;
            return;
        }

        test(arr, countArr, switchedCount, cur+1);

        for(int i=0; i<n; i++) {
            if(arr[i][cur] == 0) countArr[i]--;
            else countArr[i]++;
        }
        
        test(arr, countArr, switchedCount+1, cur+1);
        
        for(int i=0; i<n; i++) {
            if(arr[i][cur] == 0) countArr[i]++;
            else countArr[i]--;
        }
    }
}