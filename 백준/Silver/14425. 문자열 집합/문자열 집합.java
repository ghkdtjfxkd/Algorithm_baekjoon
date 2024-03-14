import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int n;
    private static int m;

    private static HashSet<String> strs = new HashSet<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = 0;
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            strs.add(br.readLine());
        }

        for (int i = 0; i < m; i++) {
            if(strs.contains(br.readLine())){
                count++;
            }
        }
        System.out.println(count);
    }
}