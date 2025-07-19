import java.io.IOException;
import java.util.Scanner;

class Main {

    public static StringBuilder sb = new StringBuilder();
    public static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.close();

        recursive(N, 1, 2, 3);

        System.out.println(count);
        System.out.println(sb.toString());
    }

    public static void recursive(int N, int start, int mid, int to) {
        count++;

        if (N == 1) {
            sb.append(start).append(" ").append(to).append("\n");
            return;
        }

        recursive(N - 1, start, to, mid);
        sb.append(start).append(" ").append(to).append("\n");
        recursive(N - 1, mid, start, to);
    }
}