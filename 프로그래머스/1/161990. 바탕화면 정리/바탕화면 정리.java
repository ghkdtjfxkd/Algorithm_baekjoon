class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {51, 51, -1, -1};
        
        for(int i = 0; i < wallpaper.length; i ++) {
            String[] files = wallpaper[i].split("");
            
            for(int k = 0; k < files.length; k++) {
                if(files[k].equals("#")) {
                    
                    if(answer[1] > k) {
                        answer[1] = k;
                    }
                    
                    if(answer[0] > i) {
                        answer[0] = i;
                    }
                    
                    if(answer[3] <= k) {
                        answer[3] = k + 1;
                    }
                    
                    if(answer[2] <= i) {
                        answer[2] = i + 1;
                    }
                }        
            }
            
        }
        return answer;
    }
}