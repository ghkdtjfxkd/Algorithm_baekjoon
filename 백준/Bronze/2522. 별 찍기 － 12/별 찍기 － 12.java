import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                sb.append(" ");
            }
            for (int j = n - i - 1; j < n; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < i + 1; j++) {
                sb.append(" ");
            }
            for (int j = i + 1; j < n; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}