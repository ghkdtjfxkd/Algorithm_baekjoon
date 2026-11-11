import java.util.*;
class Solution {
    static int n;
    static int m;
    
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {1, 0, -1, 0};
    static int[][] oils;
    static int chunk;
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        oils = new int[n][m];
        chunk = 1;
        
        List<Integer> sizes = new ArrayList<>();
        sizes.add(0);
        
        boolean[][] visited = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j =0; j < m; j++) {
                if(visited[i][j] || land[i][j] == 0) continue;
                sizes.add(chunk(i, j, land, visited));
                chunk++;
            }
        }
        
        int max = 0;
        for(int i = 0; i < m; i++){
            Set<Integer> sizeIds = new HashSet<>();
            for(int j = 0; j < n; j++) {
                if(oils[j][i] == 0) continue;
                sizeIds.add(oils[j][i]);
            }
            
            int sum =0; 
            for(int id : sizeIds) {
                sum += sizes.get(id);
            }
            max = Math.max(sum, max);
        }

        return max;
    }
    
    int chunk(int r, int c, int[][] land, boolean[][] visited) {
        Deque<int[]> q = new ArrayDeque<>();
        visited[r][c] = true;
        oils[r][c] = chunk;
        q.add(new int[] {r, c});
        
        int count = 1;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            
            for(int i = 0; i < dr.length; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if(nr < 0 || nc < 0 || nr >= n || nc >= m ) continue;
                if(visited[nr][nc] || land[nr][nc] == 0) continue;
                
                visited[nr][nc] = true;
                count++;
                oils[nr][nc] = chunk;
                q.add(new int[] {nr, nc});
            }
        }
        return count;
    }
}