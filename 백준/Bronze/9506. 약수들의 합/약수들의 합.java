import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        while (true) {
            StringBuilder sb = new StringBuilder();
            int n = Integer.parseInt(br.readLine());
            if (n == -1) {
                break;
            }
            
            List<Integer> factors = new ArrayList<>();
            for (int i = 1; i < n; i++) {
                if(n % i == 0){
                    factors.add(i);
                }
            }
            if(n == factors.stream().mapToInt(num -> num).sum()){
                sb.append(n).append(" = ");
                for (int i = 0; i <  factors.size()-1 ; i++) {
                    sb.append(factors.get(i)).append(" + ");
                }
                sb.append(factors.get(factors.size()-1));
                System.out.println(sb);
            } else {
                System.out.println(n + " is NOT perfect.");
            }
        }
    }
}