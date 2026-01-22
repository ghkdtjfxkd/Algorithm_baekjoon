import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int land;
    static Queue<int[]> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        visited = new boolean[n][n];
        q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        land = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] != 0) {
                    dfs(i, j, land);
                    land++;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        for (int k = 0; k < land; k++) {
            visited = new boolean[n][n];
            int landN = k +1;

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!visited[i][j] && map[i][j] == landN) {
                        q.offer(new int[] {landN, i, j, 0});
                        visited[i][j] = true;
                    }
                }
            }

            int bridge = Integer.MAX_VALUE;
            while(!q.isEmpty()) {
                int[] cur = q.poll();
                int l = cur[0];
                int r = cur[1];
                int c = cur[2];
                int len = cur[3];

                if(l != landN && l != 0) {
                    bridge = Math.min(bridge, len - 1);
                }

                for (int i = 0; i < 4; i++) {
                    int nr = r + dx[i];
                    int nc = c + dy[i];

                    if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                    if(!visited[nr][nc] && map[nr][nc] != landN) {
                        visited[nr][nc] = true;
                        q.offer(new int[] {map[nr][nc], nr, nc, len + 1});
                    }
                }
            }
            min = Math.min(min, bridge);
        }
        System.out.println(min);
    }

    static void dfs(int r, int c, int land) {
        visited[r][c] = true;
        map[r][c] = land;

        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;

            if(!visited[nr][nc] && map[nr][nc] != 0) dfs(nr, nc, land);
        }
    }
}
