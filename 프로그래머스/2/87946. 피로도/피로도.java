class Solution {
    static int max;
    static boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        max = 0;
        visited = new boolean[dungeons.length];
        dfs(k, 0, dungeons);
        return max;
    }
    
    public void dfs(int left, int count, int[][] dungeons) {
        max = Math.max(max, count);
        
        for(int i = 0; i < dungeons.length; i++) {
            if(visited[i] || dungeons[i][0] > left) continue;
            
            visited[i] = true;
            dfs(left - dungeons[i][1], count + 1, dungeons);
            visited[i] = false;
        }
    }
}