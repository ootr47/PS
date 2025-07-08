import java.util.*;
import java.io.IOException;
import java.util.Scanner;

class Main {

    static int n;
    static int c;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        c = sc.nextInt();

        int max = 0;
        arr = new int[n];

        for(int i=0; i<n; i++) {
            arr[i] = sc.nextInt();
            if(arr[i] > max) max = arr[i];
        }
        Arrays.sort(arr);

        int start  = 1;
        int end = max;

        while(start < end) {
            int mid = (start + end + 1) / 2;
            if(isPossible(mid)) {
                start = mid;
            }
            else {
                end = mid-1;
            }
        }
        System.out.println(start);
    }

    private static boolean isPossible(int dist) {
        int count = 1;
        int start = arr[0];

        for(int i=1; i<n; i++) {
            if(arr[i] >= start + dist) {
                count++;
                start = arr[i];
            }
            if(count == c) return true;
        }
        return false;
    }
}