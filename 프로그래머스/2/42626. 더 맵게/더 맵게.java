import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i : scoville) pq.offer(i); 
        
        int answer = 0;
        while(pq.peek() < K) {
            // 마지막으로 섞인 녀석
            if(pq.size() == 1) return pq.poll() >= K ? answer + 1 : -1;
            
            int s1 = pq.poll();
            int s2 = pq.poll();
            
            int min = Math.min(s1, s2);
            int max = Math.max(s1, s2);
            answer++;
            pq.offer(min + (max * 2));
        }
        return answer;
    }
}