import java.util.*;

class Solution {
    
    static Map<Integer, Node> graph = new HashMap<>();
    
    public int solution(int n, int[][] edge) {
        for(int i= 0; i < edge.length; i++) {
            
            int a = edge[i][0];
            int b = edge[i][1];
            
            if (!graph.containsKey(a)) {
                graph.put(a, new Node(a));
            }
            
            if (!graph.containsKey(b)) {
                graph.put(b, new Node(b));
            }
            
            Node nodeA = graph.get(a);
            Node nodeB = graph.get(b);
            
            nodeA.connected.add(nodeB);
            nodeB.connected.add(nodeA);
        }
        
        return bfs();
    }
    
    
    int bfs() {
        Queue<Node> queue = new LinkedList<>();
        
        Node startNode = graph.get(1);
        
        startNode.visited = true;
        startNode.dep = 0;
        
        int maxDepth = startNode.dep;
        
        queue.add(startNode);
        
        while(!queue.isEmpty()) {
            Node cur = queue.poll();
           
            if (cur.dep > maxDepth) {
                maxDepth = cur.dep;
            }

            for(Node next : cur.connected) {
                if(!next.visited) {
                    next.visited = true;
                    next.dep = cur.dep + 1;
                    queue.add(next);
                }
            }
        }
        
        int count = 0;
        
        for(Integer key : graph.keySet()) {
            if(graph.get(key).dep == maxDepth) {
                count++;
            }
        };
        
        return count;
    }
}

class Node {
    
    public int val;
    public Set<Node> connected;
    public boolean visited;
    public int dep;
    
    public Node (int val) {
        this.val = val;
        this.connected = new HashSet<>();
        this.visited = false;
        this.dep = 0;
    }
}