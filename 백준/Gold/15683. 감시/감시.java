import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class CCTV {
        int type;
        int row;
        int col;

        CCTV(int type, int row, int col) {
            this.type = type;
            this.row = row;
            this.col = col;
        }
    }

    static int[][][] sight = {
            {},
            {{0}, {1}, {2}, {3}},
            {{0, 2}, {1, 3}},
            {{0, 1}, {1, 2}, {2, 3}, {3, 0}},
            {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}},
            {{0, 1, 2, 3}}
    };

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    static int n, m, cctvCounts = 0;
    static int count = Integer.MAX_VALUE;

    static List<CCTV> cctvs = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        int[][] field = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int tile = Integer.parseInt(st.nextToken());

                if (tile >= 1 && tile <= 5) {
                    cctvs.add(new CCTV(tile, i, j));
                    cctvCounts++;
                }
                field[i][j] = tile;
            }
        }

        dfs(0, field);
        System.out.println(count);
    }

    static void dfs(int index, int[][] map) {
        if(index == cctvCounts) {
            count = Math.min(count, countZero(map));
            return;
        }

        CCTV cur = cctvs.get(index);

        for (int[] dirs : sight[cur.type]) {
            int[][] copy = copyMap(map);
            for (int dir : dirs) {
                watch(copy, cur.row, cur.col, dir);
            }
            dfs(index + 1, copy);
        }
    }

    static int[][] copyMap(int[][] origin) {
        int[][] copy = new int[n][m];
        for (int i = 0; i < n; i++) {
            System.arraycopy(origin[i], 0, copy[i], 0, m);
        }
        return copy;
    }

    static void watch(int[][] map, int r, int c, int dir) {
        int nr = r + dx[dir];
        int nc = c + dy[dir];
        while (!outOfField(nr, nc) && map[nr][nc] != 6) {
            if (map[nr][nc] == 0) map[nr][nc] = -1;
            nr += dx[dir];
            nc += dy[dir];
        }
    }

    static int countZero(int[][] map) {
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 0) count++;
            }
        }
        return count;
    }

    private static boolean outOfField(int r, int c) {
        return r < 0 || c < 0 || r >= n || c >= m;
    }
}
