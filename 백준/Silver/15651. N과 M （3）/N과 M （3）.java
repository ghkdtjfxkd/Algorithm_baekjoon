import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int m;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs(1, m, "");
        bw.flush();
    }

    static void dfs(int idx, int blank, String seq) throws IOException {
        if(blank == 0) {
            bw.write(seq.substring(1));
            bw.write("\n");
            return;
        }

        for (int i = 1; i <= n; i++) {
            dfs(idx, blank - 1, seq + " " + i);
        }
    }
}
