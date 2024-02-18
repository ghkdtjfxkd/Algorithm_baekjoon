import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split("");
        StringBuilder sb = new StringBuilder();
        for (String s : input) {
            if(s.matches("[a-z]")){
                sb.append(s.toUpperCase());
                continue;
            }
            if(s.matches("[A-Z]")){
                sb.append(s.toLowerCase());
            }
        }
        System.out.println(sb);
    }
}
