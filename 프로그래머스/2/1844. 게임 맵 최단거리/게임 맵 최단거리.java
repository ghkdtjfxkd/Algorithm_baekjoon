import java.util.*;

class Solution {
    
    static int n;
    static int m;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        
        return bfs(0, 0, maps);
    }
    
    public static int bfs(int row, int col, int[][] maps) {
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[n][m];
        
        q.add(new int[] {row, col});
        visited[row][col] = true;
        
        while(!q.isEmpty()) {
            
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            
            if(cr == n -1 && cc == m -1)  return maps[cr][cc];
            
            
            for(int i = 0; i < 4; i++) {
                int nr = cr + dx[i];
                int nc = cc + dy[i];
                 
                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if(maps[nr][nc] == 0 || visited[nr][nc]) continue;
                
                maps[nr][nc] = maps[cr][cc] + 1; 
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc});
            }
        }
        return -1;
    }
}