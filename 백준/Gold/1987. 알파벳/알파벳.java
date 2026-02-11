import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int R, C;

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};

    static boolean[] used = new boolean[26];
    static char[][] filed;
    static int mx = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        filed = new char[R][C];

        for (int i = 0; i < R; i++) {
            String line = br.readLine();
            for (int j = 0; j < C; j++) {
                filed[i][j] = line.charAt(j);
            }
        }

        dfs(0, 0, 1);
        System.out.println(mx);
    }

    static void dfs(int r, int c, int move) {
        mx = Math.max(mx, move);
        used[filed[r][c] - 'A'] = true;

        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if(nr < 0 || nc < 0 || nr >= R || nc >= C) continue;
            if(!used[filed[nr][nc] - 'A']) dfs(nr, nc, move +1);
        }

        used[filed[r][c] - 'A'] = false;
    }
}
