import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
    
        Queue<Integer> wait = new LinkedList<>();
        
        for (int t : truck_weights) {
            wait.offer(t);
        }
        
        Queue<Integer> bridge = new LinkedList<>();
        
        for(int i = 0; i < bridge_length; i++){
            bridge.offer(0);
        }
        
        int bridgeCur = 0;
        int time = 0; 
        
        while(!bridge.isEmpty()) {
            time++;
            bridgeCur -= bridge.poll();
        
            if(!wait.isEmpty()) {
                if(bridgeCur + wait.peek() <= weight) {
                    int w = wait.poll();
                    bridge.offer(w);
                    bridgeCur += w;
                } else {
                    bridge.offer(0);
                }
            }
        }
        
        return time;
    }
}