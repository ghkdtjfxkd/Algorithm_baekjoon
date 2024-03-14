import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        for (int i = m; i <= n; i++) {

            int count = 1;
            for (int j = 2; j <= i; j++) {
                if(i % j == 0){
                    count++;
                }
            }if(count > 2){
               continue;
            }
            if(i != 1){
                set.add(i);
            }
        }

        if(set.isEmpty()){
            System.out.println(-1);
        }else{
            System.out.println(set.stream().mapToInt(nu->nu).sum());
            System.out.println(set.stream().mapToInt(nu->nu).min().getAsInt());
        }
    }
}