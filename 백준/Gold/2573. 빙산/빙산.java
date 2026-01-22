import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] ib;
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        ib = new int[h][w];

        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                ib[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;

        while (true) {
            visited = new boolean[h][w];
            int count = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && ib[i][j] > 0) {
                        dfs(i, j);
                        count++;
                    }
                }
            }

            if(count >= 2) {
                System.out.println(time);
                break;
            }

            if(count == 0) {
                System.out.println(0);
                break;
            }

            updateMelt();
            time++;
        }
    }

    static void dfs(int row, int col) {
        if (row < 0 || col < 0 || row >= ib.length || col >= ib[0].length) {
            return;
        }
        if (visited[row][col] || ib[row][col] == 0) {
            return;
        }
        visited[row][col] = true;

        for (int i = 0; i < 4; i++) {
            int nr = row + dx[i];
            int nc = col + dy[i];

            dfs(nr, nc);
        }
    }

    static void updateMelt() {
        int[][] melt = new int[ib.length][ib[0].length];

        for (int i = 0; i < ib.length - 1; i++) {
            for (int j = 0; j < ib[0].length - 1; j++) {
                if (ib[i][j] == 0) continue;

                int meltCount = 0;

                for (int k = 0; k < 4; k++) {
                    int nr = i + dx[k];
                    int nc = j + dy[k];
                    if (nr < 0 || nc < 0 || nr >= ib.length || nc >= ib[0].length) continue;
                    if (ib[nr][nc] == 0) meltCount++;
                }
                melt[i][j] =  Math.max(0, ib[i][j] - meltCount);
            }
        }
        ib = melt;
    }
}



