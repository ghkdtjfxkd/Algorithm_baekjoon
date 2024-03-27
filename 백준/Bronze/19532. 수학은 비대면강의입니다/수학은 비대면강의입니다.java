import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());

        int ansX = 1000;
        int ansY = 1000;

        int x = -999;
        while (x < 1000) {

            int y = -999;
            while (y < 1000) {
                if((a * x + b * y) == c&& (d * x + e * y) == f){
                    ansX = x;
                    ansY = y;
                    break;
                } else {
                    y++;
                }
            }
            x++;
        }
        System.out.println(ansX + " "+ ansY);
    }
}