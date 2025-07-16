package week6.day37;
import java.io.IOException;
import java.util.Scanner;

class Main {

    static int n;
    static int k;
    static int[] arr;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        k = sc.nextInt();
        arr = new int[n];

        int[] dp = new int[k+1];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        dp[0] = 1;

       
        for (int coin : arr) {
            for (int j = coin; j <= k; j++) {
                dp[j] += dp[j - coin];
            }
        }
    

        System.out.println(dp[k]);

    }
}