import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] seq;
    private static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        seq = new int[n];
        dp = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            recur(i);
        }

        int max = dp[0];

        for (int i = 1; i < n; i++) {
            max = Math.max(max , dp[i]);
        }

        System.out.println(max);
    }

    private static int recur(int n) {
        if (dp[n] == null) {
            dp[n] = 1;
            for (int i = n - 1; i >= 0; i--) {
                if (seq[n] < seq[i]) {
                    dp[n] = Math.max(dp[n], recur(i) + 1);
                }
            }
        }
        return dp[n];
    }
}