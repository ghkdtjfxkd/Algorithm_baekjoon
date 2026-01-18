import java.util.*;

class Solution {
    
    int n, m;
    
    boolean[][] visited;
    int[] sum;
    
    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        sum = new int[m];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, land);
                }
            }
        } 
        
        int answer = 0;
        for(int i : sum){
            if(i > answer) {
                answer = i;
            }
        }
        
        return answer;
    
    }
    
    void bfs(int row, int col, int[][] land) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {row, col});
        visited[row][col] = true;
        
        int oilSize = 0;
        Set<Integer> cols = new HashSet<>();
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int r = cur[0];
            int c = cur[1];
            
            oilSize++;
            cols.add(c);
            
            for(int i = 0; i < 4; i++) {
                int nr = r + dx[i];
                int nc = c + dy[i];
                
                if (nr >= 0 && nr < n && nc >= 0 && nc < m) {
                    if (land[nr][nc] == 1 && !visited[nr][nc]) {
                        visited[nr][nc] = true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }   
        }
        
        for (int colIndex : cols) {
            sum[colIndex] += oilSize;
        }   
    }
}
