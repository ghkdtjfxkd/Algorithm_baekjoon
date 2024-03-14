import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        int number = 2;

        while (n > 1){
            if(n % number == 0){
                n /= number;
                System.out.println(number);
                continue;
            }
            number++;
        }
    }
}