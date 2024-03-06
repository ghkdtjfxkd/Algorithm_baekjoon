import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int n;
    private static int m;

    private static int[][] maze;
    static boolean[][] visitedArr;
    private static final int WALL = 0;

    static int[] dRow = {-1, 1, 0, 0};
    static int[] dCol = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        String[] input = br.readLine().split(" ");

        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        maze = new int[n][m];
        visitedArr = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String[] mazeLine = br.readLine().split("");
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(mazeLine[j]);
            }
        }

        visitedArr[0][0] = true;
        bfs(0, 0);
        System.out.println(maze[n - 1][m - 1]);

    }

    static boolean inMaze(int row, int col) {
        if (row < 0 || col < 0 || row >= n || col >= m) {
            return false;
        }
        return true;
    }

    static boolean correctDirection(int row, int col) {
        if (maze[row][col] == WALL || visitedArr[row][col]) {
            return false;
        }
        return true;
    }

    static boolean possibleToMove(int row, int col) {
        if (!inMaze(row, col)) {
            return false;
        } else if (!correctDirection(row, col)) {
            return false;
        } else {
            return true;
        }
    }

    static void bfs(int row, int col) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});

        while (!queue.isEmpty()) {
            int now[] = queue.poll();

            int nowRow = now[0];
            int nowCol = now[1];

            for (int i = 0; i < 4; i++) {
                int nextRow = nowRow + dRow[i];
                int nextCol = nowCol + dCol[i];

                if (!possibleToMove(nextRow, nextCol)) {
                    continue;
                }

                queue.add(new int[]{nextRow, nextCol});
                maze[nextRow][nextCol] = maze[nowRow][nowCol] + 1;
                visitedArr[nextRow][nextCol] = true;
            }
        }
    }
}