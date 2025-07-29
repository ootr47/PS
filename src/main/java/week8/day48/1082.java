import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

class Main {
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        String[] prices = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(prices[i]);
        }
        int M = Integer.parseInt(br.readLine());

        String[] dp = new String[M + 1];
        Arrays.fill(dp, null);
        dp[0] = "";

        for (int j = 1; j <= M; j++) {
            for (int i = 0; i < N; i++) {
                if (j >= P[i]) {
                    String prevDp = dp[j - P[i]];

                    if (prevDp == null) {
                        continue;
                    }

                    String currentNum = String.valueOf(i);
                    String newCandidate = prevDp + currentNum;

                    if (newCandidate.length() > 1 && newCandidate.charAt(0) == '0') {
                        continue;
                    }

                    if (dp[j] == null || compare(newCandidate, dp[j]) > 0) {
                        dp[j] = newCandidate;
                    }
                }
            }
        }

        String result = "0";

        for (int j = 0; j <= M; j++) {
            if (dp[j] != null && !dp[j].isEmpty()) {
                if (compare(dp[j], result) > 0) {
                    result = dp[j];
                }
            }
        }

        System.out.println(result);
    }

    private static int compare(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return s1.length() - s2.length();
        }
        return s1.compareTo(s2);
    }
}
