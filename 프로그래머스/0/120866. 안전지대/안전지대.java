class Solution {
    
    static int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
    static int[] dy = {0, -1, 1, 0, -1, 1, 1, -1}; 
    public int solution(int[][] board) {
        
        int n = board.length;
        int m = board[0].length;
        
        int count = 0;
        
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 2 || board[i][j] == 0) continue;
                if(board[i][j] == 1) {
                    for(int k = 0; k< 8; k++) {
                        marking(i + dx[k], j + dy[k], board);
                    }
                }                    
            }
        }
        
        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j++) {
                if(board[i][j] == 1 || board[i][j] == 2) continue;
                if(board[i][j] == 0) {
                   count++;
                }                    
            }
        }
        
        return count;
    }
    
    public void marking(int r, int c, int[][] board) {
        if(r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
            return;
        }
        
        if(board[r][c] == 0) {
            board[r][c] = 2;
        }
    }
}