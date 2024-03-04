import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String input[] = br.readLine().split(" ");

        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        System.out.println(factorial(n , k) / factorial(k , k));
    }

    static int factorial (int n, int k) {
        if(k == 0){
            return 1;
        } else {
            return n * factorial(n- 1 , k-1);
        }
    }
}