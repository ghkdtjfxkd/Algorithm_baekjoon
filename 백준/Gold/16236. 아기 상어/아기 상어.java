import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int n;
    static int minTime = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[][] sea = new int[n][n];

        int initR = 0, initC = 0;
        int sharkSize = 2;
        int toEvolve = 2;

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int block = Integer.parseInt(st.nextToken());
                sea[i][j] = block;

                if(block == 9) {
                    initR = i;
                    initC = j;
                    sea[i][j] = 0;
                }
            }
        }

        dfs(initR, initC, sharkSize, toEvolve, sea, 0);
        System.out.println(minTime);
    }


    static void dfs(int row, int col, int sharkSize, int toEvolve, int[][] sea, int time) {
        int[] target = nextTarget(row, col, sharkSize, sea);

        if(target == null) {
            minTime = time;
            return;
        }

        int nr = target[0];
        int nc = target[1];
        int dist = target[2];

        sea[nr][nc] = 0;

        if(toEvolve == 1) {
            dfs(nr, nc, sharkSize + 1, sharkSize + 1, sea, time + dist);
        } else {
            dfs(nr, nc, sharkSize, toEvolve -1, sea, time + dist);
        }
    }


    static int[] nextTarget(int row, int col, int sharkSize, int[][] sea) {
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> q = new PriorityQueue<>((a, b) -> {
            if(a[2] != b[2]) return Integer.compare(a[2], b[2]);
            if(a[0] != b[0]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });

        q.offer(new int[] {row, col, 0});
        visited[row][col] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            int dist = cur[2];

            if(sea[r][c] != 0 && sea[r][c] < sharkSize) {
                return new int[] {r, c, dist};
            }

            for (int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];

                if(nr < 0 || nc < 0 || nr >= n || nc >= n) continue;
                if(visited[nr][nc] || sea[nr][nc] > sharkSize) continue;
                visited[nr][nc] = true;
                q.offer(new int[] {nr, nc, dist + 1});
            }
        }
        return null;
    }

}
