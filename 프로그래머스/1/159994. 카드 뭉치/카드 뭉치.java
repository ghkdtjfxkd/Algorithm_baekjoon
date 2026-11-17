class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int idx1 = 0;
        int idx2 = 0;
        int idxGoal = 0;
        
        while(idxGoal < goal.length) {
            if(!cards1[idx1].equals(goal[idxGoal]) && !cards2[idx2].equals(goal[idxGoal])) return "No";
        
            if(idx1 < cards1.length - 1 && cards1[idx1].equals(goal[idxGoal]))idx1++;
            if(idx2 < cards2.length - 1 && cards2[idx2].equals(goal[idxGoal])) idx2++;
            idxGoal++;
        }
        
        return "Yes";
    }
}