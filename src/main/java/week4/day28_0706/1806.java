package week4.day28_0706;
import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int s = sc.nextInt();
        int[] arr = new int[n];
        int start = 0;
        int ans = 100001;

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
        }

        int sum = 0;

        for(int i=0; i<n; i++) {
            sum += arr[i];
            while(sum-arr[start] >= s) {
                sum -= arr[start++];
            }
            if(sum >= s) {
                ans = Math.min(ans, i-start+1);
            } 
        }
        if(ans > 100000) ans = 0;
        System.out.println(ans);
    }
}