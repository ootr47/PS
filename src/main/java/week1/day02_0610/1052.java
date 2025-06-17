package week1.day02_0610;

import java.io.IOException;
import java.util.Scanner;

class Main {
    public static void main(String[] args) throws IOException {
        // 코드 작성
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        for(int j=0; j<k; j++){
            for(int i=1; i<=20000000; i*=2) {
                if(i >= n){
                    if(j==k-1) System.out.println(i-n);
                    else n = n - i/2;
                    break;
                }
            }
        }
        
    }
}