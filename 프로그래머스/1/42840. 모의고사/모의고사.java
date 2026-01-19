import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        int[] l1 = {1,2,3,4,5};
        int[] l2 = {2,1,2,3,2,4,2,5};
        int[] l3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[][] ans = new int[3][2];
        
        ans[0][1] = 1;
        ans[1][1] = 2;
        ans[2][1] = 3;
        
        for(int i = 0; i < answers.length; i++) {
            if(l1[i% l1.length] == answers[i]) {
                ans[0][0]++;
            }
            
            if(l2[i% l2.length] == answers[i]) {
                ans[1][0]++;
            }
            
            if(l3[i% l3.length] == answers[i]) {
                ans[2][0]++;
            }
        }
        
        
        Arrays.sort(ans, (o1,o2) -> {
            if(o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o2[0] - o1[0];
        });
        
        int count = (int) Arrays.stream(ans).filter(o -> ans[0][0] == o[0]).count();
        if(count == 1) {
            return new int[] {ans[0][1]};
        } else {
            int[] winners = new int[count];
            for(int i = 0; i  < count; i ++) {
                winners[i] = ans[i][1];
            }
            return winners;
        }
    }
}