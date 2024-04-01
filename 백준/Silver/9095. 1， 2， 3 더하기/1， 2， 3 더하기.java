import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            dp = new Integer[n+1];
            sb.append(recur(n)).append("\n");
        }
        System.out.println(sb);
    }

    private static int recur(int n){
        if(dp[n] == null){
            if(n == 1){
                dp[n] = 1;
            } else if(n ==2){
                dp[n] = 2;
            } else if(n == 3){
                dp[n] = 4;
            } else {
                dp[n] = recur(n-1) + recur(n-2) + recur(n-3);
            }
        }
        return dp[n];
    }
}