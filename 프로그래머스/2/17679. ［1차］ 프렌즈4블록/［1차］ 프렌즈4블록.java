import java.util.*;

class Solution {
    
    static char[][] blocks;
    static int[] dr = {0, 1, 1};
    static int[] dc = {1, 0, 1}; 

    public int solution(int m, int n, String[] board) {
        blocks = new char[m][n];
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                blocks[i][j] = board[i].charAt(j);        
            }
        }
        
        int count = 0;
        while(true) {
            boolean sameExists = false;
            boolean[][] checked = new boolean[m][n];
            
            for(int i = 0; i < m - 1; i++) {
                for(int j = 0; j < n -1; j++) {
                    if(blocks[i][j] == '0') continue;
                    if(hasSameBlocks(i, j)) {
                        checkBlocks(i, j, checked);
                        sameExists = true;
                    };   
                }
            }
            
            if(!sameExists) break;
            
            removeBlocks(checked);
            dropBlocks();
        }
        
        for(char[] ch : blocks) {
            for(char c : ch) {
                if(c == '0') count++;
            }
        }
        
        return count;
    }

    
    boolean hasSameBlocks(int r, int c) { 
        for(int i = 0; i < dr.length; i++) {
            if(blocks[r + dr[i]][c + dc[i]] != blocks[r][c]) return false;
        }
        return true;
    }
    
    void checkBlocks(int r, int c, boolean[][] checked) {
        checked[r][c] = true;
        for(int i = 0; i < dr.length; i++) {
            checked[r + dr[i]][c + dc[i]] = true;
        }
    }
    
    void removeBlocks(boolean[][] checked) {
        for(int i = 0; i < checked.length; i++) {
            for(int j = 0; j < checked[0].length; j++) {
                if(checked[i][j]) blocks[i][j] = '0';
            }
        }
    }
    
    void dropBlocks() {
        for(int i = 0; i < blocks[0].length; i++) {
            String pre = "";
            for(int j = 0; j < blocks.length; j++) {
                pre += blocks[j][i];
            }
            String aft = pre.replace("0", "");
            String s = "0".repeat(pre.length() - aft.length()) + aft;
            
            for(int j = 0; j < blocks.length; j++) {
                blocks[j][i] = s.charAt(j);
            }
        }
    }
}