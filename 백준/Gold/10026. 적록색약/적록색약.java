import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        char[][] img = new char[n][n];
        boolean[][] visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                img[i][j] = s.charAt(j);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j]) continue;
                dfs(i, j, img, visited);
                count++;
            }
        }

        String ans = count + " ";
        count = 0;
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(img[i][j] == 'R') {
                    img[i][j] = 'G';
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(visited[i][j]) continue;
                dfs(i, j, img, visited);
                count++;
            }
        }

        System.out.println(ans + count);
    }

    private static void dfs(int r, int c, char[][] img, boolean[][] visited) {
        if(visited[r][c]) return;
        visited[r][c] = true;
        char ch = img[r][c];

        for(int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if(nr < 0 || nc < 0 || nr >= img.length || nc >= img.length) continue;

            if(!visited[nr][nc] && img[nr][nc] == ch) {
                dfs(nr, nc, img,  visited);
            }
        }
    }
}
