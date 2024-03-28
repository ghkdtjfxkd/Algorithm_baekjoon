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

        // 0 부터 n -1 까지 모든 부분수열을 탐색
        for (int i = 0; i < n; i++) {
            recur_topDown(i);
        }

        // 가장 긴 부분 수열의 값을 일단 dp 맨 앞값으로 설정해준다.
        int max = dp[0];

        // 모든 dp를 돌며 큰 값을 골라낸다.
        for (int i = 1; i < n; i++) {
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }

    private static int recur_topDown (int n){
        if(dp[n] == null){

            // 모든 길이는 최소 1이상이기 때문에 일단 모든 dp를 1로 초기화 시켜준다.
            dp[n] = 1;

            // n 번째 원소를 보고자 하면
            // n - 1 번부터 0번까지 검사한다
            for (int i = n -1; i >= 0 ; i--) {

                // n 번째 원소보다 작은, n -1 ~ 0 번째 원소 i 가 존재한다면
                // n 번째 원소가 지니는 dp 값과
                // i 번째 원소가 지닌 값 + 1 (i는 n 보다 작으니까 n이 추가되고 따라서 +1)
                // 두 값 중 더 큰 값을 dp 값으로 지정해준다.
                if(seq[i] < seq[n]){
                    dp[n] = Math.max(dp[n], recur_topDown(i)+ 1);
                }
            }
        }
        return dp[n];
    }
}