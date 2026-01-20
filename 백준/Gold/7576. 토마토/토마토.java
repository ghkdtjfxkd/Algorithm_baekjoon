import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int n = 0;
    static int m = 0;

    static int[][] field;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        field = new int[n][m];
        visited = new boolean[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(field[i][j] == 1) {
                    q.offer(new int[]{i, j, 0});
                    visited[i][j] = true;
                }
            }
        }

        int day = 0;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            day = cur[2];

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (!visited[nr][nc] && field[nr][nc] == 0) {
                    visited[nr][nc] = true;
                    field[nr][nc] = 1;
                    q.offer(new int[]{nr, nc, day + 1});
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(field[i][j] == 0) {
                    day = -1;
                    break;
                }
            }
        }
        System.out.println(day);
    }
}
