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
    static int[][] maze;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        maze = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = s.charAt(j) - '0';
            }
        }
        bfs();
        System.out.println(maze[n-1][m-1]);
    }

    static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int pre = maze[r][c];

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if (nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if (!visited[nr][nc] && maze[nr][nc] != 0) {
                    q.offer(new int[]{nr, nc});
                    visited[nr][nc] = true;
                    maze[nr][nc] = pre + 1;
                }
            }
        }
    }
}
