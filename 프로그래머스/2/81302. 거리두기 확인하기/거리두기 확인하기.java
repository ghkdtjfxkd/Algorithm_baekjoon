import java.util.*;
class Solution {
    
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};
    static char[][] grid;
   
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        grid = new char[5][5];
        
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    grid[j][k] = places[i][j].charAt(k);
                }
            }
            
            boolean exists = false;
            for(int j = 0; j < 5; j++) {
                for(int k = 0; k < 5; k++) {
                    if(grid[j][k] != 'P') continue;
                    if(isAnotherExists(j, k)) {
                        exists = true;
                        break;
                    }
                }
            }
            answer[i] = exists ? 0 : 1;
        }
        
        return answer;
    }
    
    boolean isAnotherExists(int r, int c) {
        boolean[][] visited = new boolean[5][5];
        
        Deque<int[]> q = new ArrayDeque<>();
        q.add(new int[] {r, c});
        visited[r][c] = true;

        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            
            if(grid[cr][cc] == 'P' && !(cr == r && cc == c)) {
                return true;
            }
            
            for(int i = 0; i < dr.length; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                int man = Math.abs(nr - r) + Math.abs(nc - c);  
                    
                if(nr < 0 || nc < 0 || nr >= 5 || nc >= 5) continue;
                if(visited[nr][nc] || grid[nr][nc] == 'X' || man > 2) continue;
                
                visited[nr][nc] = true;
                q.add(new int[] {nr, nc});
            } 
        }
        
        return false;
    }
    
    
}