class Solution {
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
            
        return recur(k, 0, dungeons, visited, true);
    }
    
    int recur(int cur, int count, int[][] dungeons, boolean[] visited, boolean hasNext) {
    
        if(!hasNext) {
            return 0;
        }
        
        int[] counts = new int[dungeons.length];
        int travle = count + 1;
        for(int i = 0; i < dungeons.length; i++) {
            if(cur >= dungeons[i][0] && !visited[i]) {
                visited[i] = true;
                counts[i] = travle + recur(cur - dungeons[i][1], count, dungeons, visited, true);
                visited[i] = false;
            }
        }
        int max = 0;
        for(int c : counts) {
            max = Math.max(c,max);
        }
        return max;
    }
}