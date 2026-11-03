import java.util.*;

class Solution {
    public int[] solution(int n) {
        
        int[][] snail = new int[n][n];
        
        int last = n * (n + 1) / 2;
        
        int[] dc = {0, 1, -1};
        int[] dr = {1, 0, -1};
        
        int cur = 1;
        snail[0][0] = cur++;
        
        int row = 0;
        int col = 0;
        
        while(cur <= last) {        
            while(row < n) {
                int nr = row + dr[0];
                
                if(nr >= n || snail[nr][col] != 0) break;
                snail[nr][col] = cur++;
                row = nr;
            }
            
            while(col < n) {
                int nc = col + dc[1];
                
                if(nc >= n || snail[row][nc] != 0) break;
                snail[row][nc] = cur++;
                col = nc;
            }
            
            while(row > 0 && col > 0) {
                int nr = row + dr[2];
                int nc = col + dc[2];
                
                if(nr < 0 || nc < 0 || snail[nr][nc] != 0) break;
                snail[nr][nc] = cur++;
                row = nr;
                col = nc;
            }
        }
        
        List<Integer> ls = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                ls.add(snail[i][j]);
            }
        } 
    
        return ls.stream().mapToInt(Integer::intValue).toArray();
    }
}
 