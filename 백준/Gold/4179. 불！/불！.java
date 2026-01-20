import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static int n = 0;
    static int m = 0;

    static char[][] maze;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new char[n][m];

        int[][] fTime = new int[n][m];

        boolean[][] jvisited = new boolean[n][m];

        Queue<int[]> fq = new LinkedList<>();
        Queue<int[]> jq = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                maze[i][j] = c;
                fTime[i][j] = -1;
                if(c == 'F') {
                    fq.offer(new int[] {i,j});
                    fTime[i][j] = 0;
                }
                if (c == 'J') {
                    jq.offer(new int[]{i, j, 0});
                    jvisited[i][j] = true;
                }
            }
        }

        while(!fq.isEmpty()) {
            int[] cur = fq.poll();
            int r = cur[0];
            int c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if(maze[nr][nc] != '#' && fTime[nr][nc] == -1) {
                    fTime[nr][nc] = fTime[r][c] + 1;
                    fq.offer(new int[]{nr, nc});
                }
            }
        }

        while (!jq.isEmpty()) {
            int[] cur = jq.poll();
            int r = cur[0];
            int c = cur[1];
            int t = cur[2];

            if (r == 0 || c == 0 || r == n - 1 || c == m - 1) {
                System.out.println(t + 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (jvisited[nr][nc] || maze[nr][nc] == '#') continue;

                if (fTime[nr][nc] == -1 || fTime[nr][nc] -1 > t) {
                    jvisited[nr][nc] = true;
                    jq.offer(new int[]{nr, nc, t + 1});
                }
            }
        }
        System.out.println("IMPOSSIBLE");
    }
}
