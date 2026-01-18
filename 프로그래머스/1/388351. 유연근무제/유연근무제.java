import java.time.*;
import java.util.Calendar.*;
import java.util.*;

class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        LocalTime[] st = new LocalTime[schedules.length];
        
        for(int i = 0; i < schedules.length; i++) {
            st[i] = toTime(schedules[i]);
        }
        
        for(int i = 0; i < timelogs.length; i++) {
            LocalTime threshold = st[i];
            int success = 0;
            for(int j = 0; j < 7; j++) {
                DayOfWeek d = DayOfWeek.of(startday).plus(j);
                
                if(d == DayOfWeek.SATURDAY || d == DayOfWeek.SUNDAY) {
                    continue;
                }
                
                if(toTime(timelogs[i][j]).isBefore(threshold.plusMinutes(11))) {
                    success++;
                }
            }
            if(success == 5) {
                answer++;
            }
        }
        return answer;
    }
    
    LocalTime toTime(int tv) {
        String t = String.valueOf(tv);
        if(t.length() == 4) {
            String h = t.substring(0,2);
            String m = t.substring(2,4);
            return LocalTime.of(Integer.valueOf(h), Integer.valueOf(m));    
        }
        String h = t.substring(0,1);
        String m = t.substring(1,3);
        return LocalTime.of(Integer.valueOf(h), Integer.valueOf(m));
    }
}