package week4.day25_0703;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Main {

    static String result = "";
    static int minSub;

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);

        int target = sc.nextInt();
        int n = sc.nextInt();
        int[] errorButton = new int[n];

        int[] buttons = new int[10 - n];
        for (int i = 0; i < n; i++) {
            errorButton[i] = sc.nextInt();
        }

        minSub = Math.abs(target - 100);

        if (n == 10) {
            System.out.println(minSub);
            return;
        }

        int t = 0;
        Arrays.sort(errorButton);
        for (int i = 0; i < 10; i++) {
            if (t < n && errorButton[t] == i) {
                t++;
                continue;
            }
            buttons[i - t] = i;
        }

        search(buttons, target, new StringBuilder(""));

        System.out.println(minSub);
    }

    private static void search(int[] buttons, int target, StringBuilder sb) {

        if (sb.length() > 0) {
            int currentChannel = Integer.parseInt(sb.toString());
            int pressCount = sb.length() + Math.abs(target - currentChannel);

            if (minSub > pressCount) {
                minSub = pressCount;
                result = sb.toString();
            }
        }
        
        if (sb.length() > 6) return;


        for (int i : buttons) {
            search(buttons, target, sb.append(i));
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}