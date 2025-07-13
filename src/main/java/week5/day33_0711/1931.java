package week5.day33_0711;
import java.io.IOException;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] arr = new int[n][2];

        for(int i=0; i<n; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            arr[i][0] = s;
            arr[i][1] = e;
        }

        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] == o2[1]) return o1[0] - o2[0];
            return o1[1] - o2[1];
        });

        int index = 1;
        int time = arr[0][1];
        int count = 1;

        while(index < n) {
            if(arr[index][0] >= time) {
                time = arr[index][1];
                count++;
            }
            index++;
        }

        System.out.println(count);
    }
}