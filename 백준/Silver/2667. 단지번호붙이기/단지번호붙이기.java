
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int n;
    private static int[][] townMap;
    private static boolean[][] visited;
    private static int complexCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        townMap = new int[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String[] row = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                townMap[i][j] = Integer.parseInt(row[j]);
            }
        }

        List<Integer> complexList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && townMap[i][j] != 0) {

                    complexCount = 0;
                    solve(i, j);
                    complexList.add(complexCount);
                }
            }
        }
        complexList.sort(Integer::compareTo);
        StringBuilder sb = new StringBuilder();
        sb.append(complexList.size()).append(System.lineSeparator());
        for (int i = 0; i < complexList.size()-1; i++) {
            sb.append(complexList.get(i)).append(System.lineSeparator());
        }
        sb.append(complexList.get(complexList.size()-1));
        System.out.println(sb);;
    }

    private static void solve(int x, int y) {
        if (x < 0 || y < 0 || x >= n || y >= n) {
            return;
        } else {
            if (!visited[x][y]) {
                visited[x][y] = true;
                if (townMap[x][y] != 0) {

                    complexCount++;
                    solve(x - 1, y);
                    solve(x + 1,y);
                    solve(x, y - 1);
                    solve(x, y + 1);
                }
            }

        }
    }
}
