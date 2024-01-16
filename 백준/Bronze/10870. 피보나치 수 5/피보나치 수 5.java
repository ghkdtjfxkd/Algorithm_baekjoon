import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());


        fibonacci(count, 0 , 1);


    }

    static int fibonacci (int count, int now, int next) {
        if (count == 0){
            System.out.println(now);
            return 0;
        }
        else {
            return fibonacci(count-1, next, now + next);
        }
    }
}