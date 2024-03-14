import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        while (true){
            st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if(n == 0 && m == 0){
                break;
            }

            if(n / m != 0 && n % m ==0){
                System.out.println("multiple");
            } else if(m / n != 0 && m % n==0){
                System.out.println("factor");
            } else {
                System.out.println("neither");
            }
        }
    }
}