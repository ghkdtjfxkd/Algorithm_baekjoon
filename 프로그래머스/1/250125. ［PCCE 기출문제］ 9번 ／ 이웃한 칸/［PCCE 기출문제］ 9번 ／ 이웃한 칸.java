class Solution {
    public int solution(String[][] board, int h, int w) {
        int answer = 0;
        
        int[] dx = {1, 0, -1 , 0};
        int[] dy = {0, 1, 0 , -1};
        
        String target = board[h][w];
        
        for(int i = 0; i < dx.length; i++) {
            int nr = h + dy[i];
            int nc = w + dx[i];
            
            if(nr < 0 || nc < 0 || nr >= board.length || nc >= board[0].length) {
                continue;
            }
            
            if(board[nr][nc].equals(target)) {
                answer++;
            }
        }
        return answer;
    }
}