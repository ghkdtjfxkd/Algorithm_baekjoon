class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = Integer.MAX_VALUE;
        
        for(int i = 0; i < picks.length; i++) {
            if(picks[i] == 0) continue;
            picks[i]--;
            answer = Math.min(dfs(i, picks, 0, 0, minerals), answer);
            picks[i]++;
        }
        return answer;
    }
    
    int fatigue(int pick, int start, String[] minerals) {
        int end = start + 5 > minerals.length ? minerals.length : start + 5; 
        
        int cur = 0;
        if(pick == 0) {
            for(int i = start; i < end; i++) {
                cur+= 1;
            }
        }
        
        if(pick == 1) {
            for(int i = start; i < end; i++) {
                if(minerals[i].equals("diamond")) {
                    cur += 5;
                } else {
                    cur += 1;
                }
            }            
        }
        
        if(pick == 2) {
            for(int i = start; i < end; i++) {
                if(minerals[i].equals("diamond")) {
                    cur += 25;
                } else if(minerals[i].equals("iron")) {
                    cur += 5;
                } else {
                    cur+=1;
                }
            }            
        }
        
        return cur;
    }
    
    int dfs(int pick, int[] picks, int idx, int sum, String[] minerals) {
        if(idx > minerals.length - 1) return sum;
        
        int min = Integer.MAX_VALUE;
        
        int cur = fatigue(pick, idx, minerals);
        boolean hasNext = false;
        for(int i = 0; i < picks.length; i++) {
            if(picks[i] == 0) continue;
            hasNext = true;
            picks[i]--;
            min = Math.min(min, dfs(i, picks, idx + 5, sum + cur, minerals));
            picks[i]++;
        }
        
        if(!hasNext) return sum + cur;
        
        return min;
    }
    
}