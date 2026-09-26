import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        
        Deque<Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i < progresses.length; i++) {
            int day = 0;
            int progress = progresses[i];
            while(progress < 100) {
                progress+=speeds[i];
                day++;
            }
            q.add(day);
        }
        
        List<Integer> answer = new ArrayList<>();
        
        while(!q.isEmpty()) {
            int cur = q.poll(); // 맨 앞 작업의 완료일
            int count = 1;
        
            while(!q.isEmpty() && q.peek() <= cur) { 
                // 맨 앞 작업 완료일 이전에 완료된 뒤에 있는 작업들 제거
                q.poll();
                count++;
            }
            
            answer.add(count);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}
