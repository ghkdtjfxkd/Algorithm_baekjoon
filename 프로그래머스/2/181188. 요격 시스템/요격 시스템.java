import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        Arrays.sort(targets, (o1,o2) -> o1[1] - o2[1]);
        int shot = 0;
        int clear = -1;
        for(int[] se : targets) {
            if(se[0] >= clear) {
                shot++;
                clear = se[1];
            }
        }
        return shot;
    }
}