import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static Integer[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp =  new Integer[n + 1];
        System.out.println(piv(n));
    }
    static int piv(int n) {
        if(dp[n] == null){
            if(n == 0){
                dp[n] = 0;
            } else if (  n == 1) {
                dp[n] = 1;
            } else {
                dp[n] = piv(n-1) + piv(n - 2);
            }
        }
        return dp[n];
    }
}