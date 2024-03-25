import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
    private static int[][] table;
    private static int[][] xTable;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        table = new int[n][n];
        xTable= new int[n+1][n+1];

        for (int i = 0; i <n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                table[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n +1; i++) {
            for (int j = 1; j < n +1; j++) {
                xTable[i][j] = table[i-1][j-1] + xTable[i][j-1];
            }
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int sum = 0;
            for (int j = 0; j < x2 - x1 + 1; j++) {
               sum += xTable[x1+j][y2] -xTable[x1+j][y1-1];
            }
            sb.append(sum).append("\n");
        }
        System.out.println(sb);
    }
}