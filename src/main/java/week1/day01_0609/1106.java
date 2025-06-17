package week1.day01_0609;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {

    static int c;
    static int n;
    static int [] dp;

    public static void main(String[] args) throws IOException {
        // 코드 작성
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        c = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        dp= new int [c+2001];
        Arrays.fill(dp, (c + 100) * 100);
        dp[0]=0;
 
        for(int i=0; i<n; i++){
            input = br.readLine().split(" ");
            int cost = Integer.parseInt(input[0]);
            int customer = Integer.parseInt(input[1]);

            for(int j=customer; j<c+2001; j++){
                dp[j]=Math.min(dp[j],cost+dp[j-customer]);
            }
        }
        int result=Integer.MAX_VALUE;
        for(int i=c; i<c+101; i++){
            result=Math.min(result,dp[i]);
        }
        System.out.println(result);
    }
}