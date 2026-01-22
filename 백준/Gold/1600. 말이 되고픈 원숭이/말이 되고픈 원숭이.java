import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int[] dr = {1, 1, 2, 2, -1, -1, -2, -2};
    static int[] dc = {2, -2, 1, -1, -2, 2, 1, -1};

    static int w;
    static int h;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        int[][] field = new int[h][w];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][][] visited = new boolean[h][w][k + 1];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0, k, 0});
        visited[0][0][k] = true;

        int time = 0;
        boolean possible = false;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int left = cur[2];
            int t = cur[3];

            if (r == h - 1 && c == w - 1) {
                possible = true;
                time = t;
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                if (nr < 0 || nc < 0 || nr >= h || nc >= w) {
                    continue;
                }
                if (!visited[nr][nc][left] && field[nr][nc] == 0) {
                    visited[nr][nc][left] = true;
                    q.offer(new int[]{nr, nc, left, t + 1});
                }
            }
            if (left > 0) {
                for (int i = 0; i < 8; i++) {
                    int nr = r + dr[i];
                    int nc = c + dc[i];

                    if (nr < 0 || nc < 0 || nr >= h || nc >= w) {
                        continue;
                    }
                    if (!visited[nr][nc][left - 1] && field[nr][nc] == 0) {
                        visited[nr][nc][left- 1] = true;
                        q.offer(new int[]{nr, nc, left - 1, t + 1});
                    }
                }
            }
        }

        if (possible) {
            System.out.println(time);
        } else {
            System.out.println(-1);
        }
    }
}
