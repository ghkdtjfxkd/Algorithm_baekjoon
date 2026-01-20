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
    static int[] dz = {1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        int[][][] filed = new int[h][n][m];
        boolean[][][] visited = new boolean[h][n][m];

        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < m; k++) {
                    filed[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(filed[i][j][k] == 1) {
                        q.offer(new int[] {i , j, k, 0});
                        visited[i][j][k] = true;
                    }
                }
            }
        }

        int count = -1;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int d = cur[0];
            int r = cur[1];
            int c = cur[2];
            int day = cur[3];

            if(day > count) {
                count = day;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if(nr < 0 || nc < 0 || nr >= n  || nc >= m) continue;
                if(!visited[d][nr][nc] && filed[d][nr][nc] == 0) {
                    visited[d][nr][nc] = true;
                    filed[d][nr][nc] = 1;
                    q.offer(new int[]{d,nr,nc, day + 1});
                }
            }


            for (int i = 0; i < 3; i++) {
                int nd = d + dz[i];

                if(nd < 0 || nd >= h) continue;
                if(!visited[nd][r][c] && filed[nd][r][c] == 0) {
                    visited[nd][r][c] = true;
                    filed[nd][r][c] = 1;
                    q.offer(new int[]{nd,r,c, day + 1});
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if(filed[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(count);
    }
}

