import java.util.*;
class Solution {
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int n; 
    static int m;
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        String[][] maze = new String[n][m];
        
        int[] startIdx = new int[2];
        int[] leverIdx = new int[2];
        int[] goalIdx = new int[2];
        
        for(int i = 0; i < n; i++) {
            String[] sp = maps[i].split("");
            for(int j = 0; j < sp.length; j++) {
                String cur = sp[j];
                maze[i][j] = cur;
                
                if(cur.equals("S")) {
                    startIdx[0] = i;
                    startIdx[1] = j;
                    continue;
                }
                
                if(cur.equals("L")) {
                    leverIdx[0] = i;
                    leverIdx[1] = j;
                    continue;
                }
                
                if(cur.equals("E")) {
                    goalIdx[0] = i;
                    goalIdx[1] = j;
                }
                
            }
        }
        
        System.out.println(Arrays.toString(leverIdx));

        int toLever = bfs(startIdx[0], startIdx[1], leverIdx[0], leverIdx[1], maze);        
        int toGoal = bfs(leverIdx[0], leverIdx[1], goalIdx[0], goalIdx[1], maze); 
        
        return toLever == -1 || toGoal == -1 ? -1 : toLever + toGoal; 
    }
    
    int bfs(int fRow, int fCol, int tRow, int tCol, String[][] map) {
        boolean visited[][] = new boolean[n][m];
       
        Deque<int[]> q = new ArrayDeque<>();
        visited[fRow][fCol] = true;
        q.add(new int[]{fRow, fCol, 0});
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];
            int move = cur[2];
            
            if(cr == tRow && cc == tCol) {
                return cur[2];
            }
            
            for (int i = 0; i < dr.length; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];
                
                if(nr < 0 || nc < 0 || nr >= n || nc >= m) continue;
                if(map[nr][nc].equals("X") || visited[nr][nc]) continue;
                
                visited[nr][nc] = true;
                q.add(new int[]{nr, nc, move+1});
            }
        }
        return -1;
    }
}