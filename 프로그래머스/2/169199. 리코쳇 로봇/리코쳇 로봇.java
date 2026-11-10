import java.util.*;
class Solution {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, -1, 0, 1};
    static char[][] maze;
    static int n;
    static int m;
    static char target = 'G';
    public int solution(String[] board) {
        n = board.length;
        m = board[0].length();
        
        int rRow = 0;
        int rCol = 0;
        
        maze = new char[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                char cur = board[i].charAt(j);
                maze[i][j] = cur;
                if(cur == 'R') {
                    rRow = i;
                    rCol = j;
                }
            }
        }
        
        boolean[][] visited = new boolean[n][m];
        visited[rRow][rCol] = true;
        
        int moveCount = bfs(rRow, rCol, 0, visited);
        return moveCount == -1 ? -1 : moveCount; 
    }
    
    int moveLine(int cr, int cc, int dr, int dc) {
        int nr = cr;
        int nc = cc;
        int count = 0;
        while(!(nr < 0 || nc < 0 || nr >= n || nc >= m)) {
            if(maze[nr][nc] == 'D') break;
            nr += dr;
            nc += dc;
            count++;
        }
        
        return count - 1;
    }
    
    int bfs(int r, int c, int count, boolean[][] visited) {
        
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {r, c, count});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            r = cur[0];
            c = cur[1];
            count = cur[2];
            
            if(maze[r][c] == target) {
                return count;
            }   

            for(int i = 0; i < dc.length; i++) {
                int move = moveLine(r, c, dr[i], dc[i]);
                if(move == 0) continue;
            
                int nr = r + dr[i] * move;
                int nc = c + dc[i] * move;

                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if(visited[nr][nc] || maze[nr][nc] == 'D') continue;
            
                visited[nr][nc] = true;
                q.add(new int[] {nr, nc, count + 1});
            }
        }
        return -1;
    }
}