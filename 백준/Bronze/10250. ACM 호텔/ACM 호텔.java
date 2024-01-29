import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            String[] input = br.readLine().split(" ");

            int h = Integer.parseInt(input[0]);
            int w = Integer.parseInt(input[1]);
            int n = Integer.parseInt(input[2]);
            
            int count = 0;
            for (int j = 1; j <= w; j++) {
                for (int k = 1; k <= h; k++) {
                    count++;
                    if(count == n){
                        System.out.println(k * 100 + j);
                        break;
                    }
                }
            }
        }
    }
}