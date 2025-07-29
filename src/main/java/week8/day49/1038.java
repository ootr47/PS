package week8.day49;
import java.io.*;
import java.util.*;

class Main {
    static List<Long> decreasingNumbers = new ArrayList<>();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        generateDecreasingNumbers();
        Collections.sort(decreasingNumbers);
        
        if (N >= decreasingNumbers.size()) {
            System.out.println(-1);
        } else {
            System.out.println(decreasingNumbers.get(N));
        }
    }
    
    static void generateDecreasingNumbers() {
        for (int i = 0; i <= 9; i++) {
            dfs(i);
        }
    }
    
    static void dfs(long num) {
        decreasingNumbers.add(num);
        int lastDigit = (int)(num % 10);
        for (int i = 0; i < lastDigit; i++) {
            dfs(num * 10 + i);
        }
    }
}