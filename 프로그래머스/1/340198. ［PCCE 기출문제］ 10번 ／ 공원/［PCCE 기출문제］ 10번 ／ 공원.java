import java.util.*;

class Solution {
    public int solution(int[] mats, String[][] park) {
        int n = park.length;
        int m = park[0].length;
                
        boolean[][] covered = new boolean[n][m];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!park[i][j].equals("-1")) {
                    covered[i][j] = true;
                }
            }
        }
        
        Arrays.sort(mats);
        
        for(int matIdx = mats.length-1; matIdx >= 0; matIdx--) {
            int size = mats[matIdx];
            
            for(int r = 0; r <= n - size; r ++) {
                for(int c = 0; c <= m - size; c ++) {
                    if(canPlace(r, c, size, covered)) {
                        return size;
                    }
                }
            }
            
        }
        return -1;
    }
    
    private boolean canPlace(int r, int c, int size, boolean[][] covered) {
        for(int i = r; i < r + size; i++) {
            for(int j = c; j < c + size; j++) {
                if(covered[i][j]) {
                    return false;
                }
            }
        }
    
        return true;
    }
}