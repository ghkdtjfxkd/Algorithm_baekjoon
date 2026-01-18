import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] mass = new int[n][2];
        int[] rank = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            mass[i][0] = Integer.parseInt(st.nextToken());
            mass[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(mass[i][0] > mass[j][0] && mass[i][1] > mass[j][1]) {
                    rank[j]++;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            bw.write(String.valueOf(rank[i] + 1));
            bw.write(" ");
        }
        bw.flush();
    }
}
