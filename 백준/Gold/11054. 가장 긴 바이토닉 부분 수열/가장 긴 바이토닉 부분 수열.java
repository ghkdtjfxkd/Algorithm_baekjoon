import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int[] seq;
    private static Integer[] dp;
    private static Integer[] dpUp;
    private static Integer[] dpDown;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        seq = new int[n];
        dpUp = new Integer[n];
        dpDown = new Integer[n];
        dp = new Integer[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < n; i++) {
            recurMid(i);
        }
        int max = dp[0];
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }

    private static int recurMid(int n) {
        if (dp[n] == null) {
            dp[n] = 1 + recurL(n) + recurR(n, dp.length);
        }
        return dp[n];
    }

    private static int recurL(int n) {
        if (dpUp[n] == null) {
            dpUp[n] = 0;
            if (n == 0) {
                return 0;
            } else {
                for (int i = n - 1; i >= 0; i--) {
                    if (seq[i] < seq[n]) {
                        dpUp[n] = Math.max(dpUp[n], recurL(i) + 1);
                    }
                }
            }
        }
        return dpUp[n];
    }

    private static int recurR(int n, int end) {
        if (dpDown[n] == null) {
            dpDown[n] = 0;
            if (n == end) {
                return 0;
            } else {
                for (int i = n + 1; i < end; i++) {
                    if (seq[i] < seq[n]) {
                        dpDown[n] = Math.max(dpDown[n], recurR(i, end) + 1);
                    }
                }
            }
        }
        return dpDown[n];
    }
}