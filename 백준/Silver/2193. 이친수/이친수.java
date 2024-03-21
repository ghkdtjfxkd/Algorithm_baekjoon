import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static Long[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        dp = new Long[(int) (n + 1)];
        System.out.println(recur(n));
    }
    private static long recur (long n) {
        if(dp[(int) n] == null) {
            if(n == 1){
                dp[(int) n] = 1L;
            } else if (n == 2){
                dp[(int) n] = 1L;
            } else {
                dp[(int) n] = recur(n - 1) + recur(n -2);
            }
        }
        return dp[(int) n];
    }
}