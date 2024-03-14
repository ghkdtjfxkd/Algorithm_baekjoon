import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Integer> factors = new ArrayList<>();

        for (int i = 1; i <= n ; i++) {
            if(n % i == 0){
                factors.add(n / i);
            }
        }
        if(factors.size()-k < 0){
            System.out.println(0);
        }else {
            System.out.println(factors.get(factors.size()-k));
        }
    }
}
