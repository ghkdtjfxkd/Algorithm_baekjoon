import java.util.*;

class Solution {
    
    List<Integer>[] graph;
    boolean[] visited;
    
    public int solution(int n, int[][] wires) {       
        int answer = Integer.MAX_VALUE;
        
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            graph[v1].add(v2);
            graph[v2].add(v1);
        }
        
        for (int[] wire : wires) {
            int nodeA = wire[0];
            int nodeB = wire[1];

            visited = new boolean[n + 1];

            int countA = dfs(nodeA, nodeB);
            int countB = n - countA;

            int diff = Math.abs(countA - countB);

            answer = Math.min(answer, diff);
        }

        return answer;
    }
    
    private int dfs(int current, int blocked) {
        visited[current] = true;
        int count = 1; 

        for (int neighbor : graph[current]) {
            if (neighbor == blocked || visited[neighbor]) {
                continue;
            }
            count += dfs(neighbor, blocked);
        }
        return count;
    }
}
