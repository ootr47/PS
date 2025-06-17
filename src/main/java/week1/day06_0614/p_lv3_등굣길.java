package week1.day06_0614;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int[][] arr = new int[m+1][n+1];

        for(int i=0; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                arr[i][j] = 1;
            }
        }

        for(int i=0; i<=m; i++) arr[i][0] = 0;
        for(int i=0; i<=n; i++) arr[0][i] = 0;

        for(int[] temp: puddles){
            if(temp.length < 1) break;
            arr[temp[0]][temp[1]] = 0;
        }


        for(int i=0; i<=m; i++) {
            for(int j=0; j<=n; j++) {
                if(i*j==1 || arr[i][j]==0) continue;
                arr[i][j] = (arr[i-1][j] + arr[i][j-1]) % 1000000007;
            }
        }
        
        

        return arr[m][n];
    }
}