import java.io.IOException;
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

        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.next();
        }

        k = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = 0; j < m; j++) {
                if (arr[i].charAt(j) == '0') {
                    count++;
                }
            }

            if (count <= k && (k - count) % 2 == 0) {
                int sum = 0;
                for (int l = 0; l < n; l++) {
                    if (arr[i].equals(arr[l])) {
                        sum++;
                    }
                }
                if (result < sum) {
                    result = sum;
                }
            }
        }

        System.out.println(result);
    }
}