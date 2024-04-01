import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            dp = new Long[n+1];
            System.out.println(fibonacci(n));
        }
    }

    static long fibonacci (int n) {
        if(dp[n] == null) {
            if(n == 1){
                dp[n] = 1L;
            } else if(n == 2) {
                dp[n] = 1L;
            } else if(n == 3) {
                dp[n] = 1L;
            } else {
                dp[n] = fibonacci(n -3) + fibonacci(n -2);
            }
        }
        return dp[n];
    }
}