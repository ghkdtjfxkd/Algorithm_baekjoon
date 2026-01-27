import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[] arr;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[m];
        visited = new boolean[n + 1];

        if(m == 1) {
            for (int i = 0; i < n; i++) {
                System.out.println(i + 1);
            }
            return;
        }

        back(0);
        System.out.println(sb);
    }

    static void back(int dep) {
        if(dep == m) {
            for (int i = 0; i < m; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            if(!visited[i]) {
                visited[i] = true;
                arr[dep] = i;
                back(dep + 1);
                visited[i] = false;
            }
        }
    }
}
