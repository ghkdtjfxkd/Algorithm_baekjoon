import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int fibCount = 0;
    public static void main(String[] args) throws IOException {
       int n = Integer.parseInt(br.readLine());
       fib(n);
       System.out.println(fibCount + " " + (n  - 2));
    }

    static int fib (int n) {
        if(n == 1 || n ==2){
            fibCount++;
            return 1;
        } else {
            return fib(n-1) + fib(n -2);
        }
    }
}