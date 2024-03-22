import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static Integer[] dp;
    private static int[] stepScore;


    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        //계단은 n개 이지만 시작점이 있으니까 하나를 더해준다.
        stepScore = new int[n + 1];
        dp = new Integer[n + 1];

        for (int i = 1; i <= n; i++) {
            stepScore[i] = Integer.parseInt(br.readLine());
        }

        dp[0] = stepScore[0];
        dp[1] = stepScore[1];

        if (n >= 2) {
            dp[2] = stepScore[1] + stepScore[2];
        }

        System.out.println(recur(n));
    }

    private static int recur(int step) {
        if (dp[step] == null) {
            dp[step] = Math.max(
                    // --- recursion 시작 -----

                    // 바로 전 계단
                    // 한 칸 아래지만 index 값이므로 -1을 추가로 빼줘서 -2
                    recur(step - 2),
                    // 전전 계단
                    // 두 칸 아래지만 index 값이므로 -1을 추가로 빼줘서 -3
                    recur(step - 3) + stepScore[step - 1]

                    // --- recursion 끝 -----+
            ) + stepScore[step];
            // 마지막 계단은 무조건 밟는다는 조건이 있기 때문에 그냥 값을 더해준다.
        }
        return dp[step];
    }
}