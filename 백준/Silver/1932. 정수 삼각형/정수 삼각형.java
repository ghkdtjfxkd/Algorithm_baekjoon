import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] tri;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        tri = new int[n][];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int[] triLine = new int[i + 1];
            for (int j = 0; j < i + 1; j++) triLine[j] = Integer.parseInt(st.nextToken());
            tri[i] = triLine;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                tri[i][j] += Math.max(tri[i + 1][j], tri[i + 1][j + 1]);
            }
        }
        
        System.out.println(tri[0][0]);
    }
}
