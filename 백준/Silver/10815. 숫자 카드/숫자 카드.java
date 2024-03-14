import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n;
    private static HashSet<String> sangGeun = new HashSet<>();
    private static int m;

    public static void main(String[] args) throws IOException {
        StringBuilder sb= new StringBuilder();
        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            sangGeun.add(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
           if(sangGeun.contains(st.nextToken())) {
                sb.append(1).append(" ");
            }
            else {
                sb.append(0).append(" ");
            }
        }
        System.out.println(sb);
    }
}