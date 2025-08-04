package week8.day53;
import java.io.*;

class Main {
   static int N;
   static int count = 0;
   static int[] col;
   
   public static void main(String[] args) throws IOException {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       N = Integer.parseInt(br.readLine());
       col = new int[N];
       
       nQueens(0);
       System.out.println(count);
   }
   
   static void nQueens(int row) {
       if (row == N) {
           count++;
           return;
       }
       
       for (int i = 0; i < N; i++) {
           col[row] = i;
           if (isValid(row)) {
               nQueens(row + 1);
           }
       }
   }
   
   static boolean isValid(int row) {
       for (int i = 0; i < row; i++) {
           if (col[i] == col[row] || Math.abs(col[i] - col[row]) == Math.abs(i - row)) {
               return false;
           }
       }
       return true;
   }
}